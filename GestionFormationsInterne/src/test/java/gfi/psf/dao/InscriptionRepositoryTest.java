package gfi.psf.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import gfi.psf.model.EtatInscription;
import gfi.psf.model.Inscription;
import gfi.psf.model.SessionFormation;

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
	public void testFindTop5BySessionFormationOrderByEtat() {
		List<Inscription> inscriptions = inscriptionRepository
				.findTop5BySessionFormationOrderByEtat(new SessionFormation(1));
		assertNotNull(inscriptions);
		assertTrue(inscriptions.size() <= 5);
		for (Inscription inscription : inscriptions) {
			assertEquals(new Integer(1), inscription.getSessionFormation().getId());
		}
		assertEquals(EtatInscription.CONFIRMED, inscriptions.get(0).getEtat());
		assertEquals(EtatInscription.CONFIRMED, inscriptions.get(1).getEtat());
		assertEquals(EtatInscription.INVITED, inscriptions.get(2).getEtat());
		assertEquals(EtatInscription.INVITED, inscriptions.get(3).getEtat());
		assertEquals(EtatInscription.REFUSED, inscriptions.get(4).getEtat());
	}

	@Ignore
	public void testDeleteBySessionFormationAndEtat() {
		int size1 = inscriptionRepository.findAll().size();
		inscriptionRepository.deleteBySessionFormationAndEtat(new SessionFormation(2),
				EtatInscription.REFUSED);
		int size2 = inscriptionRepository.findAll().size();
		assertEquals(size1 - 2, size2);
	}
}
