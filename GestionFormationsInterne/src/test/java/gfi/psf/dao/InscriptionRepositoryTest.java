package gfi.psf.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import gfi.psf.entities.Inscription;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InscriptionRepositoryTest {

	@Autowired
	private InscriptionRepository inscriptionRepository;

	@Test
	public void testFindInscriptionByIdSessionAndIdUtilisateur() {
		Inscription inscription = inscriptionRepository.findInscriptionByIdSessionAndIdCollaborateur(
				2, 2);
		assertNotNull(inscription);
		assertEquals(new Integer(1), inscription.getIdInscription());
	}

	@Ignore
	public void testDeleteInscriptionsCollaborateurs() {
		List<Inscription> listInscriptions1 = inscriptionRepository.findAll();
		inscriptionRepository.deleteInscriptionsCollaborateurs(2);
		List<Inscription> listInscriptions2 = inscriptionRepository.findAll();
		assertEquals(listInscriptions1.size() - 2, listInscriptions2.size());
	}
}
