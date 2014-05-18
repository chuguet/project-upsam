package com.upsam.hospital.controller.dto.util.impl;

import org.springframework.stereotype.Component;
import com.upsam.hospital.controller.dto.CampoInfoDTO;
import com.upsam.hospital.controller.dto.ReglaDTO;
import com.upsam.hospital.controller.dto.util.IReglaUtilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Campo;
import com.upsam.hospital.model.beans.CampoInfo;
import com.upsam.hospital.model.beans.CampoRellenado;
import com.upsam.hospital.model.beans.CampoSugerido;
import com.upsam.hospital.model.beans.Regla;
import com.upsam.hospital.model.enums.Operacion;
import com.upsam.hospital.model.enums.TipoRegla;

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
		CampoInfo campoInfo;
		Campo campo;
		Regla regla = new Regla();
		regla.setTitulo(reglaDTO.getTitulo());
		regla.setMensaje(reglaDTO.getMensaje());
		regla.setId(reglaDTO.getId());
		regla.setTipoRegla(TipoRegla.values()[reglaDTO.getTipoRegla()]);
		if (reglaDTO.getCamposRellenadosDTO() != null) {
			for (CampoRellenadoDTO campoRellenadoDTO : reglaDTO.getCamposRellenadosDTO()) {
				campoRellenado = new CampoRellenado();
				campo = new Campo();
				campo.setId(campoRellenadoDTO.getIdCampo());
				campoRellenado.setCampo(campo);
				campoRellenado.setRegla(regla);
				campoRellenado.setId(campoRellenadoDTO.getId());
				regla.addCampoRellenado(campoRellenado);
			}
		}
		if (reglaDTO.getCamposSugeridosDTO() != null) {
			for (CampoSugeridoDTO campoSugeridoDTO : reglaDTO.getCamposSugeridosDTO()) {
				campoSugerido = new CampoSugerido();
				campo = new Campo();
				campo.setId(campoSugeridoDTO.getIdCampo());
				campoSugerido.setCampo(campo);
				campoSugerido.setRegla(regla);
				campoSugerido.setId(campoSugeridoDTO.getId());
				regla.addCampoSugerido(campoSugerido);
			}
		}
		if (reglaDTO.getCamposInfosDTO() != null) {
			for (CampoInfoDTO campoInfoDTO : reglaDTO.getCamposInfosDTO()) {
				campoInfo = new CampoInfo();
				campo = new Campo();
				campo.setId(campoInfoDTO.getIdCampo());
				campoInfo.setCampo(campo);
				campoInfo.setRegla(regla);
				campoInfo.setOperacion(Operacion.values()[campoInfoDTO.getOperacion()]);
				campoInfo.setValor(campoInfoDTO.getValor());
				campoInfo.setId(campoInfoDTO.getId());
				regla.addCampoInfo(campoInfo);
			}
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
		CampoInfoDTO campoInfoDTO;
		ReglaDTO reglaDTO = new ReglaDTO();
		reglaDTO.setMensaje(regla.getMensaje());
		reglaDTO.setTitulo(regla.getTitulo());
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
		for (CampoInfo campoInfo : regla.getCamposInfos()) {
			campoInfoDTO = new CampoInfoDTO();
			campoInfoDTO.setId(campoInfo.getId());
			campoInfoDTO.setIdCampo(campoInfo.getCampo().getId());
			campoInfoDTO.setOperacion(campoInfo.getOperacion().ordinal());
			campoInfoDTO.setValor(campoInfo.getValor());
			reglaDTO.addCampoInfoDTO(campoInfoDTO);
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
		reglaDTO.setTitulo(regla.getTitulo());
		reglaDTO.setId(regla.getId());
		return reglaDTO;
	}

}
