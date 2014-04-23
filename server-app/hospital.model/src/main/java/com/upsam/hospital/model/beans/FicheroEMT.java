package com.upsam.hospital.model.beans;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import com.upsam.hospital.model.enums.TipoMedida;
import com.upsam.hospital.model.enums.UnidadMedida;

// TODO: Auto-generated Javadoc
/**
 * The Class FicheroEMT.
 */
@Entity
@Table(name = "FICHERO_EMT")
public class FicheroEMT implements IModelHospital {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8823797142615984016L;

	/** The ciclos. */
	@Basic
	@Column(name = "CICLOS")
	private Integer ciclos;

	/** The paciente. */
	@ManyToOne
	@JoinColumn(name = "ID_EXPLORACION")
	private Exploracion exploracion;

	/** The fecha. */
	@Basic
	@Column(name = "FECHA")
	private Date fecha;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_FICHERO_EMT")
	private Integer id;

	/** The tabla datos. */
	@OneToOne
	@Cascade(value = CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "ID_TABLA_DATOS")
	private TablaDatos tablaDatos;

	/** The tipo medida. */
	@Basic
	@Column(name = "TIPO_MEDIDA")
	private TipoMedida tipoMedida;

	/** The unidad medida. */
	@Basic
	@Column(name = "UNIDAD_MEDIDA")
	private UnidadMedida unidadMedida;

	/**
	 * Instantiates a new fichero emt.
	 */
	public FicheroEMT() {
		super();
	}

	/**
	 * Instantiates a new fichero emt.
	 * 
	 * @param fecha
	 *            the fecha
	 * @param id
	 *            the id
	 */
	public FicheroEMT(Date fecha, Integer id) {
		super();
		this.fecha = fecha;
		this.id = id;
	}

	/**
	 * Instantiates a new fichero emt.
	 *
	 * @param ciclos the ciclos
	 * @param fecha the fecha
	 * @param id the id
	 * @param tablaDatos the tabla datos
	 * @param tipoMedida the tipo medida
	 * @param unidadMedida the unidad medida
	 */
	public FicheroEMT(Integer ciclos, Date fecha, Integer id, TablaDatos tablaDatos, TipoMedida tipoMedida, UnidadMedida unidadMedida) {
		super();
		this.ciclos = ciclos;
		this.fecha = fecha;
		this.id = id;
		this.tablaDatos = tablaDatos;
		this.tipoMedida = tipoMedida;
		this.unidadMedida = unidadMedida;
	}

	/**
	 * Gets the ciclos.
	 * 
	 * @return the ciclos
	 */
	public Integer getCiclos() {
		return ciclos;
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
	 * Gets the fecha.
	 * 
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
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
	 * Gets the tipo medida.
	 * 
	 * @return the tipo medida
	 */
	public TipoMedida getTipoMedida() {
		return tipoMedida;
	}

	/**
	 * Gets the unidad medida.
	 * 
	 * @return the unidad medida
	 */
	public UnidadMedida getUnidadMedida() {
		return unidadMedida;
	}

	/**
	 * Sets the ciclos.
	 * 
	 * @param ciclos
	 *            the new ciclos
	 */
	public void setCiclos(Integer ciclos) {
		this.ciclos = ciclos;
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
	 * Sets the fecha.
	 * 
	 * @param fecha
	 *            the new fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	/**
	 * Sets the tipo medida.
	 * 
	 * @param tipoMedida
	 *            the new tipo medida
	 */
	public void setTipoMedida(TipoMedida tipoMedida) {
		this.tipoMedida = tipoMedida;
	}

	/**
	 * Sets the unidad medida.
	 * 
	 * @param unidadMedida
	 *            the new unidad medida
	 */
	public void setUnidadMedida(UnidadMedida unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

}
