package com.upsam.hospital.model.tests;

import static org.junit.Assert.assertNotNull;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.xml.bind.JAXBException;
import org.junit.Test;
import com.upsam.hospital.model.beans.Angle;
import com.upsam.hospital.model.beans.FicheroEMT;
import com.upsam.hospital.model.beans.Paciente;
import com.upsam.hospital.model.beans.Point;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.jaxb.EmxDataFile;
import com.upsam.hospital.model.service.IFicheroEMTService;
import com.upsam.hospital.model.service.IFicheroMDXService;
import com.upsam.hospital.model.service.IPacienteService;

public class ServicePacienteTest extends AbstractTest {

	@Inject
	private IPacienteService pacienteService;

	@Inject
	private IFicheroMDXService ficheroMDXService;

	@Inject
	private IFicheroEMTService ficheroEMTService;

	@Test
	public void pacienteFicheroEMTTest() throws IOException, DataBaseException {
		File file = new File("C:\\Users\\Huguet\\Desktop\\ficheros\\13-9-05-01-2011.emt");
		Paciente paciente = pacienteService.findOne(1);
		writePaciente(paciente);
		FicheroEMT ficheroEMT = ficheroEMTService.fileReaderEMT(file, paciente);
		paciente.addFicheroEMT(ficheroEMT);
		pacienteService.update(paciente);
		System.out.println("YEAH");
	}

	@Test
	public void pacienteFicheroMDXTest() throws IOException, JAXBException {
		File file = new File("C:\\Users\\Huguet\\Desktop\\ficheros\\file.mdx");
		EmxDataFile result = ficheroMDXService.fileReaderMDX(file);
		assertNotNull(result);
	}

	@Test
	public void writeFicheroEMT() throws DataBaseException {
		FicheroEMT ficheroEMT = ficheroEMTService.findOne(1);
		System.out.println(ficheroEMT.getCiclos());
		System.out.println(ficheroEMT.getFecha());
		System.out.println(ficheroEMT.getTipoMedida().getNameId());
		System.out.println(ficheroEMT.getUnidadMedida().getNameId());
		System.out.println("\n");
		for (Angle angle : ficheroEMT.getTablaDatos().getAngles()) {
			System.out.println(angle.getName());
			for (Point point : angle.getPoints()) {
				System.out.print(point.getCoord() + " ");
			}
			System.out.println("\n");
		}
	}

	private void writePaciente(Paciente paciente) {
		System.out.println(paciente.getNombre());
		for (FicheroEMT ficheroEMT : paciente.getFicheroEMT()) {
			System.out.println(ficheroEMT.getCiclos());
			System.out.println(ficheroEMT.getFecha());
			System.out.println(ficheroEMT.getTipoMedida().getNameId());
			System.out.println(ficheroEMT.getUnidadMedida().getNameId());
			for (Angle angle : ficheroEMT.getTablaDatos().getAngles()) {
				System.out.println(angle.getName());
				for (Point point : angle.getPoints()) {
					System.out.print(point.getCoord() + " ");
				}
				System.out.println("\n");
			}
		}
		System.out.println(paciente.getNumeroIdentificacion());

	}

	@Test
	public void testPacienteMovil() throws DataBaseException {
		List<Paciente> pacientes = pacienteService.findByIdNameSurname("123 Carlos Huguet");
		System.out.println(pacientes.get(0).getNombre());
	}
}
