package uk.co.meridenspares.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="section")
@NamedQueries({
	@NamedQuery(name="Section.getSectionItems", query="select si from SectionItem si where si.section=:section")
})
public class Section implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="diag_id")
	private Integer diagId;
	
	@ManyToMany
	@JoinTable(name="model_section",
			joinColumns = {@JoinColumn(name="section_id")},
			inverseJoinColumns = {@JoinColumn(name="model_id")})
	private List<Section> models = new ArrayList<Section>();

	/*
	 * Note that 2 'fetch=FetchType.EAGER' attributes on OneToManys gives JPA parsing problem ->
	 * 			org.hibernate.loader.MultipleBagFetchException: cannot simultaneously fetch multiple bags
	 * - May get around it returning Sets rather than Lists?
	 * - Also may get around it using Hibernate @LazyCollection(LazyCollectionOption.FALSE) annotation?
	 */
	@OneToMany(mappedBy="section",
				targetEntity=SectionItem.class,
				cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<SectionItem> sectionItems = new ArrayList<SectionItem>();
	
	/**
	 * @return the id
	 */
	public final Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public final void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public final String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public final void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the diagId
	 */
	public final int getDiagId() {
		return diagId;
	}

	/**
	 * @param diagId the diagId to set
	 */
	public final void setDiagId(int diagId) {
		this.diagId = diagId;
	}

	/**
	 * @return the models
	 */
	public final List<Section> getModels() {
		return models;
	}

	/**
	 * @param models the models to set
	 */
	public final void setModels(List<Section> models) {
		this.models = models;
	}

	/**
	 * @return the sectionItems
	 */
	public final List<SectionItem> getSectionItems() {
		return sectionItems;
	}

	/**
	 * @param sectionItems the sectionItems to set
	 */
	public final void setSectionItems(List<SectionItem> sectionItems) {
		this.sectionItems = sectionItems;
	}
	
	/**
	 * Override of toString method.
	 */
	@Override
	public String toString() {
		return title;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		Section other = (Section) obj;
		
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		}
		else if (!id.equals(other.id)) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		}
		else if (!title.equals(other.title)) {
			return false;
		}
		return true;
	}

}
