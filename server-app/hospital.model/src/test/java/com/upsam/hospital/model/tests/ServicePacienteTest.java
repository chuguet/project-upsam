package com.upsam.hospital.model.tests;

import java.io.File;
import java.io.IOException;
import javax.inject.Inject;
import org.junit.Test;
import com.upsam.hospital.model.beans.Exploracion3D;
import com.upsam.hospital.model.beans.Field;
import com.upsam.hospital.model.beans.Paciente;
import com.upsam.hospital.model.beans.Row;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.service.IPacienteService;

public class ServicePacienteTest extends AbstractTest {

	@Inject
	private IPacienteService pacienteService;

	@Test
	public void pacienteTest() throws IOException, DataBaseException {
		File file = new File("C:\\Users\\Huguet\\Desktop\\ficheros\\13-9-05-01-2011.emt");
		Paciente paciente = pacienteService.findOne(1);
		writePaciente(paciente);
		Exploracion3D exploracion3D = pacienteService.fileReader(file, paciente);
		paciente.addExploracion3D(exploracion3D);
		pacienteService.update(paciente);
		System.out.println("YEAH");
	}

	private void writePaciente(Paciente paciente) {
		System.out.println(paciente.getNombre());
		for (Exploracion3D exploracion3D : paciente.getExploracion3D()) {
			System.out.println(exploracion3D.getCiclos());
			System.out.println(exploracion3D.getFecha());
			System.out.println(exploracion3D.getTipoMedida().getNameId());
			System.out.println(exploracion3D.getUnidadMedida().getNameId());
			for (Row row : exploracion3D.getTablaDatos().getRows()) {
				for (Field field : row.getFields()) {
					System.out.print(field.getText() + " ");
				}
				System.out.println("\n");
			}
		}
		System.out.println(paciente.getExpediente());

	}
}
