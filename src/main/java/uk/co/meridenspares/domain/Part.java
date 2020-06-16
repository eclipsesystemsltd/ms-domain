package uk.co.meridenspares.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="part")
public class Part extends StockItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="altpartnumber")
	private String alternativePartNumber;
	
	@Column(name="altpartmanufacturer")
	private String alternativePartManufacturer;
	
	/**
	 * @return the alternativePartNumber
	 */
	public final String getAlternativePartNumber() {
		return alternativePartNumber;
	}
	
	/**
	 * @param alternativePartNumber - the alternativePartNumber to set
	 */
	public final void setAlternativePartNumber(final String alternativePartNumber) {
		this.alternativePartNumber = alternativePartNumber;
	}
	
	/**
	 * @return the alternativePartManufacturer
	 */
	public final String getAlternativePartManufacturer() {
		return alternativePartManufacturer;
	}
	
	/**
	 * @param alternativePartManufacturer - the alternativePartManufacturer to set
	 */
	public final void setAlternativePartManufacturer(
			final String alternativePartManufacturer) {
		this.alternativePartManufacturer = alternativePartManufacturer;
	}
}
