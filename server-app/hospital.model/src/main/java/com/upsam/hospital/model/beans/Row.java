package com.upsam.hospital.model.beans;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

// TODO: Auto-generated Javadoc
/**
 * The Class Row.
 */
@Entity
@Table(name = "ROW")
public class Row implements IModelHospital {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -844048965044155217L;

	/** The fields. */
	@OneToMany(mappedBy = "row")
	@Cascade(value = CascadeType.SAVE_UPDATE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Field> fields;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ROW")
	private Integer id;

	/** The tabla datos. */
	@ManyToOne
	@Cascade(value = CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "ID_TABLA_DATOS")
	private TablaDatos tablaDatos;

	/**
	 * Adds the field.
	 * 
	 * @param field
	 *            the field
	 */
	public void addField(Field field) {
		if (this.getFields() == null) {
			this.setFields(new ArrayList<Field>());
		}
		this.getFields().add(field);
	}

	/**
	 * Gets the fields.
	 * 
	 * @return the fields
	 */
	public List<Field> getFields() {
		return fields;
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
	 * Gets the tabla datos.
	 * 
	 * @return the tabla datos
	 */
	public TablaDatos getTablaDatos() {
		return tablaDatos;
	}

	/**
	 * Sets the fields.
	 * 
	 * @param fields
	 *            the new fields
	 */
	public void setFields(List<Field> fields) {
		this.fields = fields;
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
	 * Sets the tabla datos.
	 * 
	 * @param tablaDatos
	 *            the new tabla datos
	 */
	public void setTablaDatos(TablaDatos tablaDatos) {
		this.tablaDatos = tablaDatos;
	}

}
