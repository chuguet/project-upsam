package com.upsam.hospital.controller.dto.util.impl;

import org.springframework.stereotype.Component;
import com.upsam.hospital.controller.dto.GrossMotorFunctionDTO;
import com.upsam.hospital.controller.dto.util.IGrossMotorFunctionUtilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Exploracion;
import com.upsam.hospital.model.beans.GrossMotorFunction;

// TODO: Auto-generated Javadoc
/**
 * The Class GrossMotorFunctionUtilDTO.
 */
@Component
public class GrossMotorFunctionUtilDTO implements IGrossMotorFunctionUtilDTO {

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.controller.dto.util.IGrossMotorFunctionUtilDTO#toBusiness
	 * (com.upsam.hospital.controller.dto.GrossMotorFunctionDTO)
	 */
	@Override
	public GrossMotorFunction toBusiness(GrossMotorFunctionDTO grossMotorFunctionDTO) throws TransferObjectException {
		GrossMotorFunction grossMotorFunction = new GrossMotorFunction();
		grossMotorFunction.setComentarios(grossMotorFunctionDTO.getComentarios());
		grossMotorFunction.setEvaluacionIndicativa(grossMotorFunctionDTO.getEvaluacionIndicativa());
		grossMotorFunction.setExploracion(new Exploracion(grossMotorFunctionDTO.getIdExploracion()));
		grossMotorFunction.setId(grossMotorFunctionDTO.getId());
		grossMotorFunction.setVar1(grossMotorFunctionDTO.getVar1());
		grossMotorFunction.setVar2(grossMotorFunctionDTO.getVar2());
		grossMotorFunction.setVar3(grossMotorFunctionDTO.getVar3());
		grossMotorFunction.setVar4(grossMotorFunctionDTO.getVar4());
		grossMotorFunction.setVar4(grossMotorFunctionDTO.getVar4());
		grossMotorFunction.setVar5(grossMotorFunctionDTO.getVar5());
		grossMotorFunction.setVar6(grossMotorFunctionDTO.getVar6());
		grossMotorFunction.setVar7(grossMotorFunctionDTO.getVar7());
		grossMotorFunction.setVar8(grossMotorFunctionDTO.getVar8());
		grossMotorFunction.setVar9(grossMotorFunctionDTO.getVar9());
		grossMotorFunction.setVar10(grossMotorFunctionDTO.getVar10());
		grossMotorFunction.setVar11(grossMotorFunctionDTO.getVar11());
		grossMotorFunction.setVar12(grossMotorFunctionDTO.getVar12());
		grossMotorFunction.setVar13(grossMotorFunctionDTO.getVar13());
		grossMotorFunction.setVar14(grossMotorFunctionDTO.getVar14());
		grossMotorFunction.setVar14(grossMotorFunctionDTO.getVar14());
		grossMotorFunction.setVar15(grossMotorFunctionDTO.getVar15());
		grossMotorFunction.setVar16(grossMotorFunctionDTO.getVar16());
		grossMotorFunction.setVar17(grossMotorFunctionDTO.getVar17());
		grossMotorFunction.setVar18(grossMotorFunctionDTO.getVar18());
		grossMotorFunction.setVar19(grossMotorFunctionDTO.getVar19());
		grossMotorFunction.setVar20(grossMotorFunctionDTO.getVar20());
		grossMotorFunction.setVar21(grossMotorFunctionDTO.getVar21());
		grossMotorFunction.setVar22(grossMotorFunctionDTO.getVar22());
		grossMotorFunction.setVar23(grossMotorFunctionDTO.getVar23());
		grossMotorFunction.setVar24(grossMotorFunctionDTO.getVar24());
		grossMotorFunction.setVar24(grossMotorFunctionDTO.getVar24());
		grossMotorFunction.setVar25(grossMotorFunctionDTO.getVar25());
		grossMotorFunction.setVar26(grossMotorFunctionDTO.getVar26());
		grossMotorFunction.setVar27(grossMotorFunctionDTO.getVar27());
		grossMotorFunction.setVar28(grossMotorFunctionDTO.getVar28());
		grossMotorFunction.setVar29(grossMotorFunctionDTO.getVar29());
		grossMotorFunction.setVar30(grossMotorFunctionDTO.getVar30());
		grossMotorFunction.setVar31(grossMotorFunctionDTO.getVar31());
		grossMotorFunction.setVar32(grossMotorFunctionDTO.getVar32());
		grossMotorFunction.setVar33(grossMotorFunctionDTO.getVar33());
		grossMotorFunction.setVar34(grossMotorFunctionDTO.getVar34());
		grossMotorFunction.setVar34(grossMotorFunctionDTO.getVar34());
		grossMotorFunction.setVar35(grossMotorFunctionDTO.getVar35());
		grossMotorFunction.setVar36(grossMotorFunctionDTO.getVar36());
		grossMotorFunction.setVar37(grossMotorFunctionDTO.getVar37());
		return grossMotorFunction;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.controller.dto.util.IGrossMotorFunctionUtilDTO#toRest
	 * (com.upsam.hospital.model.beans.GrossMotorFunction)
	 */
	@Override
	public GrossMotorFunctionDTO toRest(GrossMotorFunction grossMotorFunction) throws TransferObjectException {
		GrossMotorFunctionDTO grossMotorFunctionDTO = new GrossMotorFunctionDTO();
		grossMotorFunctionDTO.setComentarios(grossMotorFunction.getComentarios());
		grossMotorFunctionDTO.setEvaluacionIndicativa(grossMotorFunction.getEvaluacionIndicativa());
		grossMotorFunctionDTO.setId(grossMotorFunction.getId());
		grossMotorFunctionDTO.setVar1(grossMotorFunction.getVar1());
		grossMotorFunctionDTO.setVar2(grossMotorFunction.getVar2());
		grossMotorFunctionDTO.setVar3(grossMotorFunction.getVar3());
		grossMotorFunctionDTO.setVar4(grossMotorFunction.getVar4());
		grossMotorFunctionDTO.setVar4(grossMotorFunction.getVar4());
		grossMotorFunctionDTO.setVar5(grossMotorFunction.getVar5());
		grossMotorFunctionDTO.setVar6(grossMotorFunction.getVar6());
		grossMotorFunctionDTO.setVar7(grossMotorFunction.getVar7());
		grossMotorFunctionDTO.setVar8(grossMotorFunction.getVar8());
		grossMotorFunctionDTO.setVar9(grossMotorFunction.getVar9());
		grossMotorFunctionDTO.setVar10(grossMotorFunction.getVar10());
		grossMotorFunctionDTO.setVar11(grossMotorFunction.getVar11());
		grossMotorFunctionDTO.setVar12(grossMotorFunction.getVar12());
		grossMotorFunctionDTO.setVar13(grossMotorFunction.getVar13());
		grossMotorFunctionDTO.setVar14(grossMotorFunction.getVar14());
		grossMotorFunctionDTO.setVar14(grossMotorFunction.getVar14());
		grossMotorFunctionDTO.setVar15(grossMotorFunction.getVar15());
		grossMotorFunctionDTO.setVar16(grossMotorFunction.getVar16());
		grossMotorFunctionDTO.setVar17(grossMotorFunction.getVar17());
		grossMotorFunctionDTO.setVar18(grossMotorFunction.getVar18());
		grossMotorFunctionDTO.setVar19(grossMotorFunction.getVar19());
		grossMotorFunctionDTO.setVar20(grossMotorFunction.getVar20());
		grossMotorFunctionDTO.setVar21(grossMotorFunction.getVar21());
		grossMotorFunctionDTO.setVar22(grossMotorFunction.getVar22());
		grossMotorFunctionDTO.setVar23(grossMotorFunction.getVar23());
		grossMotorFunctionDTO.setVar24(grossMotorFunction.getVar24());
		grossMotorFunctionDTO.setVar24(grossMotorFunction.getVar24());
		grossMotorFunctionDTO.setVar25(grossMotorFunction.getVar25());
		grossMotorFunctionDTO.setVar26(grossMotorFunction.getVar26());
		grossMotorFunctionDTO.setVar27(grossMotorFunction.getVar27());
		grossMotorFunctionDTO.setVar28(grossMotorFunction.getVar28());
		grossMotorFunctionDTO.setVar29(grossMotorFunction.getVar29());
		grossMotorFunctionDTO.setVar30(grossMotorFunction.getVar30());
		grossMotorFunctionDTO.setVar31(grossMotorFunction.getVar31());
		grossMotorFunctionDTO.setVar32(grossMotorFunction.getVar32());
		grossMotorFunctionDTO.setVar33(grossMotorFunction.getVar33());
		grossMotorFunctionDTO.setVar34(grossMotorFunction.getVar34());
		grossMotorFunctionDTO.setVar34(grossMotorFunction.getVar34());
		grossMotorFunctionDTO.setVar35(grossMotorFunction.getVar35());
		grossMotorFunctionDTO.setVar36(grossMotorFunction.getVar36());
		grossMotorFunctionDTO.setVar37(grossMotorFunction.getVar37());
		return grossMotorFunctionDTO;
	}

}
