package com.upsam.hospital.controller.dto.util.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.stereotype.Component;
import com.upsam.hospital.controller.dto.AntecedentesPersonalesDTO;
import com.upsam.hospital.controller.dto.util.IAntecedentesPersonalesUtilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.AntecedentesPersonales;
import com.upsam.hospital.model.beans.Exploracion;

// TODO: Auto-generated Javadoc
/**
 * The Class ExploracionUtilDTO.
 */
@Component
public class AntecedentesPersonalesUtilDTO implements IAntecedentesPersonalesUtilDTO {

	/** The Constant DATE_FORMATTER. */
	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.controller.dto.util.IExploracionUtilDTO#toBusiness
	 * (com.upsam.hospital.controller.dto.AntecedentesPersonalesDTO)
	 */
	@Override
	public AntecedentesPersonales toBusiness(AntecedentesPersonalesDTO antecedentesPersonalesDTO) throws TransferObjectException {
		try {
			AntecedentesPersonales antecedentesPersonales = new AntecedentesPersonales();
			antecedentesPersonales.setId(antecedentesPersonalesDTO.getId());
			antecedentesPersonales.setEpilepsia(antecedentesPersonalesDTO.getEpilepsia());
			antecedentesPersonales.setTipoEpilepsia(antecedentesPersonalesDTO.getTipoEpilepsia());
			if (antecedentesPersonalesDTO.getFechaUltimaCrisis() != null && antecedentesPersonalesDTO.getFechaUltimaCrisis().length() > 0) {
				antecedentesPersonales.setFechaUltimaCrisis(DATE_FORMATTER.parse(antecedentesPersonalesDTO.getFechaUltimaCrisis()));
			}
			if (antecedentesPersonalesDTO.getFechaUltimaConvulsion() != null && antecedentesPersonalesDTO.getFechaUltimaConvulsion().length() > 0) {
				antecedentesPersonales.setFechaUltimaConvulsion(DATE_FORMATTER.parse(antecedentesPersonalesDTO.getFechaUltimaConvulsion()));
			}

			antecedentesPersonales.setNumeroCrisis(antecedentesPersonalesDTO.getNumeroCrisis());
			antecedentesPersonales.setCaidas(antecedentesPersonalesDTO.getCaidas());
			antecedentesPersonales.setNumeroCaidas(antecedentesPersonalesDTO.getNumeroCaidas());
			if (antecedentesPersonalesDTO.getFechaUltimaCaida() != null && antecedentesPersonalesDTO.getFechaUltimaCaida().length() > 0) {
				antecedentesPersonales.setFechaUltimaCaida(DATE_FORMATTER.parse(antecedentesPersonalesDTO.getFechaUltimaCaida()));
			}
			antecedentesPersonales.setAudicion(antecedentesPersonalesDTO.getAudicion());
			antecedentesPersonales.setVision(antecedentesPersonalesDTO.getVision());
			antecedentesPersonales.setLenguajeCognicion(antecedentesPersonalesDTO.getLenguajeCognicion());
			antecedentesPersonales.setComprension(antecedentesPersonalesDTO.getComprension());
			antecedentesPersonales.setEntiendeOrdenesSimples(antecedentesPersonalesDTO.getEntiendeOrdenesSimples());
			antecedentesPersonales.setEntiendeOrdenesComplejas(antecedentesPersonalesDTO.getEntiendeOrdenesComplejas());
			antecedentesPersonales.setExpresarNecesidadDolor(antecedentesPersonalesDTO.getExpresarNecesidadDolor());
			antecedentesPersonales.setNumeroInyecciones(antecedentesPersonalesDTO.getNumeroInyecciones());
			if (antecedentesPersonalesDTO.getFechaUltimaSesion() != null && antecedentesPersonalesDTO.getFechaUltimaSesion().length() > 0) {
				antecedentesPersonales.setFechaUltimaSesion(DATE_FORMATTER.parse(antecedentesPersonalesDTO.getFechaUltimaSesion()));
			}
			if (antecedentesPersonalesDTO.getFechaPenultimaSesion() != null && antecedentesPersonalesDTO.getFechaPenultimaSesion().length() > 0) {
				antecedentesPersonales.setFechaPenultimaSesion(DATE_FORMATTER.parse(antecedentesPersonalesDTO.getFechaPenultimaSesion()));
			}

			antecedentesPersonales.setLocalizacionTratamiento(antecedentesPersonalesDTO.getLocalizacionTratamiento());
			antecedentesPersonales.setAlergias(antecedentesPersonalesDTO.getAlergias());
			antecedentesPersonales.setTratamiento(antecedentesPersonalesDTO.getTratamiento());
			antecedentesPersonales.setExploracion(new Exploracion(antecedentesPersonalesDTO.getIdExploracion()));

			return antecedentesPersonales;
		}
		catch (ParseException e) {
			throw new TransferObjectException(e.getMessage(), e);
		}
	}

