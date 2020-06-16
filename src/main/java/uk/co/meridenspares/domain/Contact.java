package uk.co.meridenspares.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="contact")
public class Contact implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@NotEmpty(message="{validation.name.NotEmpty.message}")
	@Size(min=3, max=50, message="{validation.name.Size.message}")
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
	@DateTimeFormat(iso=ISO.DATE)
	@Column(name="created_date")
	private DateTime createdDate;
	
	@Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
	@DateTimeFormat(iso=ISO.DATE)
	@Column(name="last_contacted_date")
	private DateTime lastContactedDate;
	
	@Basic(fetch=FetchType.LAZY)
	@Lob
	@Column(name="photo")
	private byte[] photo;
	
	@Version
	@Column(name="version")
	private int version;

	/**
	 * @return the id
	 */
	public final Long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param id the id to set
	 */
	public final void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param name the name to set
	 */
	public final void setName(String name) {
		this.name = name;
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

	/**
	 * @return the createdDate
	 */
	public final DateTime getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public final void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the lastContactedDate
	 */
	public final DateTime getLastContactedDate() {
		return lastContactedDate;
	}

	/**
	 * @param lastContactedDate the lastContactedDate to set
	 */
	public final void setLastContactedDate(DateTime lastContactedDate) {
		this.lastContactedDate = lastContactedDate;
	}

	/**
	 * @return the photo
	 */
	public final byte[] getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public final void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	/**
	 * @return the version
	 */
	public final int getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public final void setVersion(int version) {
		this.version = version;
	}

	/**
	 * Returns formatted version of last contacted date.
	 * @return
	 */
	@Transient
	public String getLastContactedDateString() {
		String lastContactedDateString = "";
		
		if (lastContactedDate != null) {
			lastContactedDateString = org.joda.time.format.DateTimeFormat.forPattern("dd-MM-year").print(lastContactedDate);
		}
		
		return lastContactedDateString;
	}
	
	@Override
	public String toString() {
		String str = "ID=" + id + ", Name=" + name + ", Description=" + description;
		return str;
	}
}
