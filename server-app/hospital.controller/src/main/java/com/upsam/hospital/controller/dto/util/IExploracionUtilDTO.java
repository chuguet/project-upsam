package com.upsam.hospital.controller.dto.util;

import java.util.List;
import com.upsam.hospital.controller.dto.ExploracionDTO;
import com.upsam.hospital.controller.dto.FicheroEMTDTO;
import com.upsam.hospital.controller.dto.FicheroEMTInfoDTO;
import com.upsam.hospital.controller.dto.FicheroMDXDTO;
import com.upsam.hospital.controller.dto.FicheroMDXInfoDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Exploracion;
import com.upsam.hospital.model.beans.FicheroEMT;
import com.upsam.hospital.model.beans.FicheroMDX;
import com.upsam.hospital.model.jaxb.EmxDataFile;

public interface IExploracionUtilDTO {

	FicheroEMTDTO fileEMTToDTO(FicheroEMT ficheroEMT);

	FicheroMDXDTO fileMDXToDTO(EmxDataFile emxDataFile);

	List<FicheroEMTInfoDTO> getFicherosEMTInfoList(List<FicheroEMT> ficheros);

	List<FicheroMDXInfoDTO> getFicherosMDXInfoList(List<FicheroMDX> ficheros);

	Exploracion toBusiness(ExploracionDTO exploracionDTO) throws TransferObjectException;

	ExploracionDTO toRest(Exploracion exploracion) throws TransferObjectException;
}
