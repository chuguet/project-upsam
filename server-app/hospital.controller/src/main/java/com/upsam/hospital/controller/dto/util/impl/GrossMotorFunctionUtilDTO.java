package com.upsam.hospital.controller.dto.util.impl;

import org.springframework.stereotype.Component;
import com.upsam.hospital.controller.dto.GrossMotorFunctionDTO;
import com.upsam.hospital.controller.dto.util.IGrossMotorFunctionUtilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Exploracion;
import com.upsam.hospital.model.beans.GrossMotorFunction;
import com.upsam.hospital.model.enums.Evaluacion;

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
		grossMotorFunction.setVar1(Evaluacion.values()[grossMotorFunctionDTO.getVar1()]);
		grossMotorFunction.setVar2(Evaluacion.values()[grossMotorFunctionDTO.getVar2()]);
		grossMotorFunction.setVar3(Evaluacion.values()[grossMotorFunctionDTO.getVar3()]);
		grossMotorFunction.setVar4(Evaluacion.values()[grossMotorFunctionDTO.getVar4()]);
		grossMotorFunction.setVar4(Evaluacion.values()[grossMotorFunctionDTO.getVar4()]);
		grossMotorFunction.setVar5(Evaluacion.values()[grossMotorFunctionDTO.getVar5()]);
		grossMotorFunction.setVar6(Evaluacion.values()[grossMotorFunctionDTO.getVar6()]);
		grossMotorFunction.setVar7(Evaluacion.values()[grossMotorFunctionDTO.getVar7()]);
		grossMotorFunction.setVar8(Evaluacion.values()[grossMotorFunctionDTO.getVar8()]);
		grossMotorFunction.setVar9(Evaluacion.values()[grossMotorFunctionDTO.getVar9()]);
		grossMotorFunction.setVar10(Evaluacion.values()[grossMotorFunctionDTO.getVar10()]);
		grossMotorFunction.setVar11(Evaluacion.values()[grossMotorFunctionDTO.getVar11()]);
		grossMotorFunction.setVar12(Evaluacion.values()[grossMotorFunctionDTO.getVar12()]);
		grossMotorFunction.setVar13(Evaluacion.values()[grossMotorFunctionDTO.getVar13()]);
		grossMotorFunction.setVar14(Evaluacion.values()[grossMotorFunctionDTO.getVar14()]);
		grossMotorFunction.setVar14(Evaluacion.values()[grossMotorFunctionDTO.getVar14()]);
		grossMotorFunction.setVar15(Evaluacion.values()[grossMotorFunctionDTO.getVar15()]);
		grossMotorFunction.setVar16(Evaluacion.values()[grossMotorFunctionDTO.getVar16()]);
		grossMotorFunction.setVar17(Evaluacion.values()[grossMotorFunctionDTO.getVar17()]);
		grossMotorFunction.setVar18(Evaluacion.values()[grossMotorFunctionDTO.getVar18()]);
		grossMotorFunction.setVar19(Evaluacion.values()[grossMotorFunctionDTO.getVar19()]);
		grossMotorFunction.setVar20(Evaluacion.values()[grossMotorFunctionDTO.getVar20()]);
		grossMotorFunction.setVar21(Evaluacion.values()[grossMotorFunctionDTO.getVar21()]);
		grossMotorFunction.setVar22(Evaluacion.values()[grossMotorFunctionDTO.getVar22()]);
		grossMotorFunction.setVar23(Evaluacion.values()[grossMotorFunctionDTO.getVar23()]);
		grossMotorFunction.setVar24(Evaluacion.values()[grossMotorFunctionDTO.getVar24()]);
		grossMotorFunction.setVar24(Evaluacion.values()[grossMotorFunctionDTO.getVar24()]);
		grossMotorFunction.setVar25(Evaluacion.values()[grossMotorFunctionDTO.getVar25()]);
		grossMotorFunction.setVar26(Evaluacion.values()[grossMotorFunctionDTO.getVar26()]);
		grossMotorFunction.setVar27(Evaluacion.values()[grossMotorFunctionDTO.getVar27()]);
		grossMotorFunction.setVar28(Evaluacion.values()[grossMotorFunctionDTO.getVar28()]);
		grossMotorFunction.setVar29(Evaluacion.values()[grossMotorFunctionDTO.getVar29()]);
		grossMotorFunction.setVar30(Evaluacion.values()[grossMotorFunctionDTO.getVar30()]);
		grossMotorFunction.setVar31(Evaluacion.values()[grossMotorFunctionDTO.getVar31()]);
		grossMotorFunction.setVar32(Evaluacion.values()[grossMotorFunctionDTO.getVar32()]);
		grossMotorFunction.setVar33(Evaluacion.values()[grossMotorFunctionDTO.getVar33()]);
		grossMotorFunction.setVar34(Evaluacion.values()[grossMotorFunctionDTO.getVar34()]);
		grossMotorFunction.setVar34(Evaluacion.values()[grossMotorFunctionDTO.getVar34()]);
		grossMotorFunction.setVar35(Evaluacion.values()[grossMotorFunctionDTO.getVar35()]);
		grossMotorFunction.setVar36(Evaluacion.values()[grossMotorFunctionDTO.getVar36()]);
		grossMotorFunction.setVar37(Evaluacion.values()[grossMotorFunctionDTO.getVar37()]);
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
		grossMotorFunctionDTO.setVar1(grossMotorFunction.getVar1().ordinal());
		grossMotorFunctionDTO.setVar2(grossMotorFunction.getVar2().ordinal());
		grossMotorFunctionDTO.setVar3(grossMotorFunction.getVar3().ordinal());
		grossMotorFunctionDTO.setVar4(grossMotorFunction.getVar4().ordinal());
		grossMotorFunctionDTO.setVar4(grossMotorFunction.getVar4().ordinal());
		grossMotorFunctionDTO.setVar5(grossMotorFunction.getVar5().ordinal());
		grossMotorFunctionDTO.setVar6(grossMotorFunction.getVar6().ordinal());
		grossMotorFunctionDTO.setVar7(grossMotorFunction.getVar7().ordinal());
		grossMotorFunctionDTO.setVar8(grossMotorFunction.getVar8().ordinal());
		grossMotorFunctionDTO.setVar9(grossMotorFunction.getVar9().ordinal());
		grossMotorFunctionDTO.setVar10(grossMotorFunction.getVar10().ordinal());
		grossMotorFunctionDTO.setVar11(grossMotorFunction.getVar11().ordinal());
		grossMotorFunctionDTO.setVar12(grossMotorFunction.getVar12().ordinal());
		grossMotorFunctionDTO.setVar13(grossMotorFunction.getVar13().ordinal());
		grossMotorFunctionDTO.setVar14(grossMotorFunction.getVar14().ordinal());
		grossMotorFunctionDTO.setVar14(grossMotorFunction.getVar14().ordinal());
		grossMotorFunctionDTO.setVar15(grossMotorFunction.getVar15().ordinal());
		grossMotorFunctionDTO.setVar16(grossMotorFunction.getVar16().ordinal());
		grossMotorFunctionDTO.setVar17(grossMotorFunction.getVar17().ordinal());
		grossMotorFunctionDTO.setVar18(grossMotorFunction.getVar18().ordinal());
		grossMotorFunctionDTO.setVar19(grossMotorFunction.getVar19().ordinal());
		grossMotorFunctionDTO.setVar20(grossMotorFunction.getVar20().ordinal());
		grossMotorFunctionDTO.setVar21(grossMotorFunction.getVar21().ordinal());
		grossMotorFunctionDTO.setVar22(grossMotorFunction.getVar22().ordinal());
		grossMotorFunctionDTO.setVar23(grossMotorFunction.getVar23().ordinal());
		grossMotorFunctionDTO.setVar24(grossMotorFunction.getVar24().ordinal());
		grossMotorFunctionDTO.setVar24(grossMotorFunction.getVar24().ordinal());
		grossMotorFunctionDTO.setVar25(grossMotorFunction.getVar25().ordinal());
		grossMotorFunctionDTO.setVar26(grossMotorFunction.getVar26().ordinal());
		grossMotorFunctionDTO.setVar27(grossMotorFunction.getVar27().ordinal());
		grossMotorFunctionDTO.setVar28(grossMotorFunction.getVar28().ordinal());
		grossMotorFunctionDTO.setVar29(grossMotorFunction.getVar29().ordinal());
		grossMotorFunctionDTO.setVar30(grossMotorFunction.getVar30().ordinal());
		grossMotorFunctionDTO.setVar31(grossMotorFunction.getVar31().ordinal());
		grossMotorFunctionDTO.setVar32(grossMotorFunction.getVar32().ordinal());
		grossMotorFunctionDTO.setVar33(grossMotorFunction.getVar33().ordinal());
		grossMotorFunctionDTO.setVar34(grossMotorFunction.getVar34().ordinal());
		grossMotorFunctionDTO.setVar34(grossMotorFunction.getVar34().ordinal());
		grossMotorFunctionDTO.setVar35(grossMotorFunction.getVar35().ordinal());
		grossMotorFunctionDTO.setVar36(grossMotorFunction.getVar36().ordinal());
		grossMotorFunctionDTO.setVar37(grossMotorFunction.getVar37().ordinal());
		return grossMotorFunctionDTO;
	}

}
