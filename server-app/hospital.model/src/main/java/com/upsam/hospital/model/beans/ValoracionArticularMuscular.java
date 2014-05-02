package com.upsam.hospital.model.beans;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionArticularMuscular.
 */
@Entity
@Table(name = "VALORACION_ARTICULAR_MUSCULAR")
public class ValoracionArticularMuscular implements IModelHospital {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2468655820192248547L;

	/** The exploracion. */
	@OneToOne
	@JoinColumn(name = "ID_EXPLORACION", unique = true)
	private Exploracion exploracion;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_VALORACION_ARTICULAR_MUSCULAR")
	private Integer id;

	/** The var_1_1. */
	@Basic
	@Column(name = "VAR_1_1")
	private String var_1_1;

	/** The var_1_2. */
	@Basic
	@Column(name = "VAR_1_2")
	private String var_1_2;

	/** The var_1_3. */
	@Basic
	@Column(name = "VAR_1_3")
	private String var_1_3;

	/** The var_1_4. */
	@Basic
	@Column(name = "VAR_1_4")
	private String var_1_4;

	/** The var_1_5. */
	@Basic
	@Column(name = "VAR_1_5")
	private String var_1_5;

	/** The var_1_6. */
	@Basic
	@Column(name = "VAR_1_6")
	private String var_1_6;

	/** The var_10_1. */
	@Basic
	@Column(name = "VAR_10_1")
	private String var_10_1;

	/** The var_10_2. */
	@Basic
	@Column(name = "VAR_10_2")
	private String var_10_2;

	/** The var_10_3. */
	@Basic
	@Column(name = "VAR_10_3")
	private String var_10_3;

	/** The var_10_4. */
	@Basic
	@Column(name = "VAR_10_4")
	private String var_10_4;

	/** The var_10_5. */
	@Basic
	@Column(name = "VAR_10_5")
	private String var_10_5;

	/** The var_10_6. */
	@Basic
	@Column(name = "VAR_10_6")
	private String var_10_6;

	/** The var_11_1. */
	@Basic
	@Column(name = "VAR_11_1")
	private String var_11_1;

	/** The var_11_2. */
	@Basic
	@Column(name = "VAR_11_2")
	private String var_11_2;

	/** The var_11_3. */
	@Basic
	@Column(name = "VAR_11_3")
	private String var_11_3;

	/** The var_11_4. */
	@Basic
	@Column(name = "VAR_11_4")
	private String var_11_4;

	/** The var_11_5. */
	@Basic
	@Column(name = "VAR_11_5")
	private String var_11_5;

	/** The var_11_6. */
	@Basic
	@Column(name = "VAR_11_6")
	private String var_11_6;

	/** The var_12_1. */
	@Basic
	@Column(name = "VAR_12_1")
	private String var_12_1;

	/** The var_12_2. */
	@Basic
	@Column(name = "VAR_12_2")
	private String var_12_2;

	/** The var_12_3. */
	@Basic
	@Column(name = "VAR_12_3")
	private String var_12_3;

	/** The var_12_4. */
	@Basic
	@Column(name = "VAR_12_4")
	private String var_12_4;

	/** The var_12_5. */
	@Basic
	@Column(name = "VAR_12_5")
	private String var_12_5;

	/** The var_12_6. */
	@Basic
	@Column(name = "VAR_12_6")
	private String var_12_6;

	/** The var_13_1. */
	@Basic
	@Column(name = "VAR_13_1")
	private String var_13_1;

	/** The var_13_2. */
	@Basic
	@Column(name = "VAR_13_2")
	private String var_13_2;

	/** The var_13_3. */
	@Basic
	@Column(name = "VAR_13_3")
	private String var_13_3;

	/** The var_13_4. */
	@Basic
	@Column(name = "VAR_13_4")
	private String var_13_4;

	/** The var_13_5. */
	@Basic
	@Column(name = "VAR_13_5")
	private String var_13_5;

	/** The var_13_6. */
	@Basic
	@Column(name = "VAR_13_6")
	private String var_13_6;

	/** The var_2_1. */
	@Basic
	@Column(name = "var_2_1")
	private String var_2_1;

	/** The var_2_2. */
	@Basic
	@Column(name = "VAR_2_2")
	private String var_2_2;

	/** The var_2_3. */
	@Basic
	@Column(name = "VAR_2_3")
	private String var_2_3;

	/** The var_2_4. */
	@Basic
	@Column(name = "VAR_2_4")
	private String var_2_4;

	/** The var_2_5. */
	@Basic
	@Column(name = "VAR_2_5")
	private String var_2_5;

	/** The var_2_6. */
	@Basic
	@Column(name = "VAR_2_6")
	private String var_2_6;

	/** The var_3_1. */
	@Basic
	@Column(name = "VAR_3_1")
	private String var_3_1;

	/** The var_3_2. */
	@Basic
	@Column(name = "VAR_3_2")
	private String var_3_2;

	/** The var_3_3. */
	@Basic
	@Column(name = "VAR_3_3")
	private String var_3_3;

	/** The var_3_4. */
	@Basic
	@Column(name = "VAR_3_4")
	private String var_3_4;

	/** The var_3_5. */
	@Basic
	@Column(name = "VAR_3_5")
	private String var_3_5;

	/** The var_3_6. */
	@Basic
	@Column(name = "VAR_3_6")
	private String var_3_6;

	/** The var_4_1. */
	@Basic
	@Column(name = "VAR_4_1")
	private String var_4_1;

	/** The var_4_2. */
	@Basic
	@Column(name = "VAR_4_2")
	private String var_4_2;

	/** The var_4_3. */
	@Basic
	@Column(name = "VAR_4_3")
	private String var_4_3;

	/** The var_4_4. */
	@Basic
	@Column(name = "VAR_4_4")
	private String var_4_4;

	/** The var_4_5. */
	@Basic
	@Column(name = "VAR_4_5")
	private String var_4_5;

