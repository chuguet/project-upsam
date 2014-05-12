package com.upsam.hospital.controller.dto.util.impl;

import org.springframework.stereotype.Component;
import com.upsam.hospital.controller.dto.ReglaDTO;
import com.upsam.hospital.controller.dto.util.IReglaUtilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Campo;
import com.upsam.hospital.model.beans.CampoRellenado;
import com.upsam.hospital.model.beans.CampoSugerido;
import com.upsam.hospital.model.beans.Regla;

@Component
public class ReglaUtilDTO implements IReglaUtilDTO {

	@Override
	public Regla toBusiness(ReglaDTO reglaDTO) throws TransferObjectException {
		CampoRellenado campoRellenado;
		CampoSugerido campoSugerido;
		Campo campo;
		Regla regla = new Regla();
		regla.setDescripcion(reglaDTO.getDescripcion());
		regla.setId(reglaDTO.getId());
		for (Integer idCampo : reglaDTO.getTree1()) {
			campoRellenado = new CampoRellenado();
			campo = new Campo();
			campo.setId(idCampo);
			campoRellenado.setCampo(campo);
			campoRellenado.setRegla(regla);
			regla.addCampoRellenado(campoRellenado);
		}
		for (Integer idCampo : reglaDTO.getTree2()) {
			campoSugerido = new CampoSugerido();
			campo = new Campo();
			campo.setId(idCampo);
			campoSugerido.setCampo(campo);
			campoSugerido.setRegla(regla);
			regla.addCampoSugerido(campoSugerido);
		}
		return regla;
	}

	@Override
	public ReglaDTO toRest(Regla regla) throws TransferObjectException {
		// TODO Auto-generated method stub
		return null;
	}

}
