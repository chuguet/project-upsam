package com.upsam.hospital.model.tests;

import static org.junit.Assert.assertNotNull;
import java.io.File;
import java.io.IOException;
import javax.inject.Inject;
import javax.xml.bind.JAXBException;
import org.junit.Test;
import com.upsam.hospital.model.beans.Exploracion3D;
import com.upsam.hospital.model.beans.Field;
import com.upsam.hospital.model.beans.Paciente;
import com.upsam.hospital.model.beans.Row;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.jaxb.EmxDataFile;
import com.upsam.hospital.model.service.IFichero3DService;
import com.upsam.hospital.model.service.IPacienteService;

public class ServicePacienteTest extends AbstractTest {

	@Inject
	private IPacienteService pacienteService;

	@Inject
	private IFichero3DService fichero3DService;

	@Test
	public void pacienteExploracion3DTest() throws IOException, DataBaseException {
		File file = new File("C:\\Users\\Huguet\\Desktop\\ficheros\\13-9-05-01-2011.emt");
		Paciente paciente = pacienteService.findOne(1);
		writePaciente(paciente);
		Exploracion3D exploracion3D = fichero3DService.fileReaderExploracion3D(file, paciente);
		paciente.addExploracion3D(exploracion3D);
		pacienteService.update(paciente);
		System.out.println("YEAH");
	}

	@Test
	public void pacienteVideo3DTest() throws IOException, JAXBException {
		File file = new File("C:\\Users\\Huguet\\Desktop\\ficheros\\file.mdx");
		EmxDataFile result = fichero3DService.fileReaderVideo3D(file);
		assertNotNull(result);
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
		System.out.println(paciente.getNumeroIdentificacion());

	}
}
