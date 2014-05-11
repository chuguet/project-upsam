package com.upsam.hospital.controller.dto.util.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.stereotype.Component;
import com.upsam.hospital.controller.dto.AntecedentesQuirurgicosOrtopedicosDTO;
import com.upsam.hospital.controller.dto.util.IAntecedentesQuirurgicosUtilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.AntecedentesQuirurgicosOrtopedicos;

@Component
public class AntecedentesQuirurgicosOrtopedicosUtilDTO implements IAntecedentesQuirurgicosUtilDTO {

	/** The Constant DATE_FORMATTER. */
	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public AntecedentesQuirurgicosOrtopedicos toBusiness(AntecedentesQuirurgicosOrtopedicosDTO antecedentesQuirurgicosOrtopedicosDTO) throws TransferObjectException {
		try {
			AntecedentesQuirurgicosOrtopedicos antecedentesQuirurgicosOrtopedicos = new AntecedentesQuirurgicosOrtopedicos();
			if (antecedentesQuirurgicosOrtopedicosDTO.getFecha() != null && antecedentesQuirurgicosOrtopedicosDTO.getFecha().length() > 0) {
				antecedentesQuirurgicosOrtopedicos.setFecha(DATE_FORMATTER.parse(antecedentesQuirurgicosOrtopedicosDTO.getFecha()));
			}
			antecedentesQuirurgicosOrtopedicos.setDescripcion(antecedentesQuirurgicosOrtopedicosDTO.getDescripcion());
			return antecedentesQuirurgicosOrtopedicos;
		}
		catch (ParseException e) {
			throw new TransferObjectException(e.getMessage(), e);
		}
	}

	@Override
	public AntecedentesQuirurgicosOrtopedicosDTO toRest(AntecedentesQuirurgicosOrtopedicos antecedentesQuirurgicosOrtopedicos) throws TransferObjectException {
		AntecedentesQuirurgicosOrtopedicosDTO antecedentesQuirurgicosOrtopedicosDTO = new AntecedentesQuirurgicosOrtopedicosDTO();
		if (antecedentesQuirurgicosOrtopedicos.getFecha() != null) {
			antecedentesQuirurgicosOrtopedicosDTO.setFecha(DATE_FORMATTER.format(antecedentesQuirurgicosOrtopedicos.getFecha()));
		}
		antecedentesQuirurgicosOrtopedicosDTO.setDescripcion(antecedentesQuirurgicosOrtopedicos.getDescripcion());
		return antecedentesQuirurgicosOrtopedicosDTO;
	}
}
