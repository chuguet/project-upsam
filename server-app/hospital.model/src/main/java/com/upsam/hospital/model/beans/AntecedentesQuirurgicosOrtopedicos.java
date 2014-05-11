package com.upsam.hospital.model.beans;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ANTECEDENTES_QUIRURGICOS_ORTOPEDICOS")
public class AntecedentesQuirurgicosOrtopedicos implements IModelHospital {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ANTECEDENTES_QUIRURGICOS")
	private Integer id;

	@Column(name = "FECHA")
	private Date fecha;

	@Column(name = "DESCRIPCION")
	private String descripcion;

	@Column(name = "ES_QUIRURGICO")
	private Boolean esQuirurgico;

	/** The exploracion. */
	@ManyToOne
	@JoinColumn(name = "ID_ANTECEDENTES_PERSONALES")
	private AntecedentesPersonales antecedentesPersonales;

	public AntecedentesQuirurgicosOrtopedicos() {
		super();
	}

	public AntecedentesQuirurgicosOrtopedicos(Integer id) {
		super();
		this.id = id;
	}

	public AntecedentesQuirurgicosOrtopedicos(Integer id, Date fecha, String descripcion, Boolean esQuirurgico) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.esQuirurgico = esQuirurgico;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getEsQuirurgico() {
		return esQuirurgico;
	}

	public void setEsQuirurgico(Boolean esQuirurgico) {
		this.esQuirurgico = esQuirurgico;
	}

	public AntecedentesPersonales getAntecedentesPersonales() {
		return antecedentesPersonales;
	}

	public void setAntecedentesPersonales(AntecedentesPersonales antecedentesPersonales) {
		this.antecedentesPersonales = antecedentesPersonales;
	}
}