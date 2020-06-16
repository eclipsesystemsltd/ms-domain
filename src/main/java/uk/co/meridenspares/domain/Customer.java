package uk.co.meridenspares.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="customer")
@NamedQueries({
	@NamedQuery(name="Customer.getCustomerByEmail", query="select c from Customer c where c.email=:email")
})
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="customer_id")
	private Integer customerId;
	
	@Column(name="title")
	private String title = "";
	
	@Column(name="first_name")
	private String firstName = "";
	
	@Column(name="last_name")
	private String lastName = "";
	
	@Column(name="phone")
	private String phone = "";
	
	@Column(name="mobile")
	private String mobile = "";
	
	@Column(name="address_first_line")
	private String addressFirstLine = "";
	
	@Column(name="address_second_line")
	private String addressSecondLine = "";
	
	@Column(name="town")
	private String town = "";
	
	@Column(name="county")
	private String county = "";
	
	@Column(name="postcode")
	private String postcode = "";
	
	@Column(name="email")
	private String email = "";
	
	@Column(name="password")
	private String password = "";
	
	@Column(name="status")
	private int status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="last_modified_by")
	private String lastModifiedBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_modified_date")
	private Date lastModifiedDate;

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
	 * @return the customerId
	 */
	public final Integer getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public final void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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
	 * @return the firstName
	 */
	public final String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public final String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the phone
	 */
	public final String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public final void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the mobile
	 */
	public final String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public final void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the addressFirstLine
	 */
	public final String getAddressFirstLine() {
		return addressFirstLine;
	}

	/**
	 * @param addressFirstLine the addressFirstLine to set
	 */
	public final void setAddressFirstLine(String addressFirstLine) {
		this.addressFirstLine = addressFirstLine;
	}

	/**
	 * @return the addressSecondLine
	 */
	public final String getAddressSecondLine() {
		return addressSecondLine;
	}

	/**
	 * @param addressSecondLine the addressSecondLine to set
	 */
	public final void setAddressSecondLine(String addressSecondLine) {
		this.addressSecondLine = addressSecondLine;
	}

	/**
	 * @return the town
	 */
	public final String getTown() {
		return town;
	}

	/**
	 * @param town the town to set
	 */
	public final void setTown(String town) {
		this.town = town;
	}

	/**
	 * @return the county
	 */
	public final String getCounty() {
		return county;
	}

	/**
	 * @param county the county to set
	 */
	public final void setCounty(String county) {
		this.county = county;
	}

	/**
	 * @return the postcode
	 */
	public final String getPostcode() {
		return postcode;
	}

	/**
	 * @param postcode the postcode to set
	 */
	public final void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 * @return the email
	 */
	public final String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public final void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public final String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public final void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the status
	 */
	public final int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public final void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the createdDate
	 */
	public final Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public final void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the createdBy
	 */
	public final String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public final void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the lastModifiedBy
	 */
	public final String getLastModifiedBy() {
		return lastModifiedBy;
	}

	/**
	 * @param lastModifiedBy the lastModifiedBy to set
	 */
	public final void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	/**
	 * @return the lastModifiedDate
	 */
	public final Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	/**
	 * @param lastModifiedDate the lastModifiedDate to set
	 */
	public final void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
}
