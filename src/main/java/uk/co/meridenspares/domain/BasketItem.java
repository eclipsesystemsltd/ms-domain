package uk.co.meridenspares.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * An item in a shopping basket.
 */
@Entity
@Table(name="basketitem")
public class BasketItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name="basket_id")
	private Basket basket;

	@OneToOne
	@JoinColumn(name="stockitem_id")
	private StockItem stockItem;

	@Column(name="quantity")
	private int quantity;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public final void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the basket
	 */
	public Basket getBasket() {
		return basket;
	}

	/**
	 * @param basket the basket to set
	 */
	public final void setBasket(Basket basket) {
		this.basket = basket;
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
	 * @param quantity - the quantity to add
	 */
	public void addQuantity(final int quantity) {
		this.quantity += quantity;
	}

	/**
	 * @param quantity - the quantity to remove
	 */
	public void removeQuantity(final int quantity) {
		this.quantity -= quantity;
		
		if (this.quantity < 0) {
			this.quantity = 0;
		}
	}

	/**
	 * @return the stockItem
	 */
	public final StockItem getStockItem() {
		return stockItem;
	}

	/**
	 * @param stockItem the stockItem to set
	 */
	public final void setStockItem(StockItem stockItem) {
		this.stockItem = stockItem;
	}
}
