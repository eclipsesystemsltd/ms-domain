package uk.co.meridenspares.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="model")
@NamedQueries({
	@NamedQuery(name="Model.getModelYears", query="select distinct firstYear from Model"),
	@NamedQuery(name="Model.getModelsForYear", query="select m from Model m where m.firstYear=:year"),
	@NamedQuery(name="Model.findModelByName", query="select distinct m from Model m where m.name=:name and m.firstYear=:year")
})
public class Model implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="first_year")
	private int firstYear;
	
	@Column(name="last_year")
	private int lastYear;
	
	@ManyToOne
	@JoinColumn(name="modelrange_id")
	private ModelRange modelRange;
	
	@Column(name="capacity")
	private Integer capacity;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="model_section",
			joinColumns = {@JoinColumn(name="model_id")},
			inverseJoinColumns = {@JoinColumn(name="section_id")})
	private List<Section> sections = new ArrayList<Section>();

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
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the firstYear
	 */
	public final int getFirstYear() {
		return firstYear;
	}

	/**
	 * @param firstYear the firstYear to set
	 */
	public final void setFirstYear(int firstYear) {
		this.firstYear = firstYear;
	}

	/**
	 * @return the lastYear
	 */
	public final int getLastYear() {
		return lastYear;
	}

	/**
	 * @param lastYear the lastYear to set
	 */
	public final void setLastYear(int lastYear) {
		this.lastYear = lastYear;
	}

	/**
	 * @return the modelRange
	 */
	public final ModelRange getModelRange() {
		return modelRange;
	}

	/**
	 * @param modelRange the modelRange to set
	 */
	public final void setModelRange(ModelRange modelRange) {
		this.modelRange = modelRange;
	}

	/**
	 * @return the capacity
	 */
	public final Integer getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity the capacity to set
	 */
	public final void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	/**
	 * @return the sections
	 */
	public final List<Section> getSections() {
		return sections;
	}

	/**
	 * @param sections the sections to set
	 */
	public final void setSections(List<Section> sections) {
		this.sections = sections;
	}
	
	/**
	 * Override of toString method.
	 */
	@Override
	public String toString() {
		return name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((capacity == null) ? 0 : capacity.hashCode());
		result = prime * result + firstYear;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + lastYear;
		result = prime * result
				+ ((modelRange == null) ? 0 : modelRange.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((sections == null) ? 0 : sections.hashCode());
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
		
		Model other = (Model) obj;
		
		if (capacity == null) {
			if (other.capacity != null) {
				return false;
			}
		}
		else if (!capacity.equals(other.capacity)) {
			return false;
		}
		if (firstYear != other.firstYear) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		}
		else if (!id.equals(other.id)) {
			return false;
		}
		if (lastYear != other.lastYear) {
			return false;
		}
		if (modelRange == null) {
			if (other.modelRange != null) {
				return false;
			}
		}
		else if (!modelRange.equals(other.modelRange)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		}
		else if (!name.equals(other.name)) {
			return false;
		}
		if (sections == null) {
			if (other.sections != null) {
				return false;
			}
		}
		else if (!sections.equals(other.sections)) {
			return false;
		}
		return true;
	}


}
