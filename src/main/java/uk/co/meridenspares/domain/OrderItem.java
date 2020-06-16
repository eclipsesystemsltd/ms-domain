package uk.co.meridenspares.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * An item in a customer order.
 */
@Entity
@Table(name="orderitem")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name="customerorder_id")
	private CustomerOrder customerOrder;

	@OneToOne
	@JoinColumn(name="part_id")
	private Part part;

	@Column(name="price")
	private double price;

	@Column(name="quantity")
	private int quantity;

	/**
	 * @return the order
	 */
	public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}

	/**
	 * @return the part
	 */
	public Part getPart() {
		return part;
	}

	/**
	 * @param part - the part to set
	 */
	public void setPart(final Part part) {
		this.part = part;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price - the price to set
	 */
	public void setPrice(final double price) {
		this.price = price;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity - the quantity to set
	 */
	public void setQuantity(final int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
}
