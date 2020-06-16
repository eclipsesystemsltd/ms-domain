package uk.co.meridenspares.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * A customer order.
 */
@Entity
@Table(name="customerorder")
public class CustomerOrder implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="customer")
	private String customer;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="customerorder_id")
	private Collection<OrderItem> items = new LinkedHashSet<OrderItem>();

	/**
	 * @return the customer
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * @param customer - the customer to set
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	/**
	 * @return the ordered items
	 */
	public Collection<OrderItem> getItems() {
		return items;
	}

	/**
	 * @param items - the items to set
	 */
	public void setItems(Collection<OrderItem> items) {
		this.items = items;
	}
	
	/**
	 * @return the created date
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate - the created date to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
}
