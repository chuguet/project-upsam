package com.upsam.hospital.model.service.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IAntecedentesRelacionadosPCIRepository;
import com.upsam.hospital.model.unit.UnitTest;

public class AntecedentesRelacionadosPCIServiceTests extends UnitTest {

	@Mock
	private IAntecedentesRelacionadosPCIRepository antecedentesRelacionadosRepositoryPCI;
	@InjectMocks
	private AntecedentesRelacionadosPCIService antecedentesRelacionadosPCIService;

	@Test
	public void canSave() throws SQLException, DataBaseException {
		AntecedentesRelacionadosPCI antecedentes = antecedentesRelacionadosPCI();

		antecedentesRelacionadosPCIService.save(antecedentes);

		verify(antecedentesRelacionadosRepositoryPCI, times(1)).save(antecedentes);
	}

	@Test
	public void canUpdate() throws SQLException, DataBaseException {
		AntecedentesRelacionadosPCI antecedentes = antecedentesRelacionadosPCI();

		antecedentesRelacionadosPCIService.update(antecedentes);

		verify(antecedentesRelacionadosRepositoryPCI, times(1)).update(antecedentes);
	}

	@Test
	public void canDelete() throws SQLException, DataBaseException {
		AntecedentesRelacionadosPCI antecedentes = antecedentesRelacionadosPCI();

		antecedentesRelacionadosPCIService.delete(antecedentes);

		verify(antecedentesRelacionadosRepositoryPCI, times(1)).delete(antecedentes);
	}

	@Test
	public void canFindOne() throws SQLException, DataBaseException {
		AntecedentesRelacionadosPCI antecedentes = antecedentesRelacionadosPCI();
		when(antecedentesRelacionadosRepositoryPCI.findOne(1)).thenReturn(antecedentes);

		AntecedentesRelacionadosPCI result = antecedentesRelacionadosPCIService.findOne(1);

		assertThat(1, is(equalTo(result.getId())));
	}

	@Test
	public void canFindByExploracion() throws SQLException, DataBaseException {
		AntecedentesRelacionadosPCI antecedentes = antecedentesRelacionadosPCI();
		when(antecedentesRelacionadosRepositoryPCI.findByExploracion(1)).thenReturn(antecedentes);

		AntecedentesRelacionadosPCI result = antecedentesRelacionadosPCIService.findByExploracion(1);

		assertThat(antecedentes, is(equalTo(result)));
	}

	@Test
	public void canFindAll() throws SQLException, DataBaseException {
		List<AntecedentesRelacionadosPCI> antecedentes = new ArrayList<AntecedentesRelacionadosPCI>();
		antecedentes.add(antecedentesRelacionadosPCI());
		when(antecedentesRelacionadosRepositoryPCI.findAll()).thenReturn(antecedentes);

		List<AntecedentesRelacionadosPCI> result = antecedentesRelacionadosPCIService.findAll();

		assertThat(antecedentes, is(equalTo(result)));
	}

	private AntecedentesRelacionadosPCI antecedentesRelacionadosPCI() {
		AntecedentesRelacionadosPCI a = new AntecedentesRelacionadosPCI();
		a.setId(1);

		return a;
	}
}
