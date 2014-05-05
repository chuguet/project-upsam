package com.upsam.hospital.model.beans;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

// TODO: Auto-generated Javadoc
/**
 * The Class Sintoma.
 */
@Entity
@Table(name = "SINTOMA")
public class Sintoma implements IModelHospital {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -327851549309517586L;

	/** The faqs. */
	@OneToMany(mappedBy = "sintoma")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Faq> faqs;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SINTOMA")
	private Integer id;

	/** The parte cuerpo. */
	@ManyToOne
	@JoinColumn(name = "ID_PARTE_CUERPO")
	private ParteCuerpo parteCuerpo;

	/** The sintoma. */
	@Basic
	@Column(name = "SINTOMA")
	private String sintoma;

	/**
	 * Instantiates a new sintoma.
	 */
	public Sintoma() {
		super();
	}

	/**
	 * Instantiates a new sintoma.
	 * 
	 * @param id
	 *            the id
	 */
	public Sintoma(Integer id) {
		super();
		this.id = id;
	}

	/**
	 * Gets the faqs.
	 * 
	 * @return the faqs
	 */
	public List<Faq> getFaqs() {
		return faqs;
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
	 * Gets the parte cuerpo.
	 * 
	 * @return the parte cuerpo
	 */
	public ParteCuerpo getParteCuerpo() {
		return parteCuerpo;
	}

	/**
	 * Gets the sintoma.
	 * 
	 * @return the sintoma
	 */
	public String getSintoma() {
		return sintoma;
	}

	/**
	 * Sets the faqs.
	 * 
	 * @param faqs
	 *            the new faqs
	 */
	public void setFaqs(List<Faq> faqs) {
		this.faqs = faqs;
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
	 * Sets the parte cuerpo.
	 * 
	 * @param parteCuerpo
	 *            the new parte cuerpo
	 */
	public void setParteCuerpo(ParteCuerpo parteCuerpo) {
		this.parteCuerpo = parteCuerpo;
	}

	/**
	 * Sets the sintoma.
	 * 
	 * @param sintoma
	 *            the new sintoma
	 */
	public void setSintoma(String sintoma) {
		this.sintoma = sintoma;
	}
}
