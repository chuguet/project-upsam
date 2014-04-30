package com.upsam.hospital.controller.dto.util.impl;

import org.springframework.stereotype.Component;
import com.upsam.hospital.controller.dto.AntecedentesRelacionadosPCIDTO;
import com.upsam.hospital.controller.dto.util.IAntecedentesRelacionadosPCIUtilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI;
import com.upsam.hospital.model.beans.Exploracion;
import com.upsam.hospital.model.enums.AyudasMarcha;
import com.upsam.hospital.model.enums.OrtesisDiurna;

// TODO: Auto-generated Javadoc
/**
 * The Class ExploracionUtilDTO.
 */
@Component
public class AntecedentesRelacionadosPCIUtilDTO implements IAntecedentesRelacionadosPCIUtilDTO {

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.controller.dto.util.IExploracionUtilDTO#toRest(com
	 * .upsam.hospital.model.beans.AntecedentesPersonalesPCI)
	 */
	@Override
	public AntecedentesRelacionadosPCIDTO toRest(AntecedentesRelacionadosPCI antecedentesRelacionadosPCI) throws TransferObjectException {
		AntecedentesRelacionadosPCIDTO antecedentesRelacionadosPCIDTO = new AntecedentesRelacionadosPCIDTO();
		if (antecedentesRelacionadosPCI.getAyudasMarcha() != null) {
			antecedentesRelacionadosPCIDTO.setAyudasMarcha(antecedentesRelacionadosPCI.getAyudasMarcha().ordinal());
		}
		antecedentesRelacionadosPCIDTO.setCuadriplejiaEspatica(antecedentesRelacionadosPCI.getCuadriplejiaEspatica());
		antecedentesRelacionadosPCIDTO.setDeportes(antecedentesRelacionadosPCI.getDeportes());
		antecedentesRelacionadosPCIDTO.setDiagnosticoEspecificar(antecedentesRelacionadosPCI.getDiagnosticoEspecificar());
		antecedentesRelacionadosPCIDTO.setDiplejiaEspatica(antecedentesRelacionadosPCI.getDiplejiaEspatica());
		antecedentesRelacionadosPCIDTO.setDispositivoMasUsado(antecedentesRelacionadosPCI.getDispositivoMasUsado());
		antecedentesRelacionadosPCIDTO.setEquipamiento(antecedentesRelacionadosPCI.getEquipamiento());
		antecedentesRelacionadosPCIDTO.setEtiologia(antecedentesRelacionadosPCI.getEtiologia());
		antecedentesRelacionadosPCIDTO.setExteriores(antecedentesRelacionadosPCI.getExteriores());
		antecedentesRelacionadosPCIDTO.setFisioterapiaDuracion(antecedentesRelacionadosPCI.getFisioterapiaDuracion());
		antecedentesRelacionadosPCIDTO.setFisioterapiaSesiones(antecedentesRelacionadosPCI.getFisioterapiaSesiones());
		antecedentesRelacionadosPCIDTO.setGradoI(antecedentesRelacionadosPCI.getGradoI());
		antecedentesRelacionadosPCIDTO.setGradoII(antecedentesRelacionadosPCI.getGradoII());
		antecedentesRelacionadosPCIDTO.setGradoIII(antecedentesRelacionadosPCI.getGradoIII());
		antecedentesRelacionadosPCIDTO.setGradoIV(antecedentesRelacionadosPCI.getGradoIV());
		antecedentesRelacionadosPCIDTO.setGradoV(antecedentesRelacionadosPCI.getGradoV());
		antecedentesRelacionadosPCIDTO.setHidroterapia(antecedentesRelacionadosPCI.getHidroterapia());
		antecedentesRelacionadosPCIDTO.setId(antecedentesRelacionadosPCI.getId());
		antecedentesRelacionadosPCIDTO.setInteriores(antecedentesRelacionadosPCI.getInteriores());
		antecedentesRelacionadosPCIDTO.setLgDuracion(antecedentesRelacionadosPCI.getLgDuracion());
		antecedentesRelacionadosPCIDTO.setLgSesiones(antecedentesRelacionadosPCI.getLgSesiones());
		antecedentesRelacionadosPCIDTO.setLocalizacion(antecedentesRelacionadosPCI.getLocalizacion());
		if (antecedentesRelacionadosPCI.getOrtesisDiurna() != null) {
			antecedentesRelacionadosPCIDTO.setOrtesisDiurna(antecedentesRelacionadosPCI.getOrtesisDiurna().ordinal());
		}
		antecedentesRelacionadosPCIDTO.setOtraOrtesis(antecedentesRelacionadosPCI.getOtraOrtesis());
		antecedentesRelacionadosPCIDTO.setOrtesisNocturna(antecedentesRelacionadosPCI.getOrtesisNocturna());
		antecedentesRelacionadosPCIDTO.setOtra(antecedentesRelacionadosPCI.getOtra());
		antecedentesRelacionadosPCIDTO.setOtras(antecedentesRelacionadosPCI.getOtras());
		antecedentesRelacionadosPCIDTO.setOtrasTerapias(antecedentesRelacionadosPCI.getOtrasTerapias());
		antecedentesRelacionadosPCIDTO.setPciMixta(antecedentesRelacionadosPCI.getPciMixta());
		antecedentesRelacionadosPCIDTO.setPruebasComlementarias(antecedentesRelacionadosPCI.getPruebasComplementarias());
		antecedentesRelacionadosPCIDTO.setTerapiaOcupacionalSesiones(antecedentesRelacionadosPCI.getTerapiaOcupacionalSesiones());
		antecedentesRelacionadosPCIDTO.setTerapiasHabituales(antecedentesRelacionadosPCI.getTerapiasHabituales());
		antecedentesRelacionadosPCIDTO.setTerapiaOcupacionalDuracion(antecedentesRelacionadosPCI.getTerapiaOcupacionalDuracion());
		antecedentesRelacionadosPCIDTO.setTratamientoActual(antecedentesRelacionadosPCI.getTratamientoActual());
		antecedentesRelacionadosPCIDTO.setTriplejiaEspatica(antecedentesRelacionadosPCI.getTriplejiaEspatica());
		return antecedentesRelacionadosPCIDTO;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.controller.dto.util.IExploracionUtilDTO#toBusiness
	 * (com.upsam.hospital.controller.dto.antecedentesRelacionadosPCIDTO)
	 */
	@Override
	public AntecedentesRelacionadosPCI toBusiness(AntecedentesRelacionadosPCIDTO antecedentesRelacionadosPCIDTO) throws TransferObjectException {
		AntecedentesRelacionadosPCI antecedentesRelacionadosPCI = new AntecedentesRelacionadosPCI();
		if (antecedentesRelacionadosPCIDTO.getAyudasMarcha() != null) {
			antecedentesRelacionadosPCI.setAyudasMarcha(AyudasMarcha.values()[antecedentesRelacionadosPCIDTO.getAyudasMarcha()]);
		}
		antecedentesRelacionadosPCI.setCuadriplejiaEspatica(antecedentesRelacionadosPCIDTO.getCuadriplejiaEspatica());
		antecedentesRelacionadosPCI.setDeportes(antecedentesRelacionadosPCIDTO.getDeportes());
		antecedentesRelacionadosPCI.setDiagnosticoEspecificar(antecedentesRelacionadosPCIDTO.getDiagnosticoEspecificar());
		antecedentesRelacionadosPCI.setDiplejiaEspatica(antecedentesRelacionadosPCIDTO.getDiplejiaEspatica());
		antecedentesRelacionadosPCI.setDispositivoMasUsado(antecedentesRelacionadosPCIDTO.getDispositivoMasUsado());
		antecedentesRelacionadosPCI.setEquipamiento(antecedentesRelacionadosPCIDTO.getEquipamiento());
		antecedentesRelacionadosPCI.setEtiologia(antecedentesRelacionadosPCIDTO.getEtiologia());
		antecedentesRelacionadosPCI.setExploracion(new Exploracion(antecedentesRelacionadosPCIDTO.getIdExploracion()));
		antecedentesRelacionadosPCI.setExteriores(antecedentesRelacionadosPCIDTO.getExteriores());
		antecedentesRelacionadosPCI.setFisioterapiaDuracion(antecedentesRelacionadosPCIDTO.getFisioterapiaDuracion());
		antecedentesRelacionadosPCI.setFisioterapiaSesiones(antecedentesRelacionadosPCIDTO.getFisioterapiaSesiones());
		antecedentesRelacionadosPCI.setGradoI(antecedentesRelacionadosPCIDTO.getGradoI());
		antecedentesRelacionadosPCI.setGradoII(antecedentesRelacionadosPCIDTO.getGradoII());
		antecedentesRelacionadosPCI.setGradoIII(antecedentesRelacionadosPCIDTO.getGradoIII());
		antecedentesRelacionadosPCI.setGradoIV(antecedentesRelacionadosPCIDTO.getGradoIV());
		antecedentesRelacionadosPCI.setGradoV(antecedentesRelacionadosPCIDTO.getGradoV());
		antecedentesRelacionadosPCI.setHidroterapia(antecedentesRelacionadosPCIDTO.getHidroterapia());
		antecedentesRelacionadosPCI.setId(antecedentesRelacionadosPCIDTO.getId());
		antecedentesRelacionadosPCI.setInteriores(antecedentesRelacionadosPCIDTO.getInteriores());
		antecedentesRelacionadosPCI.setLgDuracion(antecedentesRelacionadosPCIDTO.getLgDuracion());
		antecedentesRelacionadosPCI.setLgSesiones(antecedentesRelacionadosPCIDTO.getLgSesiones());
		antecedentesRelacionadosPCI.setLocalizacion(antecedentesRelacionadosPCIDTO.getLocalizacion());
		if (antecedentesRelacionadosPCIDTO.getOrtesisDiurna() != null) {
			antecedentesRelacionadosPCI.setOrtesisDiurna(OrtesisDiurna.values()[antecedentesRelacionadosPCIDTO.getOrtesisDiurna()]);
		}
		antecedentesRelacionadosPCI.setOtraOrtesis(antecedentesRelacionadosPCIDTO.getOtraOrtesis());
		antecedentesRelacionadosPCI.setOrtesisNocturna(antecedentesRelacionadosPCIDTO.getOrtesisNocturna());
		antecedentesRelacionadosPCI.setOtra(antecedentesRelacionadosPCIDTO.getOtra());
		antecedentesRelacionadosPCI.setOtras(antecedentesRelacionadosPCIDTO.getOtras());
		antecedentesRelacionadosPCI.setOtrasTerapias(antecedentesRelacionadosPCIDTO.getOtrasTerapias());
		antecedentesRelacionadosPCI.setPciMixta(antecedentesRelacionadosPCIDTO.getPciMixta());
		antecedentesRelacionadosPCI.setPruebasComplementarias(antecedentesRelacionadosPCIDTO.getPruebasComplementarias());
		antecedentesRelacionadosPCI.setTerapiaOcupacionalSesiones(antecedentesRelacionadosPCIDTO.getTerapiaOcupacionalSesiones());
		antecedentesRelacionadosPCI.setTerapiasHabituales(antecedentesRelacionadosPCIDTO.getTerapiasHabituales());
		antecedentesRelacionadosPCI.setTerapiaOcupacionalDuracion(antecedentesRelacionadosPCIDTO.getTerapiaOcupacionalDuracion());
		antecedentesRelacionadosPCI.setTratamientoActual(antecedentesRelacionadosPCIDTO.getTratamientoActual());
		antecedentesRelacionadosPCI.setTriplejiaEspatica(antecedentesRelacionadosPCIDTO.getTriplejiaEspatica());
		return antecedentesRelacionadosPCI;
	}
}
