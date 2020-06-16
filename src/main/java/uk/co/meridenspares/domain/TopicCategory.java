package uk.co.meridenspares.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @author User
 */
@Entity
@Table(name = "topiccategory")
public class TopicCategory implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="parent_category_id")
	private TopicCategory parentCategory;
	
	@Column(name="description")
	private String description;
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY, mappedBy="parentCategory")
	private Set<TopicCategory> childCategories = new HashSet<TopicCategory>();

	public Long getId() {
		return this.id;
	}

	public TopicCategory getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(TopicCategory parentCategory) {
		this.parentCategory = parentCategory;
	}

	public Set<TopicCategory> getChildCategories() {
		return childCategories;
	}

	public void setChildCategories(Set<TopicCategory> childCategories) {
		this.childCategories = childCategories;
	}

	/**
	 * @return the description
	 */
	public final String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public final void setDescription(String description) {
		this.description = description;
	}

}
