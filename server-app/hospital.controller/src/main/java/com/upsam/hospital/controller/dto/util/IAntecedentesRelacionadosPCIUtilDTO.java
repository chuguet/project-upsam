package com.upsam.hospital.controller.dto.util;

import com.upsam.hospital.controller.dto.AntecedentesRelacionadosPCIDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI;

/**
 * The Interface IExploracionUtilDTO.
 */
public interface IAntecedentesRelacionadosPCIUtilDTO {

	AntecedentesRelacionadosPCI toBusiness(AntecedentesRelacionadosPCIDTO antecedentesPersonalesDTO) throws TransferObjectException;

	AntecedentesRelacionadosPCIDTO toRest(AntecedentesRelacionadosPCI antecedentesPersonales) throws TransferObjectException;
}
