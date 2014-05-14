package com.upsam.hospital.controller.dto.util.impl;

import org.springframework.stereotype.Component;
import com.upsam.hospital.controller.dto.ReglaDTO;
import com.upsam.hospital.controller.dto.util.IReglaUtilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Campo;
import com.upsam.hospital.model.beans.CampoRellenado;
import com.upsam.hospital.model.beans.CampoSugerido;
import com.upsam.hospital.model.beans.Regla;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaUtilDTO.
 */
@Component
public class ReglaUtilDTO implements IReglaUtilDTO {

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.controller.dto.util.IReglaUtilDTO#toBusiness(com.upsam
	 * .hospital.controller.dto.ReglaDTO)
	 */
	@Override
	public Regla toBusiness(ReglaDTO reglaDTO) throws TransferObjectException {
		CampoRellenado campoRellenado;
		CampoSugerido campoSugerido;
		Campo campo;
		Regla regla = new Regla();
		regla.setDescripcion(reglaDTO.getDescripcion());
		regla.setMensaje(reglaDTO.getMensaje());
		regla.setId(reglaDTO.getId());
		for (CampoRellenadoDTO campoRellenadoDTO : reglaDTO.getCamposRellenadosDTO()) {
			campoRellenado = new CampoRellenado();
			campo = new Campo();
			campo.setId(campoRellenadoDTO.getIdCampo());
			campoRellenado.setCampo(campo);
			campoRellenado.setRegla(regla);
			campoRellenado.setId(campoRellenadoDTO.getId());
			regla.addCampoRellenado(campoRellenado);
		}
		for (CampoSugeridoDTO campoSugeridoDTO : reglaDTO.getCamposSugeridosDTO()) {
			campoSugerido = new CampoSugerido();
			campo = new Campo();
			campo.setId(campoSugeridoDTO.getIdCampo());
			campoSugerido.setCampo(campo);
			campoSugerido.setRegla(regla);
			campoSugerido.setId(campoSugerido.getId());
			regla.addCampoSugerido(campoSugerido);
		}
		return regla;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.controller.dto.util.IReglaUtilDTO#toRest(com.upsam
	 * .hospital.model.beans.Regla)
	 */
	@Override
	public ReglaDTO toRest(Regla regla) throws TransferObjectException {
		CampoRellenadoDTO campoRellenadoDTO;
		CampoSugeridoDTO campoSugeridoDTO;
		ReglaDTO reglaDTO = new ReglaDTO();
		reglaDTO.setMensaje(regla.getMensaje());
		reglaDTO.setDescripcion(regla.getDescripcion());
		reglaDTO.setId(regla.getId());
		for (CampoRellenado campoRellenado : regla.getCamposRellenados()) {
			campoRellenadoDTO = new CampoRellenadoDTO();
			campoRellenadoDTO.setId(campoRellenado.getId());
			campoRellenadoDTO.setIdCampo(campoRellenado.getCampo().getId());
			reglaDTO.addCampoRellenadoDTO(campoRellenadoDTO);
		}
		for (CampoSugerido campoSugerido : regla.getCamposSugeridos()) {
			campoSugeridoDTO = new CampoSugeridoDTO();
			campoSugeridoDTO.setId(campoSugerido.getId());
			campoSugeridoDTO.setIdCampo(campoSugerido.getCampo().getId());
			reglaDTO.addCampoSugeridoDTO(campoSugeridoDTO);
		}
		return reglaDTO;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.controller.dto.util.IReglaUtilDTO#toRestInfo(com.upsam
	 * .hospital.model.beans.Regla)
	 */
	@Override
	public ReglaDTO toRestInfo(Regla regla) throws TransferObjectException {
		ReglaDTO reglaDTO = new ReglaDTO();
		reglaDTO.setMensaje(regla.getMensaje());
		reglaDTO.setDescripcion(regla.getDescripcion());
		reglaDTO.setId(regla.getId());
		return reglaDTO;
	}

}
