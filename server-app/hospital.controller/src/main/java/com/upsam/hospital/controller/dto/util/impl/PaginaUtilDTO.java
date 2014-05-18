package com.upsam.hospital.controller.dto.util.impl;

import org.springframework.stereotype.Component;
import com.upsam.hospital.controller.dto.CampoDTO;
import com.upsam.hospital.controller.dto.PaginaDTO;
import com.upsam.hospital.controller.dto.util.IPaginaUtilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Campo;
import com.upsam.hospital.model.beans.Pagina;

@Component
public class PaginaUtilDTO implements IPaginaUtilDTO {

	@Override
	public Pagina toBusiness(PaginaDTO paginaDTO) throws TransferObjectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaginaDTO toRest(Pagina pagina) throws TransferObjectException {
		CampoDTO campoDTO;
		PaginaDTO paginaDTO = new PaginaDTO();
		paginaDTO.setNombre(pagina.getNombre());
		paginaDTO.setId(pagina.getId());
		for (Campo campo : pagina.getCampos()) {
			campoDTO = new CampoDTO();
			campoDTO.setIdPagina(pagina.getId());
			campoDTO.setNombre(campo.getNombre());
			campoDTO.setId(campo.getId());
			paginaDTO.addCampoDTO(campoDTO);
		}
		return paginaDTO;
	}

	@Override
	public PaginaDTO toRestInfoPaginas(Pagina pagina) throws TransferObjectException {
		CampoDTO campoDTO;
		PaginaDTO paginaDTO = new PaginaDTO();
		paginaDTO.setNombre(pagina.getNombre());
		paginaDTO.setId(pagina.getId());
		for (Campo campo : pagina.getCampos()) {
			if (campo.getMinValue() != null && campo.getMaxValue() != null) {
				campoDTO = new CampoDTO();
				campoDTO.setIdPagina(pagina.getId());
				campoDTO.setNombre(campo.getNombre());
				campoDTO.setId(campo.getId());
				campoDTO.setMaxValue(campo.getMaxValue());
				campoDTO.setMinValue(campo.getMinValue());
				paginaDTO.addCampoDTO(campoDTO);
			}
		}
		return paginaDTO;
	}
}
