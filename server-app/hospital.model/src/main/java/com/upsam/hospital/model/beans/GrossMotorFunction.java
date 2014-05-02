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
import com.upsam.hospital.model.enums.Evaluacion;

// TODO: Auto-generated Javadoc
/**
 * The Class GrossMotorFunction.
 */
@Entity
@Table(name = "GROSS_MOTOR_FUNCTION")
public class GrossMotorFunction implements IModelHospital {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -673741744999239900L;

	/** The comentarios. */
	@Basic
	@Column(name = "COMENTARIOS")
	private String comentarios;

	/** The evaluacion indicativa. */
	@Basic
	@Column(name = "EVALUACION_INDICATIVA")
	private Boolean evaluacionIndicativa;

	/** The exploracion. */
	@OneToOne
	@JoinColumn(name = "ID_EXPLORACION", unique = true)
	private Exploracion exploracion;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_GROSS_MOTOR_FUNCTION")
	private Integer id;

	/** The var1. */
	@Basic
	@Column(name = "VAR_1")
	private Evaluacion var1;

	/** The var10. */
	@Basic
	@Column(name = "VAR_10")
	private Evaluacion var10;

	/** The var11. */
	@Basic
	@Column(name = "VAR_11")
	private Evaluacion var11;

	/** The var12. */
	@Basic
	@Column(name = "VAR_12")
	private Evaluacion var12;

	/** The var13. */
	@Basic
	@Column(name = "VAR_13")
	private Evaluacion var13;

	/** The var14. */
	@Basic
	@Column(name = "VAR_14")
	private Evaluacion var14;

	/** The var15. */
	@Basic
	@Column(name = "VAR_15")
	private Evaluacion var15;

	/** The var16. */
	@Basic
	@Column(name = "VAR_16")
	private Evaluacion var16;

	/** The var17. */
	@Basic
	@Column(name = "VAR_17")
	private Evaluacion var17;

	/** The var18. */
	@Basic
	@Column(name = "VAR_18")
	private Evaluacion var18;

	/** The var19. */
	@Basic
	@Column(name = "VAR_19")
	private Evaluacion var19;

	/** The var2. */
	@Basic
	@Column(name = "VAR_2")
	private Evaluacion var2;

	/** The var20. */
	@Basic
	@Column(name = "VAR_20")
	private Evaluacion var20;

	/** The var21. */
	@Basic
	@Column(name = "VAR_21")
	private Evaluacion var21;

	/** The var22. */
	@Basic
	@Column(name = "VAR_22")
	private Evaluacion var22;

	/** The var23. */
	@Basic
	@Column(name = "VAR_23")
	private Evaluacion var23;

	/** The var24. */
	@Basic
	@Column(name = "VAR_24")
	private Evaluacion var24;

	/** The var25. */
	@Basic
	@Column(name = "VAR_25")
	private Evaluacion var25;

	/** The var26. */
	@Basic
	@Column(name = "VAR_26")
	private Evaluacion var26;

	/** The var27. */
	@Basic
	@Column(name = "VAR_27")
	private Evaluacion var27;

	/** The var28. */
	@Basic
	@Column(name = "VAR_28")
	private Evaluacion var28;

	/** The var29. */
	@Basic
	@Column(name = "VAR_29")
	private Evaluacion var29;

	/** The var3. */
	@Basic
	@Column(name = "VAR_3")
	private Evaluacion var3;

	/** The var30. */
	@Basic
	@Column(name = "VAR_30")
	private Evaluacion var30;

	/** The var31. */
	@Basic
	@Column(name = "VAR_31")
	private Evaluacion var31;

	/** The var32. */
	@Basic
	@Column(name = "VAR_32")
	private Evaluacion var32;

	/** The var33. */
	@Basic
	@Column(name = "VAR_33")
	private Evaluacion var33;

	/** The var34. */
	@Basic
	@Column(name = "VAR_34")
	private Evaluacion var34;

	/** The var35. */
	@Basic
	@Column(name = "VAR_35")
	private Evaluacion var35;

	/** The var36. */
	@Basic
	@Column(name = "VAR_36")
	private Evaluacion var36;

	/** The var37. */
	@Basic
	@Column(name = "VAR_37")
	private Evaluacion var37;

	/** The var4. */
	@Basic
	@Column(name = "VAR_4")
	private Evaluacion var4;

	/** The var5. */
	@Basic
	@Column(name = "VAR_5")
	private Evaluacion var5;

