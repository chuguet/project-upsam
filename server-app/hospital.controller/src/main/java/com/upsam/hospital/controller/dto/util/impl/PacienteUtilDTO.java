package com.upsam.hospital.controller.dto.util.impl;

import org.springframework.stereotype.Component;

import com.upsam.hospital.controller.dto.PacienteDTO;
import com.upsam.hospital.controller.dto.util.IPacienteUtilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Paciente;

// TODO: Auto-generated Javadoc
/**
 * The Class DataTransferObjectUsuario.
 */
@Component
public class PacienteUtilDTO implements IPacienteUtilDTO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.controller.dto.util.IUsuarioUtilDTO#toBusiness(com
	 * .upsam.apuestas.controller.dto.UsuarioDTO)
	 */
	/**
	 * To business.
	 * 
	 * @param pacienteDTO
	 *            the paciente dto
	 * @return the paciente
	 * @throws TransferObjectException
	 *             the transfer object exception
	 */
	@Override
	public Paciente toBusiness(PacienteDTO pacienteDTO)
			throws TransferObjectException {
		Paciente paciente = new Paciente();
		paciente.setId(pacienteDTO.getId());
		paciente.setNombre(pacienteDTO.getNombre());
		paciente.setApellidos(pacienteDTO.getApellidos());
		paciente.setEmail(pacienteDTO.getEmail());
		paciente.setExpediente(pacienteDTO.getExpediente());
		return paciente;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.controller.dto.util.IUsuarioUtilDTO#toRest(com.upsam
	 * .apuestas.model.bean.Usuario)
	 */
	/**
	 * To rest.
	 * 
	 * @param paciente
	 *            the paciente
	 * @return the paciente dto
	 * @throws TransferObjectException
	 *             the transfer object exception
	 */
	@Override
	public PacienteDTO toRest(Paciente paciente) throws TransferObjectException {
		PacienteDTO pacienteDTO = new PacienteDTO();
		pacienteDTO.setId(paciente.getId());
		pacienteDTO.setNombre(paciente.getNombre());
		pacienteDTO.setApellidos(paciente.getApellidos());
		pacienteDTO.setExpediente(paciente.getExpediente());
		pacienteDTO.setEmail(paciente.getEmail());
		return pacienteDTO;
	}
}
