package com.upsam.hospital.controller.dto.util;

import com.upsam.hospital.controller.dto.AntecedentesPersonalesDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.AntecedentesPersonales;

/**
 * The Interface IExploracionUtilDTO.
 */
public interface IAntecedentesPersonalesUtilDTO {

	AntecedentesPersonales toBusiness(AntecedentesPersonalesDTO antecedentesPersonalesDTO) throws TransferObjectException;

	AntecedentesPersonalesDTO toRest(AntecedentesPersonales antecedentesPersonales) throws TransferObjectException;
}
