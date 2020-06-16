package uk.co.meridenspares.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author user
 *
 */
@Entity
@Table(name="accessoryitem")
public class AccessoryItem extends StockItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="name")
	private String name;
	
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
}
