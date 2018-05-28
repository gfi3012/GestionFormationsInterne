package gfi.psf.business;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import gfi.psf.business.InscriptionBusiness;
import gfi.psf.dao.InscriptionRepository;
import gfi.psf.model.EtatInscription;
import gfi.psf.model.Inscription;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InscriptionBusinessTest {

	@Autowired
	private InscriptionBusiness inscriptionBusiness;
	@Autowired
	private InscriptionRepository inscriptionRepository;

	@Test
	public void testInscrireCollaborateursSessionFormation() {
		List<Integer> listIdUtilisateur = new ArrayList<Integer>(7);
		for (int i = 1; i < 8; i++)
			listIdUtilisateur.add(i);
		int size1 = inscriptionRepository.findAll().size();
		inscriptionBusiness.inscrireCollaborateursSessionFormation(listIdUtilisateur, 1);
		int size2 = inscriptionRepository.findAll().size();
		assertEquals(size1 + 6, size2);
		Inscription inscription = inscriptionRepository.findOne(1);
		assertNotNull(inscription);
		assertEquals(EtatInscription.INVITED, inscription.getEtat());
	}

	@Ignore
	public void testChercherInscriptionsParIdSessionFormation() {
		List<Inscription> inscriptions = inscriptionBusiness
				.chercherInscriptionsParIdSessionFormation(1);
		assertNotNull(inscriptions);
		assertTrue(inscriptions.size() <= 5);
	}

	@Ignore
	public void testConfirmerInscriptionSessionFormation() {
		inscriptionBusiness.confirmerInscriptionSessionFormation(4);
		Inscription inscription = inscriptionRepository.findOne(4);
		assertEquals(EtatInscription.CONFIRMED, inscription.getEtat());
	}

	@Ignore
	public void testRefuserInscriptionSessionFormation() {
		inscriptionBusiness.refuserInscriptionSessionFormation(6, "motifs");
		Inscription inscription = inscriptionRepository.findOne(6);
		assertEquals(EtatInscription.REFUSED, inscription.getEtat());
		assertEquals("motifs", inscription.getMotifDuRefus());
	}

	@Ignore
	public void testSupprimerInscriptionCollaborateur() {
		int size1 = inscriptionRepository.findAll().size();
		inscriptionBusiness.supprimerInscriptionCollaborateur(2);
		int size2 = inscriptionRepository.findAll().size();
		assertEquals(size1 - 1, size2);
	}

	@Ignore
	public void testSupprimerCollaborateursNonFormes() {
		int size1 = inscriptionRepository.findAll().size();
		inscriptionBusiness.supprimerCollaborateursNonFormes(1);
		int size2 = inscriptionRepository.findAll().size();
		assertEquals(size1 - 1, size2);
	}
}
