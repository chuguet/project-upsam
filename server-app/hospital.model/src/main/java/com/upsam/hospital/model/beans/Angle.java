package com.upsam.hospital.model.beans;

import java.util.ArrayList;
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
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

// TODO: Auto-generated Javadoc
/**
 * The Class Row.
 */
@Entity
@Table(name = "ANGLE")
public class Angle implements IModelHospital {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -844048965044155217L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ROW")
	private Integer id;

	/** The name. */
	@Basic
	@Column(name = "NAME")
	private String name;

	/** The fields. */
	@OneToMany(mappedBy = "angle")
	@Cascade(value = CascadeType.SAVE_UPDATE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Point> points;

	/** The tabla datos. */
	@ManyToOne
	@Cascade(value = CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "ID_TABLA_DATOS")
	private TablaDatos tablaDatos;

	/**
	 * Adds the field.
	 * 
	 * @param point
	 *            the point
	 */
	public void addPoint(Point point) {
		if (this.getPoints() == null) {
			this.setPoints(new ArrayList<Point>());
		}
		this.getPoints().add(point);
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
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the points.
	 * 
	 * @return the points
	 */
	public List<Point> getPoints() {
		return points;
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
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the points.
	 * 
	 * @param points
	 *            the new points
	 */
	public void setPoints(List<Point> points) {
		this.points = points;
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