	/** The var_4_6. */
	@Basic
	@Column(name = "VAR_4_6")
	private String var_4_6;

	/** The var_5_1. */
	@Basic
	@Column(name = "VAR_5_1")
	private String var_5_1;

	/** The var_5_2. */
	@Basic
	@Column(name = "VAR_5_2")
	private String var_5_2;

	/** The var_5_3. */
	@Basic
	@Column(name = "VAR_5_3")
	private String var_5_3;

	/** The var_5_4. */
	@Basic
	@Column(name = "VAR_5_4")
	private String var_5_4;

	/** The var_5_5. */
	@Basic
	@Column(name = "VAR_5_5")
	private String var_5_5;

	/** The var_5_6. */
	@Basic
	@Column(name = "VAR_5_6")
	private String var_5_6;

	/** The var_6_1. */
	@Basic
	@Column(name = "VAR_6_1")
	private String var_6_1;

	/** The var_6_2. */
	@Basic
	@Column(name = "VAR_6_2")
	private String var_6_2;

	/** The var_6_3. */
	@Basic
	@Column(name = "VAR_6_3")
	private String var_6_3;

	/** The var_6_4. */
	@Basic
	@Column(name = "VAR_6_4")
	private String var_6_4;

	/** The var_6_5. */
	@Basic
	@Column(name = "VAR_6_5")
	private String var_6_5;

	/** The var_6_6. */
	@Basic
	@Column(name = "VAR_6_6")
	private String var_6_6;

	/** The var_7_1. */
	@Basic
	@Column(name = "VAR_7_1")
	private String var_7_1;

	/** The var_7_2. */
	@Basic
	@Column(name = "VAR_7_2")
	private String var_7_2;

	/** The var_7_3. */
	@Basic
	@Column(name = "VAR_7_3")
	private String var_7_3;

	/** The var_7_4. */
	@Basic
	@Column(name = "VAR_7_4")
	private String var_7_4;

	/** The var_7_5. */
	@Basic
	@Column(name = "VAR_7_5")
	private String var_7_5;

	/** The var_7_6. */
	@Basic
	@Column(name = "VAR_7_6")
	private String var_7_6;

	/** The var_8_1. */
	@Basic
	@Column(name = "VAR_8_1")
	private String var_8_1;

	/** The var_8_2. */
	@Basic
	@Column(name = "VAR_8_2")
	private String var_8_2;

	/** The var_8_3. */
	@Basic
	@Column(name = "VAR_8_3")
	private String var_8_3;

	/** The var_8_4. */
	@Basic
	@Column(name = "VAR_8_4")
	private String var_8_4;

	/** The var_8_5. */
	@Basic
	@Column(name = "VAR_8_5")
	private String var_8_5;

	/** The var_8_6. */
	@Basic
	@Column(name = "VAR_8_6")
	private String var_8_6;

	/** The var_9_1. */
	@Basic
	@Column(name = "VAR_9_1")
	private String var_9_1;

	/** The var_9_2. */
	@Basic
	@Column(name = "VAR_9_2")
	private String var_9_2;

	/** The var_9_3. */
	@Basic
	@Column(name = "VAR_9_3")
	private String var_9_3;

	/** The var_9_4. */
	@Basic
	@Column(name = "VAR_9_4")
	private String var_9_4;

	/** The var_9_5. */
	@Basic
	@Column(name = "VAR_9_5")
	private String var_9_5;

	/** The var_9_6. */
	@Basic
	@Column(name = "VAR_9_6")
	private String var_9_6;

	/**
	 * Instantiates a new valoracion articular muscular.
	 */
	public ValoracionArticularMuscular() {
		super();
	}