	@Override
	public AntecedentesPersonalesDTO toRest(AntecedentesPersonales antecedentesPersonales) throws TransferObjectException {
		AntecedentesPersonalesDTO antecedentesPersonalesDTO = new AntecedentesPersonalesDTO();
		antecedentesPersonalesDTO.setId(antecedentesPersonales.getId());
		antecedentesPersonalesDTO.setEpilepsia(antecedentesPersonales.getEpilepsia());
		antecedentesPersonalesDTO.setTipoEpilepsia(antecedentesPersonales.getTipoEpilepsia());
		if (antecedentesPersonales.getFechaUltimaCrisis() != null) {
			antecedentesPersonalesDTO.setFechaUltimaCrisis(DATE_FORMATTER.format(antecedentesPersonales.getFechaUltimaCrisis()));
		}
		if (antecedentesPersonales.getFechaUltimaConvulsion() != null) {
			antecedentesPersonalesDTO.setFechaUltimaConvulsion(DATE_FORMATTER.format(antecedentesPersonales.getFechaUltimaConvulsion()));
		}

		antecedentesPersonalesDTO.setNumeroCrisis(antecedentesPersonales.getNumeroCrisis());
		antecedentesPersonalesDTO.setCaidas(antecedentesPersonales.getCaidas());
		antecedentesPersonalesDTO.setNumeroCaidas(antecedentesPersonales.getNumeroCaidas());
		if (antecedentesPersonales.getFechaUltimaCaida() != null) {
			antecedentesPersonalesDTO.setFechaUltimaCaida(DATE_FORMATTER.format(antecedentesPersonales.getFechaUltimaCaida()));
		}
		antecedentesPersonalesDTO.setAudicion(antecedentesPersonales.getAudicion());
		antecedentesPersonalesDTO.setVision(antecedentesPersonales.getVision());
		antecedentesPersonalesDTO.setLenguajeCognicion(antecedentesPersonales.getLenguajeCognicion());
		antecedentesPersonalesDTO.setComprension(antecedentesPersonales.getComprension());
		antecedentesPersonalesDTO.setEntiendeOrdenesSimples(antecedentesPersonales.getEntiendeOrdenesSimples());
		antecedentesPersonalesDTO.setEntiendeOrdenesComplejas(antecedentesPersonales.getEntiendeOrdenesComplejas());
		antecedentesPersonalesDTO.setExpresarNecesidadDolor(antecedentesPersonales.getExpresarNecesidadDolor());
		antecedentesPersonalesDTO.setNumeroInyecciones(antecedentesPersonales.getNumeroInyecciones());
		if (antecedentesPersonales.getFechaUltimaSesion() != null) {
			antecedentesPersonalesDTO.setFechaUltimaSesion(DATE_FORMATTER.format(antecedentesPersonales.getFechaUltimaSesion()));

		}
		if (antecedentesPersonales.getFechaPenultimaSesion() != null) {
			antecedentesPersonalesDTO.setFechaPenultimaSesion(DATE_FORMATTER.format(antecedentesPersonales.getFechaPenultimaSesion()));
		}

		antecedentesPersonalesDTO.setLocalizacionTratamiento(antecedentesPersonales.getLocalizacionTratamiento());
		antecedentesPersonalesDTO.setAlergias(antecedentesPersonales.getAlergias());
		antecedentesPersonalesDTO.setTratamiento(antecedentesPersonales.getTratamiento());
		return antecedentesPersonalesDTO;
	}
}
