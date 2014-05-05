package com.upsam.hospital.model.beans;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

// TODO: Auto-generated Javadoc
/**
 * The Class ParteCuerpo.
 */
@Entity
@Table(name = "PARTE_CUERPO")
public class ParteCuerpo implements IModelHospital {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8095085880797559530L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PARTE_CUERPO")
	private Integer id;

	/** The parte. */
	@Basic
	@Column(name = "PARTE")
	private String parte;

	/** The sintomas. */
	@OneToMany(mappedBy = "parteCuerpo")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Sintoma> sintomas;

	/**
	 * Instantiates a new parte cuerpo.
	 */
	public ParteCuerpo() {
		super();
	}

	/**
	 * Instantiates a new parte cuerpo.
	 * 
	 * @param id
	 *            the id
	 */
	public ParteCuerpo(Integer id) {
		super();
		this.id = id;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Gets the parte.
	 * 
	 * @return the parte
	 */
	public String getParte() {
		return parte;
	}

	/**
	 * Gets the sintomas.
	 * 
	 * @return the sintomas
	 */
	public List<Sintoma> getSintomas() {
		return sintomas;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Sets the parte.
	 * 
	 * @param parte
	 *            the new parte
	 */
	public void setParte(String parte) {
		this.parte = parte;
	}

	/**
	 * Sets the sintomas.
	 * 
	 * @param sintomas
	 *            the new sintomas
	 */
	public void setSintomas(List<Sintoma> sintomas) {
		this.sintomas = sintomas;
	}

}