	/**
	 * Instantiates a new valoracion articular muscular.
	 *
	 * @param id the id
	 * @param var_1_1 the var_1_1
	 * @param var_1_2 the var_1_2
	 * @param var_1_3 the var_1_3
	 * @param var_1_4 the var_1_4
	 * @param var_1_5 the var_1_5
	 * @param var_1_6 the var_1_6
	 * @param var_2_1 the var_2_1
	 * @param var_2_2 the var_2_2
	 * @param var_2_3 the var_2_3
	 * @param var_2_4 the var_2_4
	 * @param var_2_5 the var_2_5
	 * @param var_2_6 the var_2_6
	 * @param var_3_1 the var_3_1
	 * @param var_3_2 the var_3_2
	 * @param var_3_3 the var_3_3
	 * @param var_3_4 the var_3_4
	 * @param var_3_5 the var_3_5
	 * @param var_3_6 the var_3_6
	 * @param var_4_1 the var_4_1
	 * @param var_4_2 the var_4_2
	 * @param var_4_3 the var_4_3
	 * @param var_4_4 the var_4_4
	 * @param var_4_5 the var_4_5
	 * @param var_4_6 the var_4_6
	 * @param var_5_1 the var_5_1
	 * @param var_5_2 the var_5_2
	 * @param var_5_3 the var_5_3
	 * @param var_5_4 the var_5_4
	 * @param var_5_5 the var_5_5
	 * @param var_5_6 the var_5_6
	 * @param var_6_1 the var_6_1
	 * @param var_6_2 the var_6_2
	 * @param var_6_3 the var_6_3
	 * @param var_6_4 the var_6_4
	 * @param var_6_5 the var_6_5
	 * @param var_6_6 the var_6_6
	 * @param var_7_1 the var_7_1
	 * @param var_7_2 the var_7_2
	 * @param var_7_3 the var_7_3
	 * @param var_7_4 the var_7_4
	 * @param var_7_5 the var_7_5
	 * @param var_7_6 the var_7_6
	 * @param var_8_1 the var_8_1
	 * @param var_8_2 the var_8_2
	 * @param var_8_3 the var_8_3
	 * @param var_8_4 the var_8_4
	 * @param var_8_5 the var_8_5
	 * @param var_8_6 the var_8_6
	 * @param var_9_1 the var_9_1
	 * @param var_9_2 the var_9_2
	 * @param var_9_3 the var_9_3
	 * @param var_9_4 the var_9_4
	 * @param var_9_5 the var_9_5
	 * @param var_9_6 the var_9_6
	 * @param var_10_1 the var_10_1
	 * @param var_10_2 the var_10_2
	 * @param var_10_3 the var_10_3
	 * @param var_10_4 the var_10_4
	 * @param var_10_5 the var_10_5
	 * @param var_10_6 the var_10_6
	 * @param var_11_1 the var_11_1
	 * @param var_11_2 the var_11_2
	 * @param var_11_3 the var_11_3
	 * @param var_11_4 the var_11_4
	 * @param var_11_5 the var_11_5
	 * @param var_11_6 the var_11_6
	 * @param var_12_1 the var_12_1
	 * @param var_12_2 the var_12_2
	 * @param var_12_3 the var_12_3
	 * @param var_12_4 the var_12_4
	 * @param var_12_5 the var_12_5
	 * @param var_12_6 the var_12_6
	 * @param var_13_1 the var_13_1
	 * @param var_13_2 the var_13_2
	 * @param var_13_3 the var_13_3
	 * @param var_13_4 the var_13_4
	 * @param var_13_5 the var_13_5
	 * @param var_13_6 the var_13_6
	 */
	public ValoracionArticularMuscular(Integer id, String var_1_1, String var_1_2, String var_1_3, String var_1_4, String var_1_5, String var_1_6, String var_2_1, String var_2_2, String var_2_3, String var_2_4, String var_2_5, String var_2_6, String var_3_1, String var_3_2, String var_3_3, String var_3_4, String var_3_5, String var_3_6, String var_4_1, String var_4_2, String var_4_3, String var_4_4, String var_4_5, String var_4_6, String var_5_1, String var_5_2, String var_5_3, String var_5_4, String var_5_5, String var_5_6, String var_6_1, String var_6_2, String var_6_3, String var_6_4, String var_6_5, String var_6_6, String var_7_1, String var_7_2, String var_7_3, String var_7_4, String var_7_5, String var_7_6, String var_8_1, String var_8_2, String var_8_3, String var_8_4, String var_8_5, String var_8_6, String var_9_1, String var_9_2, String var_9_3, String var_9_4, String var_9_5, String var_9_6, String var_10_1, String var_10_2, String var_10_3, String var_10_4, String var_10_5, String var_10_6, String var_11_1, String var_11_2, String var_11_3, String var_11_4, String var_11_5, String var_11_6, String var_12_1, String var_12_2, String var_12_3, String var_12_4, String var_12_5, String var_12_6, String var_13_1, String var_13_2, String var_13_3, String var_13_4, String var_13_5, String var_13_6) {
		super();
		this.id = id;
		this.var_1_1 = var_1_1;
		this.var_1_2 = var_1_2;
		this.var_1_3 = var_1_3;
		this.var_1_4 = var_1_4;
		this.var_1_5 = var_1_5;
		this.var_1_6 = var_1_6;
		this.var_2_1 = var_2_1;
		this.var_2_2 = var_2_2;
		this.var_2_3 = var_2_3;
		this.var_2_4 = var_2_4;
		this.var_2_5 = var_2_5;
		this.var_2_6 = var_2_6;
		this.var_3_1 = var_3_1;
		this.var_3_2 = var_3_2;
		this.var_3_3 = var_3_3;
		this.var_3_4 = var_3_4;
		this.var_3_5 = var_3_5;
		this.var_3_6 = var_3_6;
		this.var_4_1 = var_4_1;
		this.var_4_2 = var_4_2;
		this.var_4_3 = var_4_3;
		this.var_4_4 = var_4_4;
		this.var_4_5 = var_4_5;
		this.var_4_6 = var_4_6;
		this.var_5_1 = var_5_1;
		this.var_5_2 = var_5_2;
		this.var_5_3 = var_5_3;
		this.var_5_4 = var_5_4;
		this.var_5_5 = var_5_5;
		this.var_5_6 = var_5_6;
		this.var_6_1 = var_6_1;
		this.var_6_2 = var_6_2;
		this.var_6_3 = var_6_3;
		this.var_6_4 = var_6_4;
		this.var_6_5 = var_6_5;
		this.var_6_6 = var_6_6;
		this.var_7_1 = var_7_1;
		this.var_7_2 = var_7_2;
		this.var_7_3 = var_7_3;
		this.var_7_4 = var_7_4;
		this.var_7_5 = var_7_5;
		this.var_7_6 = var_7_6;
		this.var_8_1 = var_8_1;
		this.var_8_2 = var_8_2;
		this.var_8_3 = var_8_3;
		this.var_8_4 = var_8_4;
		this.var_8_5 = var_8_5;
		this.var_8_6 = var_8_6;
		this.var_9_1 = var_9_1;
		this.var_9_2 = var_9_2;
		this.var_9_3 = var_9_3;
		this.var_9_4 = var_9_4;
		this.var_9_5 = var_9_5;
		this.var_9_6 = var_9_6;
		this.var_10_1 = var_10_1;
		this.var_10_2 = var_10_2;
		this.var_10_3 = var_10_3;
		this.var_10_4 = var_10_4;
		this.var_10_5 = var_10_5;
		this.var_10_6 = var_10_6;
		this.var_11_1 = var_11_1;
		this.var_11_2 = var_11_2;
		this.var_11_3 = var_11_3;
		this.var_11_4 = var_11_4;
		this.var_11_5 = var_11_5;
		this.var_11_6 = var_11_6;
		this.var_12_1 = var_12_1;
		this.var_12_2 = var_12_2;
		this.var_12_3 = var_12_3;
		this.var_12_4 = var_12_4;
		this.var_12_5 = var_12_5;
		this.var_12_6 = var_12_6;
		this.var_13_1 = var_13_1;
		this.var_13_2 = var_13_2;
		this.var_13_3 = var_13_3;
		this.var_13_4 = var_13_4;
		this.var_13_5 = var_13_5;
		this.var_13_6 = var_13_6;
	}

