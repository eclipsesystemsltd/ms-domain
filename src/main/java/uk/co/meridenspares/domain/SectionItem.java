package uk.co.meridenspares.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author user
 *
 */
@Entity
@Table(name="sectionitem")
public class SectionItem extends StockItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="line")
	private Integer line;
	
	@Column(name="ref")
	private String ref;
	
	@Column(name="altpartnumber")
	private String altPartNumber;
	
	@Column(name="altmanupartnumber")
	private String altManuPartNumber;
	
	@Column(name="altmanuname")
	private String altManuName;
	
	@Column(name="quantity")
	private String quantity;
	
	@Column(name="referenceonly")
	private Integer referenceOnly;
	
	@Column(name="optional")
	private Integer Optional;
	
	@Column(name="directive")
	private String directive;
	
	@Column(name="directivevalue")
	private String directiveValue;
	
	@Column(name="variantstring")
	private String variantString;
	
	@Column(name="isassembly")
	private Integer isAssembly;
	
	@Column(name="inassembly")
	private Integer inAssembly;
	
	@Column(name="assemblylevel")
	private Integer assemblyLevel;

	@ManyToOne
	@JoinColumn(name="section_id")
	private Section section;
	
	@ManyToOne
	@JoinColumn(name="part_id")
	private Part part;

	/**
	 * @return the line
	 */
	public final Integer getLine() {
		return line;
	}

	/**
	 * @param line the line to set
	 */
	public final void setLine(Integer line) {
		this.line = line;
	}

	/**
	 * @return the ref
	 */
	public final String getRef() {
		return ref;
	}

	/**
	 * @param ref the ref to set
	 */
	public final void setRef(String ref) {
		this.ref = ref;
	}

	/**
	 * @return the altPartNumber
	 */
	public final String getAltPartNumber() {
		return altPartNumber;
	}

	/**
	 * @param altPartNumber the altPartNumber to set
	 */
	public final void setAltPartNumber(String altPartNumber) {
		this.altPartNumber = altPartNumber;
	}

	/**
	 * @return the altManuPartNumber
	 */
	public final String getAltManuPartNumber() {
		return altManuPartNumber;
	}

	/**
	 * @param altManuPartNumber the altManuPartNumber to set
	 */
	public final void setAltManuPartNumber(String altManuPartNumber) {
		this.altManuPartNumber = altManuPartNumber;
	}

	/**
	 * @return the altManuName
	 */
	public final String getAltManuName() {
		return altManuName;
	}

	/**
	 * @param altManuName the altManuName to set
	 */
	public final void setAltManuName(String altManuName) {
		this.altManuName = altManuName;
	}

	/**
	 * @return the quantity
	 */
	public final String getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public final void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the referenceOnly
	 */
	public final Integer getReferenceOnly() {
		return referenceOnly;
	}

	/**
	 * @param referenceOnly the referenceOnly to set
	 */
	public final void setReferenceOnly(Integer referenceOnly) {
		this.referenceOnly = referenceOnly;
	}

	/**
	 * @return the optional
	 */
	public final Integer getOptional() {
		return Optional;
	}

	/**
	 * @param optional the optional to set
	 */
	public final void setOptional(Integer optional) {
		Optional = optional;
	}

	/**
	 * @return the directive
	 */
	public final String getDirective() {
		return directive;
	}

	/**
	 * @param directive the directive to set
	 */
	public final void setDirective(String directive) {
		this.directive = directive;
	}

	/**
	 * @return the directiveValue
	 */
	public final String getDirectiveValue() {
		return directiveValue;
	}

	/**
	 * @param directiveValue the directiveValue to set
	 */
	public final void setDirectiveValue(String directiveValue) {
		this.directiveValue = directiveValue;
	}

	/**
	 * @return the variantString
	 */
	public final String getVariantString() {
		return variantString;
	}

	/**
	 * @param variantString the variantString to set
	 */
	public final void setVariantString(String variantString) {
		this.variantString = variantString;
	}

	/**
	 * @return the isAssembly
	 */
	public final Integer getIsAssembly() {
		return isAssembly;
	}

	/**
	 * @param isAssembly the isAssembly to set
	 */
	public final void setIsAssembly(Integer isAssembly) {
		this.isAssembly = isAssembly;
	}

	/**
	 * @return the inAssembly
	 */
	public final Integer getInAssembly() {
		return inAssembly;
	}

	/**
	 * @param inAssembly the inAssembly to set
	 */
	public final void setInAssembly(Integer inAssembly) {
		this.inAssembly = inAssembly;
	}

	/**
	 * @return the assemblyLevel
	 */
	public final Integer getAssemblyLevel() {
		return assemblyLevel;
	}

	/**
	 * @param assemblyLevel the assemblyLevel to set
	 */
	public final void setAssemblyLevel(Integer assemblyLevel) {
		this.assemblyLevel = assemblyLevel;
	}

	/**
	 * @return the section
	 */
	public final Section getSection() {
		return section;
	}

	/**
	 * @param section the section to set
	 */
	public final void setSection(Section section) {
		this.section = section;
	}

	/**
	 * @return the part
	 */
	public final Part getPart() {
		return part;
	}

	/**
	 * @param part the part to set
	 */
	public final void setPart(Part part) {
		this.part = part;
	}

}