	/** The var6. */
	@Basic
	@Column(name = "VAR_6")
	private Evaluacion var6;

	/** The var7. */
	@Basic
	@Column(name = "VAR_7")
	private Evaluacion var7;

	/** The var8. */
	@Basic
	@Column(name = "VAR_8")
	private Evaluacion var8;

	/** The var9. */
	@Basic
	@Column(name = "VAR_9")
	private Evaluacion var9;

	/**
	 * Instantiates a new gross motor function.
	 */
	public GrossMotorFunction() {
		super();
	}

	/**
	 * Instantiates a new gross motor function.
	 * 
	 * @param comentarios
	 *            the comentarios
	 * @param evaluacionIndicativa
	 *            the evaluacion indicativa
	 * @param id
	 *            the id
	 * @param var1
	 *            the var1
	 * @param var10
	 *            the var10
	 * @param var11
	 *            the var11
	 * @param var12
	 *            the var12
	 * @param var13
	 *            the var13
	 * @param var14
	 *            the var14
	 * @param var15
	 *            the var15
	 * @param var16
	 *            the var16
	 * @param var17
	 *            the var17
	 * @param var18
	 *            the var18
	 * @param var19
	 *            the var19
	 * @param var2
	 *            the var2
	 * @param var20
	 *            the var20
	 * @param var21
	 *            the var21
	 * @param var22
	 *            the var22
	 * @param var23
	 *            the var23
	 * @param var24
	 *            the var24
	 * @param var25
	 *            the var25
	 * @param var26
	 *            the var26
	 * @param var27
	 *            the var27
	 * @param var28
	 *            the var28
	 * @param var29
	 *            the var29
	 * @param var3
	 *            the var3
	 * @param var30
	 *            the var30
	 * @param var31
	 *            the var31
	 * @param var32
	 *            the var32
	 * @param var33
	 *            the var33
	 * @param var34
	 *            the var34
	 * @param var35
	 *            the var35
	 * @param var36
	 *            the var36
	 * @param var37
	 *            the var37
	 * @param var4
	 *            the var4
	 * @param var5
	 *            the var5
	 * @param var6
	 *            the var6
	 * @param var7
	 *            the var7
	 * @param var8
	 *            the var8
	 * @param var9
	 *            the var9
	 */
	public GrossMotorFunction(String comentarios, Boolean evaluacionIndicativa, Integer id, Evaluacion var1, Evaluacion var10, Evaluacion var11, Evaluacion var12, Evaluacion var13, Evaluacion var14, Evaluacion var15, Evaluacion var16, Evaluacion var17, Evaluacion var18, Evaluacion var19, Evaluacion var2, Evaluacion var20, Evaluacion var21, Evaluacion var22, Evaluacion var23, Evaluacion var24, Evaluacion var25, Evaluacion var26, Evaluacion var27, Evaluacion var28, Evaluacion var29, Evaluacion var3, Evaluacion var30, Evaluacion var31, Evaluacion var32, Evaluacion var33, Evaluacion var34, Evaluacion var35, Evaluacion var36, Evaluacion var37, Evaluacion var4, Evaluacion var5, Evaluacion var6, Evaluacion var7, Evaluacion var8, Evaluacion var9) {
		super();
		this.comentarios = comentarios;
		this.evaluacionIndicativa = evaluacionIndicativa;
		this.id = id;
		this.var1 = var1;
		this.var10 = var10;
		this.var11 = var11;
		this.var12 = var12;
		this.var13 = var13;
		this.var14 = var14;
		this.var15 = var15;
		this.var16 = var16;
		this.var17 = var17;
		this.var18 = var18;
		this.var19 = var19;
		this.var2 = var2;
		this.var20 = var20;
		this.var21 = var21;
		this.var22 = var22;
		this.var23 = var23;
		this.var24 = var24;
		this.var25 = var25;
		this.var26 = var26;
		this.var27 = var27;
		this.var28 = var28;
		this.var29 = var29;
		this.var3 = var3;
		this.var30 = var30;
		this.var31 = var31;
		this.var32 = var32;
		this.var33 = var33;
		this.var34 = var34;
		this.var35 = var35;
		this.var36 = var36;
		this.var37 = var37;
		this.var4 = var4;
		this.var5 = var5;
		this.var6 = var6;
		this.var7 = var7;
		this.var8 = var8;
		this.var9 = var9;
	}