	/**
	 * Gets the exploracion.
	 *
	 * @return the exploracion
	 */
	public Exploracion getExploracion() {
		return exploracion;
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
	 * Gets the var_1_1.
	 *
	 * @return the var_1_1
	 */
	public String getVar_1_1() {
		return var_1_1;
	}

	/**
	 * Gets the var_1_2.
	 *
	 * @return the var_1_2
	 */
	public String getVar_1_2() {
		return var_1_2;
	}

	/**
	 * Gets the var_1_3.
	 *
	 * @return the var_1_3
	 */
	public String getVar_1_3() {
		return var_1_3;
	}

	/**
	 * Gets the var_1_4.
	 *
	 * @return the var_1_4
	 */
	public String getVar_1_4() {
		return var_1_4;
	}

	/**
	 * Gets the var_1_5.
	 *
	 * @return the var_1_5
	 */
	public String getVar_1_5() {
		return var_1_5;
	}

	/**
	 * Gets the var_1_6.
	 *
	 * @return the var_1_6
	 */
	public String getVar_1_6() {
		return var_1_6;
	}

	/**
	 * Gets the var_10_1.
	 *
	 * @return the var_10_1
	 */
	public String getVar_10_1() {
		return var_10_1;
	}

	/**
	 * Gets the var_10_2.
	 *
	 * @return the var_10_2
	 */
	public String getVar_10_2() {
		return var_10_2;
	}

	/**
	 * Gets the var_10_3.
	 *
	 * @return the var_10_3
	 */
	public String getVar_10_3() {
		return var_10_3;
	}

	/**
	 * Gets the var_10_4.
	 *
	 * @return the var_10_4
	 */
	public String getVar_10_4() {
		return var_10_4;
	}

	/**
	 * Gets the var_10_5.
	 *
	 * @return the var_10_5
	 */
	public String getVar_10_5() {
		return var_10_5;
	}

	/**
	 * Gets the var_10_6.
	 *
	 * @return the var_10_6
	 */
	public String getVar_10_6() {
		return var_10_6;
	}

	/**
	 * Gets the var_11_1.
	 *
	 * @return the var_11_1
	 */
	public String getVar_11_1() {
		return var_11_1;
	}

	/**
	 * Gets the var_11_2.
	 *
	 * @return the var_11_2
	 */
	public String getVar_11_2() {
		return var_11_2;
	}

	/**
	 * Gets the var_11_3.
	 *
	 * @return the var_11_3
	 */
	public String getVar_11_3() {
		return var_11_3;
	}

	/**
	 * Gets the var_11_4.
	 *
	 * @return the var_11_4
	 */
	public String getVar_11_4() {
		return var_11_4;
	}

	/**
	 * Gets the var_11_5.
	 *
	 * @return the var_11_5
	 */
	public String getVar_11_5() {
		return var_11_5;
	}

	/**
	 * Gets the var_11_6.
	 *
	 * @return the var_11_6
	 */
	public String getVar_11_6() {
		return var_11_6;
	}

	/**
	 * Gets the var_12_1.
	 *
	 * @return the var_12_1
	 */
	public String getVar_12_1() {
		return var_12_1;
	}

	/**
	 * Gets the var_12_2.
	 *
	 * @return the var_12_2
	 */
	public String getVar_12_2() {
		return var_12_2;
	}

	/**
	 * Gets the var_12_3.
	 *
	 * @return the var_12_3
	 */
	public String getVar_12_3() {
		return var_12_3;
	}

	/**
	 * Gets the var_12_4.
	 *
	 * @return the var_12_4
	 */
	public String getVar_12_4() {
		return var_12_4;
	}

	/**
	 * Gets the var_12_5.
	 *
	 * @return the var_12_5
	 */
	public String getVar_12_5() {
		return var_12_5;
	}

	/**
	 * Gets the var_12_6.
	 *
	 * @return the var_12_6
	 */
	public String getVar_12_6() {
		return var_12_6;
	}

	/**
	 * Gets the var_13_1.
	 *
	 * @return the var_13_1
	 */
	public String getVar_13_1() {
		return var_13_1;
	}

	/**
	 * Gets the var_13_2.
	 *
	 * @return the var_13_2
	 */
	public String getVar_13_2() {
		return var_13_2;
	}

	/**
	 * Gets the var_13_3.
	 *
	 * @return the var_13_3
	 */
	public String getVar_13_3() {
		return var_13_3;
	}

	/**
	 * Gets the var_13_4.
	 *
	 * @return the var_13_4
	 */
	public String getVar_13_4() {
		return var_13_4;
	}

	/**
	 * Gets the var_13_5.
	 *
	 * @return the var_13_5
	 */
	public String getVar_13_5() {
		return var_13_5;
	}

	/**
	 * Gets the var_13_6.
	 *
	 * @return the var_13_6
	 */
	public String getVar_13_6() {
		return var_13_6;
	}

	/**
	 * Gets the var_2_1.
	 *
	 * @return the var_2_1
	 */
	public String getVar_2_1() {
		return var_2_1;
	}

	/**
	 * Gets the var_2_2.
	 *
	 * @return the var_2_2
	 */
	public String getVar_2_2() {
		return var_2_2;
	}

	/**
	 * Gets the var_2_3.
	 *
	 * @return the var_2_3
	 */
	public String getVar_2_3() {
		return var_2_3;
	}

	/**
	 * Gets the var_2_4.
	 *
	 * @return the var_2_4
	 */
	public String getVar_2_4() {
		return var_2_4;
	}

	/**
	 * Gets the var_2_5.
	 *
	 * @return the var_2_5
	 */
	public String getVar_2_5() {
		return var_2_5;
	}

	/**
	 * Gets the var_2_6.
	 *
	 * @return the var_2_6
	 */
	public String getVar_2_6() {
		return var_2_6;
	}

	/**
	 * Gets the var_3_1.
	 *
	 * @return the var_3_1
	 */
	public String getVar_3_1() {
		return var_3_1;
	}

	/**
	 * Gets the var_3_2.
	 *
	 * @return the var_3_2
	 */
	public String getVar_3_2() {
		return var_3_2;
	}

	/**
	 * Gets the var_3_3.
	 *
	 * @return the var_3_3
	 */
	public String getVar_3_3() {
		return var_3_3;
	}

	/**
	 * Gets the var_3_4.
	 *
	 * @return the var_3_4
	 */
	public String getVar_3_4() {
		return var_3_4;
	}

	/**
	 * Gets the var_3_5.
	 *
	 * @return the var_3_5
	 */
	public String getVar_3_5() {
		return var_3_5;
	}

	/**
	 * Gets the var_3_6.
	 *
	 * @return the var_3_6
	 */
	public String getVar_3_6() {
		return var_3_6;
	}

	/**
	 * Gets the var_4_1.
	 *
	 * @return the var_4_1
	 */
	public String getVar_4_1() {
		return var_4_1;
	}

	/**
	 * Gets the var_4_2.
	 *
	 * @return the var_4_2
	 */
	public String getVar_4_2() {
		return var_4_2;
	}

	/**
	 * Gets the var_4_3.
	 *
	 * @return the var_4_3
	 */
	public String getVar_4_3() {
		return var_4_3;
	}

	/**
	 * Gets the var_4_4.
	 *
	 * @return the var_4_4
	 */
	public String getVar_4_4() {
		return var_4_4;
	}

	/**
	 * Gets the var_4_5.
	 *
	 * @return the var_4_5
	 */
	public String getVar_4_5() {
		return var_4_5;
	}

	/**
	 * Gets the var_4_6.
	 *
	 * @return the var_4_6
	 */
	public String getVar_4_6() {
		return var_4_6;
	}

	/**
	 * Gets the var_5_1.
	 *
	 * @return the var_5_1
	 */
	public String getVar_5_1() {
		return var_5_1;
	}

	/**
	 * Gets the var_5_2.
	 *
	 * @return the var_5_2
	 */
	public String getVar_5_2() {
		return var_5_2;
	}

	/**
	 * Gets the var_5_3.
	 *
	 * @return the var_5_3
	 */
	public String getVar_5_3() {
		return var_5_3;
	}

	/**
	 * Gets the var_5_4.
	 *
	 * @return the var_5_4
	 */
	public String getVar_5_4() {
		return var_5_4;
	}

	/**
	 * Gets the var_5_5.
	 *
	 * @return the var_5_5
	 */
	public String getVar_5_5() {
		return var_5_5;
	}

	/**
	 * Gets the var_5_6.
	 *
	 * @return the var_5_6
	 */
	public String getVar_5_6() {
		return var_5_6;
	}

	/**
	 * Gets the var_6_1.
	 *
	 * @return the var_6_1
	 */
	public String getVar_6_1() {
		return var_6_1;
	}

	/**
	 * Gets the var_6_2.
	 *
	 * @return the var_6_2
	 */
	public String getVar_6_2() {
		return var_6_2;
	}

	/**
	 * Gets the var_6_3.
	 *
	 * @return the var_6_3
	 */
	public String getVar_6_3() {
		return var_6_3;
	}

	/**
	 * Gets the var_6_4.
	 *
	 * @return the var_6_4
	 */
	public String getVar_6_4() {
		return var_6_4;
	}

	/**
	 * Gets the var_6_5.
	 *
	 * @return the var_6_5
	 */
	public String getVar_6_5() {
		return var_6_5;
	}

	/**
	 * Gets the var_6_6.
	 *
	 * @return the var_6_6
	 */
	public String getVar_6_6() {
		return var_6_6;
	}

	/**
	 * Gets the var_7_1.
	 *
	 * @return the var_7_1
	 */
	public String getVar_7_1() {
		return var_7_1;
	}

	/**
	 * Gets the var_7_2.
	 *
	 * @return the var_7_2
	 */
	public String getVar_7_2() {
		return var_7_2;
	}

	/**
	 * Gets the var_7_3.
	 *
	 * @return the var_7_3
	 */
	public String getVar_7_3() {
		return var_7_3;
	}

	/**
	 * Gets the var_7_4.
	 *
	 * @return the var_7_4
	 */
	public String getVar_7_4() {
		return var_7_4;
	}

	/**
	 * Gets the var_7_5.
	 *
	 * @return the var_7_5
	 */
	public String getVar_7_5() {
		return var_7_5;
	}

	/**
	 * Gets the var_7_6.
	 *
	 * @return the var_7_6
	 */
	public String getVar_7_6() {
		return var_7_6;
	}

	/**
	 * Gets the var_8_1.
	 *
	 * @return the var_8_1
	 */
	public String getVar_8_1() {
		return var_8_1;
	}

	/**
	 * Gets the var_8_2.
	 *
	 * @return the var_8_2
	 */
	public String getVar_8_2() {
		return var_8_2;
	}

	/**
	 * Gets the var_8_3.
	 *
	 * @return the var_8_3
	 */
	public String getVar_8_3() {
		return var_8_3;
	}

	/**
	 * Gets the var_8_4.
	 *
	 * @return the var_8_4
	 */
	public String getVar_8_4() {
		return var_8_4;
	}

	/**
	 * Gets the var_8_5.
	 *
	 * @return the var_8_5
	 */
	public String getVar_8_5() {
		return var_8_5;
	}

	/**
	 * Gets the var_8_6.
	 *
	 * @return the var_8_6
	 */
	public String getVar_8_6() {
		return var_8_6;
	}

	/**
	 * Gets the var_9_1.
	 *
	 * @return the var_9_1
	 */
	public String getVar_9_1() {
		return var_9_1;
	}

	/**
	 * Gets the var_9_2.
	 *
	 * @return the var_9_2
	 */
	public String getVar_9_2() {
		return var_9_2;
	}

	/**
	 * Gets the var_9_3.
	 *
	 * @return the var_9_3
	 */
	public String getVar_9_3() {
		return var_9_3;
	}

	/**
	 * Gets the var_9_4.
	 *
	 * @return the var_9_4
	 */
	public String getVar_9_4() {
		return var_9_4;
	}

	/**
	 * Gets the var_9_5.
	 *
	 * @return the var_9_5
	 */
	public String getVar_9_5() {
		return var_9_5;
	}

	/**
	 * Gets the var_9_6.
	 *
	 * @return the var_9_6
	 */
	public String getVar_9_6() {
		return var_9_6;
	}
	
	/**
	 * Sets the exploracion.
	 *
	 * @param exploracion the new exploracion
	 */
	public void setExploracion(Exploracion exploracion) {
		this.exploracion = exploracion;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Sets the var_1_1.
	 *
	 * @param var_1_1 the new var_1_1
	 */
	public void setVar_1_1(String var_1_1) {
		this.var_1_1 = var_1_1;
	}

	/**
	 * Sets the var_1_2.
	 *
	 * @param var_1_2 the new var_1_2
	 */
	public void setVar_1_2(String var_1_2) {
		this.var_1_2 = var_1_2;
	}

	/**
	 * Sets the var_1_3.
	 *
	 * @param var_1_3 the new var_1_3
	 */
	public void setVar_1_3(String var_1_3) {
		this.var_1_3 = var_1_3;
	}

	/**
	 * Sets the var_1_4.
	 *
	 * @param var_1_4 the new var_1_4
	 */
	public void setVar_1_4(String var_1_4) {
		this.var_1_4 = var_1_4;
	}

	/**
	 * Sets the var_1_5.
	 *
	 * @param var_1_5 the new var_1_5
	 */
	public void setVar_1_5(String var_1_5) {
		this.var_1_5 = var_1_5;
	}

	/**
	 * Sets the var_1_6.
	 *
	 * @param var_1_6 the new var_1_6
	 */
	public void setVar_1_6(String var_1_6) {
		this.var_1_6 = var_1_6;
	}

	/**
	 * Sets the var_10_1.
	 *
	 * @param var_10_1 the new var_10_1
	 */
	public void setVar_10_1(String var_10_1) {
		this.var_10_1 = var_10_1;
	}

	/**
	 * Sets the var_10_2.
	 *
	 * @param var_10_2 the new var_10_2
	 */
	public void setVar_10_2(String var_10_2) {
		this.var_10_2 = var_10_2;
	}

	/**
	 * Sets the var_10_3.
	 *
	 * @param var_10_3 the new var_10_3
	 */
	public void setVar_10_3(String var_10_3) {
		this.var_10_3 = var_10_3;
	}

	/**
	 * Sets the var_10_4.
	 *
	 * @param var_10_4 the new var_10_4
	 */
	public void setVar_10_4(String var_10_4) {
		this.var_10_4 = var_10_4;
	}

	/**
	 * Sets the var_10_5.
	 *
	 * @param var_10_5 the new var_10_5
	 */
	public void setVar_10_5(String var_10_5) {
		this.var_10_5 = var_10_5;
	}

	/**
	 * Sets the var_10_6.
	 *
	 * @param var_10_6 the new var_10_6
	 */
	public void setVar_10_6(String var_10_6) {
		this.var_10_6 = var_10_6;
	}

	/**
	 * Sets the var_11_1.
	 *
	 * @param var_11_1 the new var_11_1
	 */
	public void setVar_11_1(String var_11_1) {
		this.var_11_1 = var_11_1;
	}

	/**
	 * Sets the var_11_2.
	 *
	 * @param var_11_2 the new var_11_2
	 */
	public void setVar_11_2(String var_11_2) {
		this.var_11_2 = var_11_2;
	}

	/**
	 * Sets the var_11_3.
	 *
	 * @param var_11_3 the new var_11_3
	 */
	public void setVar_11_3(String var_11_3) {
		this.var_11_3 = var_11_3;
	}

	/**
	 * Sets the var_11_4.
	 *
	 * @param var_11_4 the new var_11_4
	 */
	public void setVar_11_4(String var_11_4) {
		this.var_11_4 = var_11_4;
	}

	/**
	 * Sets the var_11_5.
	 *
	 * @param var_11_5 the new var_11_5
	 */
	public void setVar_11_5(String var_11_5) {
		this.var_11_5 = var_11_5;
	}

	/**
	 * Sets the var_11_6.
	 *
	 * @param var_11_6 the new var_11_6
	 */
	public void setVar_11_6(String var_11_6) {
		this.var_11_6 = var_11_6;
	}

	/**
	 * Sets the var_12_1.
	 *
	 * @param var_12_1 the new var_12_1
	 */
	public void setVar_12_1(String var_12_1) {
		this.var_12_1 = var_12_1;
	}

	/**
	 * Sets the var_12_2.
	 *
	 * @param var_12_2 the new var_12_2
	 */
	public void setVar_12_2(String var_12_2) {
		this.var_12_2 = var_12_2;
	}

	/**
	 * Sets the var_12_3.
	 *
	 * @param var_12_3 the new var_12_3
	 */
	public void setVar_12_3(String var_12_3) {
		this.var_12_3 = var_12_3;
	}

	/**
	 * Sets the var_12_4.
	 *
	 * @param var_12_4 the new var_12_4
	 */
	public void setVar_12_4(String var_12_4) {
		this.var_12_4 = var_12_4;
	}

	/**
	 * Sets the var_12_5.
	 *
	 * @param var_12_5 the new var_12_5
	 */
	public void setVar_12_5(String var_12_5) {
		this.var_12_5 = var_12_5;
	}

	/**
	 * Sets the var_12_6.
	 *
	 * @param var_12_6 the new var_12_6
	 */
	public void setVar_12_6(String var_12_6) {
		this.var_12_6 = var_12_6;
	}

	/**
	 * Sets the var_13_1.
	 *
	 * @param var_13_1 the new var_13_1
	 */
	public void setVar_13_1(String var_13_1) {
		this.var_13_1 = var_13_1;
	}

	/**
	 * Sets the var_13_2.
	 *
	 * @param var_13_2 the new var_13_2
	 */
	public void setVar_13_2(String var_13_2) {
		this.var_13_2 = var_13_2;
	}

	/**
	 * Sets the var_13_3.
	 *
	 * @param var_13_3 the new var_13_3
	 */
	public void setVar_13_3(String var_13_3) {
		this.var_13_3 = var_13_3;
	}

	/**
	 * Sets the var_13_4.
	 *
	 * @param var_13_4 the new var_13_4
	 */
	public void setVar_13_4(String var_13_4) {
		this.var_13_4 = var_13_4;
	}

	/**
	 * Sets the var_13_5.
	 *
	 * @param var_13_5 the new var_13_5
	 */
	public void setVar_13_5(String var_13_5) {
		this.var_13_5 = var_13_5;
	}

	/**
	 * Sets the var_13_6.
	 *
	 * @param var_13_6 the new var_13_6
	 */
	public void setVar_13_6(String var_13_6) {
		this.var_13_6 = var_13_6;
	}

	/**
	 * Sets the var_2_1.
	 *
	 * @param var_2_1 the new var_2_1
	 */
	public void setVar_2_1(String var_2_1) {
		this.var_2_1 = var_2_1;
	}

	/**
	 * Sets the var_2_2.
	 *
	 * @param var_2_2 the new var_2_2
	 */
	public void setVar_2_2(String var_2_2) {
		this.var_2_2 = var_2_2;
	}

	/**
	 * Sets the var_2_3.
	 *
	 * @param var_2_3 the new var_2_3
	 */
	public void setVar_2_3(String var_2_3) {
		this.var_2_3 = var_2_3;
	}

	/**
	 * Sets the var_2_4.
	 *
	 * @param var_2_4 the new var_2_4
	 */
	public void setVar_2_4(String var_2_4) {
		this.var_2_4 = var_2_4;
	}

	/**
	 * Sets the var_2_5.
	 *
	 * @param var_2_5 the new var_2_5
	 */
	public void setVar_2_5(String var_2_5) {
		this.var_2_5 = var_2_5;
	}

	/**
	 * Sets the var_2_6.
	 *
	 * @param var_2_6 the new var_2_6
	 */
	public void setVar_2_6(String var_2_6) {
		this.var_2_6 = var_2_6;
	}

	/**
	 * Sets the var_3_1.
	 *
	 * @param var_3_1 the new var_3_1
	 */
	public void setVar_3_1(String var_3_1) {
		this.var_3_1 = var_3_1;
	}

	/**
	 * Sets the var_3_2.
	 *
	 * @param var_3_2 the new var_3_2
	 */
	public void setVar_3_2(String var_3_2) {
		this.var_3_2 = var_3_2;
	}

	/**
	 * Sets the var_3_3.
	 *
	 * @param var_3_3 the new var_3_3
	 */
	public void setVar_3_3(String var_3_3) {
		this.var_3_3 = var_3_3;
	}

	/**
	 * Sets the var_3_4.
	 *
	 * @param var_3_4 the new var_3_4
	 */
	public void setVar_3_4(String var_3_4) {
		this.var_3_4 = var_3_4;
	}

	/**
	 * Sets the var_3_5.
	 *
	 * @param var_3_5 the new var_3_5
	 */
	public void setVar_3_5(String var_3_5) {
		this.var_3_5 = var_3_5;
	}

	/**
	 * Sets the var_3_6.
	 *
	 * @param var_3_6 the new var_3_6
	 */
	public void setVar_3_6(String var_3_6) {
		this.var_3_6 = var_3_6;
	}

	/**
	 * Sets the var_4_1.
	 *
	 * @param var_4_1 the new var_4_1
	 */
	public void setVar_4_1(String var_4_1) {
		this.var_4_1 = var_4_1;
	}

	/**
	 * Sets the var_4_2.
	 *
	 * @param var_4_2 the new var_4_2
	 */
	public void setVar_4_2(String var_4_2) {
		this.var_4_2 = var_4_2;
	}

	/**
	 * Sets the var_4_3.
	 *
	 * @param var_4_3 the new var_4_3
	 */
	public void setVar_4_3(String var_4_3) {
		this.var_4_3 = var_4_3;
	}

	/**
	 * Sets the var_4_4.
	 *
	 * @param var_4_4 the new var_4_4
	 */
	public void setVar_4_4(String var_4_4) {
		this.var_4_4 = var_4_4;
	}

	/**
	 * Sets the var_4_5.
	 *
	 * @param var_4_5 the new var_4_5
	 */
	public void setVar_4_5(String var_4_5) {
		this.var_4_5 = var_4_5;
	}

	/**
	 * Sets the var_4_6.
	 *
	 * @param var_4_6 the new var_4_6
	 */
	public void setVar_4_6(String var_4_6) {
		this.var_4_6 = var_4_6;
	}

	/**
	 * Sets the var_5_1.
	 *
	 * @param var_5_1 the new var_5_1
	 */
	public void setVar_5_1(String var_5_1) {
		this.var_5_1 = var_5_1;
	}

	/**
	 * Sets the var_5_2.
	 *
	 * @param var_5_2 the new var_5_2
	 */
	public void setVar_5_2(String var_5_2) {
		this.var_5_2 = var_5_2;
	}

	/**
	 * Sets the var_5_3.
	 *
	 * @param var_5_3 the new var_5_3
	 */
	public void setVar_5_3(String var_5_3) {
		this.var_5_3 = var_5_3;
	}

	/**
	 * Sets the var_5_4.
	 *
	 * @param var_5_4 the new var_5_4
	 */
	public void setVar_5_4(String var_5_4) {
		this.var_5_4 = var_5_4;
	}

	/**
	 * Sets the var_5_5.
	 *
	 * @param var_5_5 the new var_5_5
	 */
	public void setVar_5_5(String var_5_5) {
		this.var_5_5 = var_5_5;
	}

	/**
	 * Sets the var_5_6.
	 *
	 * @param var_5_6 the new var_5_6
	 */
	public void setVar_5_6(String var_5_6) {
		this.var_5_6 = var_5_6;
	}

	/**
	 * Sets the var_6_1.
	 *
	 * @param var_6_1 the new var_6_1
	 */
	public void setVar_6_1(String var_6_1) {
		this.var_6_1 = var_6_1;
	}

	/**
	 * Sets the var_6_2.
	 *
	 * @param var_6_2 the new var_6_2
	 */
	public void setVar_6_2(String var_6_2) {
		this.var_6_2 = var_6_2;
	}

	/**
	 * Sets the var_6_3.
	 *
	 * @param var_6_3 the new var_6_3
	 */
	public void setVar_6_3(String var_6_3) {
		this.var_6_3 = var_6_3;
	}

	/**
	 * Sets the var_6_4.
	 *
	 * @param var_6_4 the new var_6_4
	 */
	public void setVar_6_4(String var_6_4) {
		this.var_6_4 = var_6_4;
	}

	/**
	 * Sets the var_6_5.
	 *
	 * @param var_6_5 the new var_6_5
	 */
	public void setVar_6_5(String var_6_5) {
		this.var_6_5 = var_6_5;
	}

	/**
	 * Sets the var_6_6.
	 *
	 * @param var_6_6 the new var_6_6
	 */
	public void setVar_6_6(String var_6_6) {
		this.var_6_6 = var_6_6;
	}

	/**
	 * Sets the var_7_1.
	 *
	 * @param var_7_1 the new var_7_1
	 */
	public void setVar_7_1(String var_7_1) {
		this.var_7_1 = var_7_1;
	}

	/**
	 * Sets the var_7_2.
	 *
	 * @param var_7_2 the new var_7_2
	 */
	public void setVar_7_2(String var_7_2) {
		this.var_7_2 = var_7_2;
	}

	/**
	 * Sets the var_7_3.
	 *
	 * @param var_7_3 the new var_7_3
	 */
	public void setVar_7_3(String var_7_3) {
		this.var_7_3 = var_7_3;
	}

	/**
	 * Sets the var_7_4.
	 *
	 * @param var_7_4 the new var_7_4
	 */
	public void setVar_7_4(String var_7_4) {
		this.var_7_4 = var_7_4;
	}

	/**
	 * Sets the var_7_5.
	 *
	 * @param var_7_5 the new var_7_5
	 */
	public void setVar_7_5(String var_7_5) {
		this.var_7_5 = var_7_5;
	}

	/**
	 * Sets the var_7_6.
	 *
	 * @param var_7_6 the new var_7_6
	 */
	public void setVar_7_6(String var_7_6) {
		this.var_7_6 = var_7_6;
	}

	/**
	 * Sets the var_8_1.
	 *
	 * @param var_8_1 the new var_8_1
	 */
	public void setVar_8_1(String var_8_1) {
		this.var_8_1 = var_8_1;
	}

	/**
	 * Sets the var_8_2.
	 *
	 * @param var_8_2 the new var_8_2
	 */
	public void setVar_8_2(String var_8_2) {
		this.var_8_2 = var_8_2;
	}

	/**
	 * Sets the var_8_3.
	 *
	 * @param var_8_3 the new var_8_3
	 */
	public void setVar_8_3(String var_8_3) {
		this.var_8_3 = var_8_3;
	}

	/**
	 * Sets the var_8_4.
	 *
	 * @param var_8_4 the new var_8_4
	 */
	public void setVar_8_4(String var_8_4) {
		this.var_8_4 = var_8_4;
	}

	/**
	 * Sets the var_8_5.
	 *
	 * @param var_8_5 the new var_8_5
	 */
	public void setVar_8_5(String var_8_5) {
		this.var_8_5 = var_8_5;
	}

	/**
	 * Sets the var_8_6.
	 *
	 * @param var_8_6 the new var_8_6
	 */
	public void setVar_8_6(String var_8_6) {
		this.var_8_6 = var_8_6;
	}

	/**
	 * Sets the var_9_1.
	 *
	 * @param var_9_1 the new var_9_1
	 */
	public void setVar_9_1(String var_9_1) {
		this.var_9_1 = var_9_1;
	}

	/**
	 * Sets the var_9_2.
	 *
	 * @param var_9_2 the new var_9_2
	 */
	public void setVar_9_2(String var_9_2) {
		this.var_9_2 = var_9_2;
	}

	/**
	 * Sets the var_9_3.
	 *
	 * @param var_9_3 the new var_9_3
	 */
	public void setVar_9_3(String var_9_3) {
		this.var_9_3 = var_9_3;
	}

	/**
	 * Sets the var_9_4.
	 *
	 * @param var_9_4 the new var_9_4
	 */
	public void setVar_9_4(String var_9_4) {
		this.var_9_4 = var_9_4;
	}

	/**
	 * Sets the var_9_5.
	 *
	 * @param var_9_5 the new var_9_5
	 */
	public void setVar_9_5(String var_9_5) {
		this.var_9_5 = var_9_5;
	}

	/**
	 * Sets the var_9_6.
	 *
	 * @param var_9_6 the new var_9_6
	 */
	public void setVar_9_6(String var_9_6) {
		this.var_9_6 = var_9_6;
	}
}
