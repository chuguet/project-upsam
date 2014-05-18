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
@Table(name = "PAGINA")
public class Pagina implements IModelHospital {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8095085880797559530L;

	/** The sintomas. */
	@OneToMany(mappedBy = "pagina")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Campo> campos;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PAGINA")
	private Integer id;

	/** The info page. */
	@Basic
	@Column(name = "INFO_PAGE")
	private Boolean infoPage;

	/** The parte. */
	@Basic
	@Column(name = "NOMBRE")
	private String nombre;

	/**
	 * Gets the campos.
	 * 
	 * @return the campos
	 */
	public List<Campo> getCampos() {
		return campos;
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
	 * Gets the info page.
	 * 
	 * @return the info page
	 */
	public Boolean getInfoPage() {
		return infoPage;
	}

	/**
	 * Gets the nombre.
	 * 
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the campos.
	 * 
	 * @param campos
	 *            the new campos
	 */
	public void setCampos(List<Campo> campos) {
		this.campos = campos;
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
	 * Sets the info page.
	 * 
	 * @param infoPage
	 *            the new info page
	 */
	public void setInfoPage(Boolean infoPage) {
		this.infoPage = infoPage;
	}

	/**
	 * Sets the nombre.
	 * 
	 * @param nombre
	 *            the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
