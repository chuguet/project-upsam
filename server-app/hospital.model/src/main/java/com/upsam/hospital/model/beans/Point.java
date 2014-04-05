package com.upsam.hospital.model.beans;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

// TODO: Auto-generated Javadoc
/**
 * The Class Field.
 */
@Entity
@Table(name = "POINT")
public class Point implements IModelHospital {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -844048965044155217L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_POINT")
	private Integer id;

	/** The angle. */
	@ManyToOne
	@Cascade(value = CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "ID_ANGLE")
	private Angle angle;

	/** The coord. */
	@Basic
	@Column(name = "COORD")
	private String coord;

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
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
	 * Gets the angle.
	 * 
	 * @return the angle
	 */
	public Angle getAngle() {
		return angle;
	}

	/**
	 * Sets the angle.
	 * 
	 * @param angle
	 *            the new angle
	 */
	public void setAngle(Angle angle) {
		this.angle = angle;
	}

	/**
	 * Gets the coord.
	 * 
	 * @return the coord
	 */
	public String getCoord() {
		return coord;
	}

	/**
	 * Sets the coord.
	 * 
	 * @param coord
	 *            the new coord
	 */
	public void setCoord(String coord) {
		this.coord = coord;
	}

}