	/**
	 * Gets the comentarios.
	 * 
	 * @return the comentarios
	 */
	public String getComentarios() {
		return comentarios;
	}

	/**
	 * Gets the evaluacion indicativa.
	 * 
	 * @return the evaluacion indicativa
	 */
	public Boolean getEvaluacionIndicativa() {
		return evaluacionIndicativa;
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
	 * Gets the var1.
	 * 
	 * @return the var1
	 */
	public Evaluacion getVar1() {
		return var1;
	}

	/**
	 * Gets the var10.
	 * 
	 * @return the var10
	 */
	public Evaluacion getVar10() {
		return var10;
	}

	/**
	 * Gets the var11.
	 * 
	 * @return the var11
	 */
	public Evaluacion getVar11() {
		return var11;
	}

	/**
	 * Gets the var12.
	 * 
	 * @return the var12
	 */
	public Evaluacion getVar12() {
		return var12;
	}

	/**
	 * Gets the var13.
	 * 
	 * @return the var13
	 */
	public Evaluacion getVar13() {
		return var13;
	}

	/**
	 * Gets the var14.
	 * 
	 * @return the var14
	 */
	public Evaluacion getVar14() {
		return var14;
	}

	/**
	 * Gets the var15.
	 * 
	 * @return the var15
	 */
	public Evaluacion getVar15() {
		return var15;
	}

	/**
	 * Gets the var16.
	 * 
	 * @return the var16
	 */
	public Evaluacion getVar16() {
		return var16;
	}

	/**
	 * Gets the var17.
	 * 
	 * @return the var17
	 */
	public Evaluacion getVar17() {
		return var17;
	}

	/**
	 * Gets the var18.
	 * 
	 * @return the var18
	 */
	public Evaluacion getVar18() {
		return var18;
	}

	/**
	 * Gets the var19.
	 * 
	 * @return the var19
	 */
	public Evaluacion getVar19() {
		return var19;
	}

	/**
	 * Gets the var2.
	 * 
	 * @return the var2
	 */
	public Evaluacion getVar2() {
		return var2;
	}

	/**
	 * Gets the var20.
	 * 
	 * @return the var20
	 */
	public Evaluacion getVar20() {
		return var20;
	}

	/**
	 * Gets the var21.
	 * 
	 * @return the var21
	 */
	public Evaluacion getVar21() {
		return var21;
	}

	/**
	 * Gets the var22.
	 * 
	 * @return the var22
	 */
	public Evaluacion getVar22() {
		return var22;
	}

	/**
	 * Gets the var23.
	 * 
	 * @return the var23
	 */
	public Evaluacion getVar23() {
		return var23;
	}

	/**
	 * Gets the var24.
	 * 
	 * @return the var24
	 */
	public Evaluacion getVar24() {
		return var24;
	}

	/**
	 * Gets the var25.
	 * 
	 * @return the var25
	 */
	public Evaluacion getVar25() {
		return var25;
	}

	/**
	 * Gets the var26.
	 * 
	 * @return the var26
	 */
	public Evaluacion getVar26() {
		return var26;
	}

	/**
	 * Gets the var27.
	 * 
	 * @return the var27
	 */
	public Evaluacion getVar27() {
		return var27;
	}

	/**
	 * Gets the var28.
	 * 
	 * @return the var28
	 */
	public Evaluacion getVar28() {
		return var28;
	}

	/**
	 * Gets the var29.
	 * 
	 * @return the var29
	 */
	public Evaluacion getVar29() {
		return var29;
	}

	/**
	 * Gets the var3.
	 * 
	 * @return the var3
	 */
	public Evaluacion getVar3() {
		return var3;
	}

	/**
	 * Gets the var30.
	 * 
	 * @return the var30
	 */
	public Evaluacion getVar30() {
		return var30;
	}

	/**
	 * Gets the var31.
	 * 
	 * @return the var31
	 */
	public Evaluacion getVar31() {
		return var31;
	}

	/**
	 * Gets the var32.
	 * 
	 * @return the var32
	 */
	public Evaluacion getVar32() {
		return var32;
	}

	/**
	 * Gets the var33.
	 * 
	 * @return the var33
	 */
	public Evaluacion getVar33() {
		return var33;
	}

	/**
	 * Gets the var34.
	 * 
	 * @return the var34
	 */
	public Evaluacion getVar34() {
		return var34;
	}

	/**
	 * Gets the var35.
	 * 
	 * @return the var35
	 */
	public Evaluacion getVar35() {
		return var35;
	}

	/**
	 * Gets the var36.
	 * 
	 * @return the var36
	 */
	public Evaluacion getVar36() {
		return var36;
	}

	/**
	 * Gets the var37.
	 * 
	 * @return the var37
	 */
	public Evaluacion getVar37() {
		return var37;
	}

	/**
	 * Gets the var4.
	 * 
	 * @return the var4
	 */
	public Evaluacion getVar4() {
		return var4;
	}

	/**
	 * Gets the var5.
	 * 
	 * @return the var5
	 */
	public Evaluacion getVar5() {
		return var5;
	}

	/**
	 * Gets the var6.
	 * 
	 * @return the var6
	 */
	public Evaluacion getVar6() {
		return var6;
	}

	/**
	 * Gets the var7.
	 * 
	 * @return the var7
	 */
	public Evaluacion getVar7() {
		return var7;
	}

	/**
	 * Gets the var8.
	 * 
	 * @return the var8
	 */
	public Evaluacion getVar8() {
		return var8;
	}

	/**
	 * Gets the var9.
	 * 
	 * @return the var9
	 */
	public Evaluacion getVar9() {
		return var9;
	}

	/**
	 * Sets the comentarios.
	 * 
	 * @param comentarios
	 *            the new comentarios
	 */
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	/**
	 * Sets the evaluacion indicativa.
	 * 
	 * @param evaluacionIndicativa
	 *            the new evaluacion indicativa
	 */
	public void setEvaluacionIndicativa(Boolean evaluacionIndicativa) {
		this.evaluacionIndicativa = evaluacionIndicativa;
	}

	/**
	 * Sets the exploracion.
	 * 
	 * @param exploracion
	 *            the new exploracion
	 */
	public void setExploracion(Exploracion exploracion) {
		this.exploracion = exploracion;
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
	 * Sets the var1.
	 * 
	 * @param var1
	 *            the new var1
	 */
	public void setVar1(Evaluacion var1) {
		this.var1 = var1;
	}

	/**
	 * Sets the var10.
	 * 
	 * @param var10
	 *            the new var10
	 */
	public void setVar10(Evaluacion var10) {
		this.var10 = var10;
	}

	/**
	 * Sets the var11.
	 * 
	 * @param var11
	 *            the new var11
	 */
	public void setVar11(Evaluacion var11) {
		this.var11 = var11;
	}

	/**
	 * Sets the var12.
	 * 
	 * @param var12
	 *            the new var12
	 */
	public void setVar12(Evaluacion var12) {
		this.var12 = var12;
	}

	/**
	 * Sets the var13.
	 * 
	 * @param var13
	 *            the new var13
	 */
	public void setVar13(Evaluacion var13) {
		this.var13 = var13;
	}

	/**
	 * Sets the var14.
	 * 
	 * @param var14
	 *            the new var14
	 */
	public void setVar14(Evaluacion var14) {
		this.var14 = var14;
	}

	/**
	 * Sets the var15.
	 * 
	 * @param var15
	 *            the new var15
	 */
	public void setVar15(Evaluacion var15) {
		this.var15 = var15;
	}

	/**
	 * Sets the var16.
	 * 
	 * @param var16
	 *            the new var16
	 */
	public void setVar16(Evaluacion var16) {
		this.var16 = var16;
	}

	/**
	 * Sets the var17.
	 * 
	 * @param var17
	 *            the new var17
	 */
	public void setVar17(Evaluacion var17) {
		this.var17 = var17;
	}

	/**
	 * Sets the var18.
	 * 
	 * @param var18
	 *            the new var18
	 */
	public void setVar18(Evaluacion var18) {
		this.var18 = var18;
	}

	/**
	 * Sets the var19.
	 * 
	 * @param var19
	 *            the new var19
	 */
	public void setVar19(Evaluacion var19) {
		this.var19 = var19;
	}

	/**
	 * Sets the var2.
	 * 
	 * @param var2
	 *            the new var2
	 */
	public void setVar2(Evaluacion var2) {
		this.var2 = var2;
	}

	/**
	 * Sets the var20.
	 * 
	 * @param var20
	 *            the new var20
	 */
	public void setVar20(Evaluacion var20) {
		this.var20 = var20;
	}

	/**
	 * Sets the var21.
	 * 
	 * @param var21
	 *            the new var21
	 */
	public void setVar21(Evaluacion var21) {
		this.var21 = var21;
	}

	/**
	 * Sets the var22.
	 * 
	 * @param var22
	 *            the new var22
	 */
	public void setVar22(Evaluacion var22) {
		this.var22 = var22;
	}

	/**
	 * Sets the var23.
	 * 
	 * @param var23
	 *            the new var23
	 */
	public void setVar23(Evaluacion var23) {
		this.var23 = var23;
	}

	/**
	 * Sets the var24.
	 * 
	 * @param var24
	 *            the new var24
	 */
	public void setVar24(Evaluacion var24) {
		this.var24 = var24;
	}

	/**
	 * Sets the var25.
	 * 
	 * @param var25
	 *            the new var25
	 */
	public void setVar25(Evaluacion var25) {
		this.var25 = var25;
	}

	/**
	 * Sets the var26.
	 * 
	 * @param var26
	 *            the new var26
	 */
	public void setVar26(Evaluacion var26) {
		this.var26 = var26;
	}

	/**
	 * Sets the var27.
	 * 
	 * @param var27
	 *            the new var27
	 */
	public void setVar27(Evaluacion var27) {
		this.var27 = var27;
	}

	/**
	 * Sets the var28.
	 * 
	 * @param var28
	 *            the new var28
	 */
	public void setVar28(Evaluacion var28) {
		this.var28 = var28;
	}

	/**
	 * Sets the var29.
	 * 
	 * @param var29
	 *            the new var29
	 */
	public void setVar29(Evaluacion var29) {
		this.var29 = var29;
	}

	/**
	 * Sets the var3.
	 * 
	 * @param var3
	 *            the new var3
	 */
	public void setVar3(Evaluacion var3) {
		this.var3 = var3;
	}

	/**
	 * Sets the var30.
	 * 
	 * @param var30
	 *            the new var30
	 */
	public void setVar30(Evaluacion var30) {
		this.var30 = var30;
	}

	/**
	 * Sets the var31.
	 * 
	 * @param var31
	 *            the new var31
	 */
	public void setVar31(Evaluacion var31) {
		this.var31 = var31;
	}

	/**
	 * Sets the var32.
	 * 
	 * @param var32
	 *            the new var32
	 */
	public void setVar32(Evaluacion var32) {
		this.var32 = var32;
	}

	/**
	 * Sets the var33.
	 * 
	 * @param var33
	 *            the new var33
	 */
	public void setVar33(Evaluacion var33) {
		this.var33 = var33;
	}

	/**
	 * Sets the var34.
	 * 
	 * @param var34
	 *            the new var34
	 */
	public void setVar34(Evaluacion var34) {
		this.var34 = var34;
	}

	/**
	 * Sets the var35.
	 * 
	 * @param var35
	 *            the new var35
	 */
	public void setVar35(Evaluacion var35) {
		this.var35 = var35;
	}

	/**
	 * Sets the var36.
	 * 
	 * @param var36
	 *            the new var36
	 */
	public void setVar36(Evaluacion var36) {
		this.var36 = var36;
	}

	/**
	 * Sets the var37.
	 * 
	 * @param var37
	 *            the new var37
	 */
	public void setVar37(Evaluacion var37) {
		this.var37 = var37;
	}

	/**
	 * Sets the var4.
	 * 
	 * @param var4
	 *            the new var4
	 */
	public void setVar4(Evaluacion var4) {
		this.var4 = var4;
	}

	/**
	 * Sets the var5.
	 * 
	 * @param var5
	 *            the new var5
	 */
	public void setVar5(Evaluacion var5) {
		this.var5 = var5;
	}

	/**
	 * Sets the var6.
	 * 
	 * @param var6
	 *            the new var6
	 */
	public void setVar6(Evaluacion var6) {
		this.var6 = var6;
	}

	/**
	 * Sets the var7.
	 * 
	 * @param var7
	 *            the new var7
	 */
	public void setVar7(Evaluacion var7) {
		this.var7 = var7;
	}

	/**
	 * Sets the var8.
	 * 
	 * @param var8
	 *            the new var8
	 */
	public void setVar8(Evaluacion var8) {
		this.var8 = var8;
	}

	/**
	 * Sets the var9.
	 * 
	 * @param var9
	 *            the new var9
	 */
	public void setVar9(Evaluacion var9) {
		this.var9 = var9;
	}

}
