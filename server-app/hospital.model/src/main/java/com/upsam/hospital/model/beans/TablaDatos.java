package com.upsam.hospital.model.beans;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

// TODO: Auto-generated Javadoc
/**
 * The Class TablaDatos.
 */
@Entity
@Table(name = "TABLA_DATOS")
public class TablaDatos implements IModelHospital {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -344787572420124374L;

	/** The exploracion3 d. */
	@OneToOne
	@Cascade(value = CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "ID_FICHERO_EMT")
	private FicheroEMT ficheroEMT;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TABLA_DATOS")
	private Integer id;

	/** The rows. */
	@OneToMany(mappedBy = "tablaDatos")
	@Cascade(value = CascadeType.SAVE_UPDATE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Row> rows;

	/**
	 * Adds the row.
	 * 
	 * @param row
	 *            the row
	 */
	public void addRow(Row row) {
		if (this.getRows() == null) {
			this.setRows(new ArrayList<Row>());
		}
		this.getRows().add(row);
	}

	/**
	 * Gets the fichero emt.
	 * 
	 * @return the fichero emt
	 */
	public FicheroEMT getFicheroEMT() {
		return ficheroEMT;
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
	 * Gets the rows.
	 * 
	 * @return the rows
	 */
	public List<Row> getRows() {
		return rows;
	}

	/**
	 * Sets the fichero emt.
	 * 
	 * @param ficheroEMT
	 *            the new fichero emt
	 */
	public void setFicheroEMT(FicheroEMT ficheroEMT) {
		this.ficheroEMT = ficheroEMT;
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
	 * Sets the rows.
	 * 
	 * @param rows
	 *            the new rows
	 */
	public void setRows(List<Row> rows) {
		this.rows = rows;
	}

}
