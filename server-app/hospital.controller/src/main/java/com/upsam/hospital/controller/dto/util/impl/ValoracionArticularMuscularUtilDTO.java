package com.upsam.hospital.controller.dto.util.impl;

import org.springframework.stereotype.Component;
import com.upsam.hospital.controller.dto.ValoracionArticularMuscularDTO;
import com.upsam.hospital.controller.dto.util.IValoracionArticularMuscularUtilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Exploracion;
import com.upsam.hospital.model.beans.ValoracionArticularMuscular;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionArticularMuscularUtilDTO.
 */
@Component
public class ValoracionArticularMuscularUtilDTO implements IValoracionArticularMuscularUtilDTO {

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.controller.dto.util.IValoracionArticularMuscularUtilDTO
	 * #
	 * toBusiness(com.upsam.hospital.controller.dto.ValoracionArticularMuscularDTO
	 * )
	 */
	@Override
	public ValoracionArticularMuscular toBusiness(ValoracionArticularMuscularDTO valoracionArticularMuscularDTO) throws TransferObjectException {
		ValoracionArticularMuscular valoracionArticularMuscular = new ValoracionArticularMuscular();
		valoracionArticularMuscular.setId(valoracionArticularMuscularDTO.getId());
		valoracionArticularMuscular.setExploracion(new Exploracion(valoracionArticularMuscularDTO.getIdExploracion()));
		valoracionArticularMuscular.setVar_1_1(valoracionArticularMuscularDTO.getVar_1_1());
		valoracionArticularMuscular.setVar_1_2(valoracionArticularMuscularDTO.getVar_1_2());
		valoracionArticularMuscular.setVar_1_3(valoracionArticularMuscularDTO.getVar_1_3());
		valoracionArticularMuscular.setVar_1_4(valoracionArticularMuscularDTO.getVar_1_4());
		valoracionArticularMuscular.setVar_1_5(valoracionArticularMuscularDTO.getVar_1_5());
		valoracionArticularMuscular.setVar_1_6(valoracionArticularMuscularDTO.getVar_1_6());
		valoracionArticularMuscular.setVar_2_1(valoracionArticularMuscularDTO.getVar_2_1());
		valoracionArticularMuscular.setVar_2_2(valoracionArticularMuscularDTO.getVar_2_2());
		valoracionArticularMuscular.setVar_2_3(valoracionArticularMuscularDTO.getVar_2_3());
		valoracionArticularMuscular.setVar_2_4(valoracionArticularMuscularDTO.getVar_2_4());
		valoracionArticularMuscular.setVar_2_5(valoracionArticularMuscularDTO.getVar_2_5());
		valoracionArticularMuscular.setVar_2_6(valoracionArticularMuscularDTO.getVar_2_6());
		valoracionArticularMuscular.setVar_3_1(valoracionArticularMuscularDTO.getVar_3_1());
		valoracionArticularMuscular.setVar_3_2(valoracionArticularMuscularDTO.getVar_3_2());
		valoracionArticularMuscular.setVar_3_3(valoracionArticularMuscularDTO.getVar_3_3());
		valoracionArticularMuscular.setVar_3_4(valoracionArticularMuscularDTO.getVar_3_4());
		valoracionArticularMuscular.setVar_3_5(valoracionArticularMuscularDTO.getVar_3_5());
		valoracionArticularMuscular.setVar_3_6(valoracionArticularMuscularDTO.getVar_3_6());
		valoracionArticularMuscular.setVar_4_1(valoracionArticularMuscularDTO.getVar_4_1());
		valoracionArticularMuscular.setVar_4_2(valoracionArticularMuscularDTO.getVar_4_2());
		valoracionArticularMuscular.setVar_4_3(valoracionArticularMuscularDTO.getVar_4_3());
		valoracionArticularMuscular.setVar_4_4(valoracionArticularMuscularDTO.getVar_4_4());
		valoracionArticularMuscular.setVar_4_5(valoracionArticularMuscularDTO.getVar_4_5());
		valoracionArticularMuscular.setVar_4_6(valoracionArticularMuscularDTO.getVar_4_6());
		valoracionArticularMuscular.setVar_5_1(valoracionArticularMuscularDTO.getVar_5_1());
		valoracionArticularMuscular.setVar_5_2(valoracionArticularMuscularDTO.getVar_5_2());
		valoracionArticularMuscular.setVar_5_3(valoracionArticularMuscularDTO.getVar_5_3());
		valoracionArticularMuscular.setVar_5_4(valoracionArticularMuscularDTO.getVar_5_4());
		valoracionArticularMuscular.setVar_5_5(valoracionArticularMuscularDTO.getVar_5_5());
		valoracionArticularMuscular.setVar_5_6(valoracionArticularMuscularDTO.getVar_5_6());
		valoracionArticularMuscular.setVar_6_1(valoracionArticularMuscularDTO.getVar_6_1());
		valoracionArticularMuscular.setVar_6_2(valoracionArticularMuscularDTO.getVar_6_2());
		valoracionArticularMuscular.setVar_6_3(valoracionArticularMuscularDTO.getVar_6_3());
		valoracionArticularMuscular.setVar_6_4(valoracionArticularMuscularDTO.getVar_6_4());
		valoracionArticularMuscular.setVar_6_5(valoracionArticularMuscularDTO.getVar_6_5());
		valoracionArticularMuscular.setVar_6_6(valoracionArticularMuscularDTO.getVar_6_6());
		valoracionArticularMuscular.setVar_7_1(valoracionArticularMuscularDTO.getVar_7_1());
		valoracionArticularMuscular.setVar_7_2(valoracionArticularMuscularDTO.getVar_7_2());
		valoracionArticularMuscular.setVar_7_3(valoracionArticularMuscularDTO.getVar_7_3());
		valoracionArticularMuscular.setVar_7_4(valoracionArticularMuscularDTO.getVar_7_4());
		valoracionArticularMuscular.setVar_7_5(valoracionArticularMuscularDTO.getVar_7_5());
		valoracionArticularMuscular.setVar_7_6(valoracionArticularMuscularDTO.getVar_7_6());
		valoracionArticularMuscular.setVar_8_1(valoracionArticularMuscularDTO.getVar_8_1());
		valoracionArticularMuscular.setVar_8_2(valoracionArticularMuscularDTO.getVar_8_2());
		valoracionArticularMuscular.setVar_8_3(valoracionArticularMuscularDTO.getVar_8_3());
		valoracionArticularMuscular.setVar_8_4(valoracionArticularMuscularDTO.getVar_8_4());
		valoracionArticularMuscular.setVar_8_5(valoracionArticularMuscularDTO.getVar_8_5());
		valoracionArticularMuscular.setVar_8_6(valoracionArticularMuscularDTO.getVar_8_6());
		valoracionArticularMuscular.setVar_9_1(valoracionArticularMuscularDTO.getVar_9_1());
		valoracionArticularMuscular.setVar_9_2(valoracionArticularMuscularDTO.getVar_9_2());
		valoracionArticularMuscular.setVar_9_3(valoracionArticularMuscularDTO.getVar_9_3());
		valoracionArticularMuscular.setVar_9_4(valoracionArticularMuscularDTO.getVar_9_4());
		valoracionArticularMuscular.setVar_9_5(valoracionArticularMuscularDTO.getVar_9_5());
		valoracionArticularMuscular.setVar_9_6(valoracionArticularMuscularDTO.getVar_9_6());
		valoracionArticularMuscular.setVar_10_1(valoracionArticularMuscularDTO.getVar_10_1());
		valoracionArticularMuscular.setVar_10_2(valoracionArticularMuscularDTO.getVar_10_2());
		valoracionArticularMuscular.setVar_10_3(valoracionArticularMuscularDTO.getVar_10_3());
		valoracionArticularMuscular.setVar_10_4(valoracionArticularMuscularDTO.getVar_10_4());
		valoracionArticularMuscular.setVar_10_5(valoracionArticularMuscularDTO.getVar_10_5());
		valoracionArticularMuscular.setVar_10_6(valoracionArticularMuscularDTO.getVar_10_6());
		valoracionArticularMuscular.setVar_11_1(valoracionArticularMuscularDTO.getVar_11_1());
		valoracionArticularMuscular.setVar_11_2(valoracionArticularMuscularDTO.getVar_11_2());
		valoracionArticularMuscular.setVar_11_3(valoracionArticularMuscularDTO.getVar_11_3());
		valoracionArticularMuscular.setVar_11_4(valoracionArticularMuscularDTO.getVar_11_4());
		valoracionArticularMuscular.setVar_11_5(valoracionArticularMuscularDTO.getVar_11_5());
		valoracionArticularMuscular.setVar_11_6(valoracionArticularMuscularDTO.getVar_11_6());
		valoracionArticularMuscular.setVar_12_1(valoracionArticularMuscularDTO.getVar_12_1());
		valoracionArticularMuscular.setVar_12_2(valoracionArticularMuscularDTO.getVar_12_2());
		valoracionArticularMuscular.setVar_12_3(valoracionArticularMuscularDTO.getVar_12_3());
		valoracionArticularMuscular.setVar_12_4(valoracionArticularMuscularDTO.getVar_12_4());
		valoracionArticularMuscular.setVar_12_5(valoracionArticularMuscularDTO.getVar_12_5());
		valoracionArticularMuscular.setVar_12_6(valoracionArticularMuscularDTO.getVar_12_6());
		valoracionArticularMuscular.setVar_13_1(valoracionArticularMuscularDTO.getVar_13_1());
		valoracionArticularMuscular.setVar_13_2(valoracionArticularMuscularDTO.getVar_13_2());
		valoracionArticularMuscular.setVar_13_3(valoracionArticularMuscularDTO.getVar_13_3());
		valoracionArticularMuscular.setVar_13_4(valoracionArticularMuscularDTO.getVar_13_4());
		valoracionArticularMuscular.setVar_13_5(valoracionArticularMuscularDTO.getVar_13_5());
		valoracionArticularMuscular.setVar_13_6(valoracionArticularMuscularDTO.getVar_13_6());
		return valoracionArticularMuscular;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.controller.dto.util.IValoracionArticularMuscularUtilDTO
	 * #toRest(com.upsam.hospital.model.beans.ValoracionArticularMuscular)
	 */
	@Override
	public ValoracionArticularMuscularDTO toRest(ValoracionArticularMuscular valoracionArticularMuscular) throws TransferObjectException {
		ValoracionArticularMuscularDTO valoracionArticularMuscularDTO = new ValoracionArticularMuscularDTO();
		valoracionArticularMuscularDTO.setId(valoracionArticularMuscular.getId());
		valoracionArticularMuscularDTO.setVar_1_1(valoracionArticularMuscular.getVar_1_1());
		valoracionArticularMuscularDTO.setVar_1_2(valoracionArticularMuscular.getVar_1_2());
		valoracionArticularMuscularDTO.setVar_1_3(valoracionArticularMuscular.getVar_1_3());
		valoracionArticularMuscularDTO.setVar_1_4(valoracionArticularMuscular.getVar_1_4());
		valoracionArticularMuscularDTO.setVar_1_5(valoracionArticularMuscular.getVar_1_5());
		valoracionArticularMuscularDTO.setVar_1_6(valoracionArticularMuscular.getVar_1_6());
		valoracionArticularMuscularDTO.setVar_2_1(valoracionArticularMuscular.getVar_2_1());
		valoracionArticularMuscularDTO.setVar_2_2(valoracionArticularMuscular.getVar_2_2());
		valoracionArticularMuscularDTO.setVar_2_3(valoracionArticularMuscular.getVar_2_3());
		valoracionArticularMuscularDTO.setVar_2_4(valoracionArticularMuscular.getVar_2_4());
		valoracionArticularMuscularDTO.setVar_2_5(valoracionArticularMuscular.getVar_2_5());
		valoracionArticularMuscularDTO.setVar_2_6(valoracionArticularMuscular.getVar_2_6());
		valoracionArticularMuscularDTO.setVar_3_1(valoracionArticularMuscular.getVar_3_1());
		valoracionArticularMuscularDTO.setVar_3_2(valoracionArticularMuscular.getVar_3_2());
		valoracionArticularMuscularDTO.setVar_3_3(valoracionArticularMuscular.getVar_3_3());
		valoracionArticularMuscularDTO.setVar_3_4(valoracionArticularMuscular.getVar_3_4());
		valoracionArticularMuscularDTO.setVar_3_5(valoracionArticularMuscular.getVar_3_5());
		valoracionArticularMuscularDTO.setVar_3_6(valoracionArticularMuscular.getVar_3_6());
		valoracionArticularMuscularDTO.setVar_4_1(valoracionArticularMuscular.getVar_4_1());
		valoracionArticularMuscularDTO.setVar_4_2(valoracionArticularMuscular.getVar_4_2());
		valoracionArticularMuscularDTO.setVar_4_3(valoracionArticularMuscular.getVar_4_3());
		valoracionArticularMuscularDTO.setVar_4_4(valoracionArticularMuscular.getVar_4_4());
		valoracionArticularMuscularDTO.setVar_4_5(valoracionArticularMuscular.getVar_4_5());
		valoracionArticularMuscularDTO.setVar_4_6(valoracionArticularMuscular.getVar_4_6());
		valoracionArticularMuscularDTO.setVar_5_1(valoracionArticularMuscular.getVar_5_1());
		valoracionArticularMuscularDTO.setVar_5_2(valoracionArticularMuscular.getVar_5_2());
		valoracionArticularMuscularDTO.setVar_5_3(valoracionArticularMuscular.getVar_5_3());
		valoracionArticularMuscularDTO.setVar_5_4(valoracionArticularMuscular.getVar_5_4());
		valoracionArticularMuscularDTO.setVar_5_5(valoracionArticularMuscular.getVar_5_5());
		valoracionArticularMuscularDTO.setVar_5_6(valoracionArticularMuscular.getVar_5_6());
		valoracionArticularMuscularDTO.setVar_6_1(valoracionArticularMuscular.getVar_6_1());
		valoracionArticularMuscularDTO.setVar_6_2(valoracionArticularMuscular.getVar_6_2());
		valoracionArticularMuscularDTO.setVar_6_3(valoracionArticularMuscular.getVar_6_3());
		valoracionArticularMuscularDTO.setVar_6_4(valoracionArticularMuscular.getVar_6_4());
		valoracionArticularMuscularDTO.setVar_6_5(valoracionArticularMuscular.getVar_6_5());
		valoracionArticularMuscularDTO.setVar_6_6(valoracionArticularMuscular.getVar_6_6());
		valoracionArticularMuscularDTO.setVar_7_1(valoracionArticularMuscular.getVar_7_1());
		valoracionArticularMuscularDTO.setVar_7_2(valoracionArticularMuscular.getVar_7_2());
		valoracionArticularMuscularDTO.setVar_7_3(valoracionArticularMuscular.getVar_7_3());
		valoracionArticularMuscularDTO.setVar_7_4(valoracionArticularMuscular.getVar_7_4());
		valoracionArticularMuscularDTO.setVar_7_5(valoracionArticularMuscular.getVar_7_5());
		valoracionArticularMuscularDTO.setVar_7_6(valoracionArticularMuscular.getVar_7_6());
		valoracionArticularMuscularDTO.setVar_8_1(valoracionArticularMuscular.getVar_8_1());
		valoracionArticularMuscularDTO.setVar_8_2(valoracionArticularMuscular.getVar_8_2());
		valoracionArticularMuscularDTO.setVar_8_3(valoracionArticularMuscular.getVar_8_3());
		valoracionArticularMuscularDTO.setVar_8_4(valoracionArticularMuscular.getVar_8_4());
		valoracionArticularMuscularDTO.setVar_8_5(valoracionArticularMuscular.getVar_8_5());
		valoracionArticularMuscularDTO.setVar_8_6(valoracionArticularMuscular.getVar_8_6());
		valoracionArticularMuscularDTO.setVar_9_1(valoracionArticularMuscular.getVar_9_1());
		valoracionArticularMuscularDTO.setVar_9_2(valoracionArticularMuscular.getVar_9_2());
		valoracionArticularMuscularDTO.setVar_9_3(valoracionArticularMuscular.getVar_9_3());
		valoracionArticularMuscularDTO.setVar_9_4(valoracionArticularMuscular.getVar_9_4());
		valoracionArticularMuscularDTO.setVar_9_5(valoracionArticularMuscular.getVar_9_5());
		valoracionArticularMuscularDTO.setVar_9_6(valoracionArticularMuscular.getVar_9_6());
		valoracionArticularMuscularDTO.setVar_10_1(valoracionArticularMuscular.getVar_10_1());
		valoracionArticularMuscularDTO.setVar_10_2(valoracionArticularMuscular.getVar_10_2());
		valoracionArticularMuscularDTO.setVar_10_3(valoracionArticularMuscular.getVar_10_3());
		valoracionArticularMuscularDTO.setVar_10_4(valoracionArticularMuscular.getVar_10_4());
		valoracionArticularMuscularDTO.setVar_10_5(valoracionArticularMuscular.getVar_10_5());
		valoracionArticularMuscularDTO.setVar_10_6(valoracionArticularMuscular.getVar_10_6());
		valoracionArticularMuscularDTO.setVar_11_1(valoracionArticularMuscular.getVar_11_1());
		valoracionArticularMuscularDTO.setVar_11_2(valoracionArticularMuscular.getVar_11_2());
		valoracionArticularMuscularDTO.setVar_11_3(valoracionArticularMuscular.getVar_11_3());
		valoracionArticularMuscularDTO.setVar_11_4(valoracionArticularMuscular.getVar_11_4());
		valoracionArticularMuscularDTO.setVar_11_5(valoracionArticularMuscular.getVar_11_5());
		valoracionArticularMuscularDTO.setVar_11_6(valoracionArticularMuscular.getVar_11_6());
		valoracionArticularMuscularDTO.setVar_12_1(valoracionArticularMuscular.getVar_12_1());
		valoracionArticularMuscularDTO.setVar_12_2(valoracionArticularMuscular.getVar_12_2());
		valoracionArticularMuscularDTO.setVar_12_3(valoracionArticularMuscular.getVar_12_3());
		valoracionArticularMuscularDTO.setVar_12_4(valoracionArticularMuscular.getVar_12_4());
		valoracionArticularMuscularDTO.setVar_12_5(valoracionArticularMuscular.getVar_12_5());
		valoracionArticularMuscularDTO.setVar_12_6(valoracionArticularMuscular.getVar_12_6());
		valoracionArticularMuscularDTO.setVar_13_1(valoracionArticularMuscular.getVar_13_1());
		valoracionArticularMuscularDTO.setVar_13_2(valoracionArticularMuscular.getVar_13_2());
		valoracionArticularMuscularDTO.setVar_13_3(valoracionArticularMuscular.getVar_13_3());
		valoracionArticularMuscularDTO.setVar_13_4(valoracionArticularMuscular.getVar_13_4());
		valoracionArticularMuscularDTO.setVar_13_5(valoracionArticularMuscular.getVar_13_5());
		valoracionArticularMuscularDTO.setVar_13_6(valoracionArticularMuscular.getVar_13_6());
		return valoracionArticularMuscularDTO;
	}

}
