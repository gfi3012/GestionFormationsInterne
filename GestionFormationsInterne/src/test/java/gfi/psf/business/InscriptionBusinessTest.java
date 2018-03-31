package gfi.psf.business;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import gfi.psf.business.InscriptionBusiness;
import gfi.psf.dao.InscriptionRepository;
import gfi.psf.dao.SessionFormationRepository;
import gfi.psf.dao.UtilisateurRepository;
import gfi.psf.entities.Inscription;

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
	@Autowired
	private SessionFormationRepository sessionFormationRepository;
	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Test
	public void testInscrireCollaborateursSessionFormation() {
		List<Integer> listIdUtilisateur = new ArrayList<Integer>(2);
		listIdUtilisateur.add(new Integer(1));
		listIdUtilisateur.add(new Integer(2));
		List<Inscription> listInscription1 = inscriptionRepository.findAll();
		inscriptionBusiness.inscrireCollaborateursSessionFormation(new Integer(1),
				listIdUtilisateur);
		List<Inscription> listInscription2 = inscriptionRepository.findAll();
		assertEquals(listInscription1.size() + 2, listInscription2.size());
		Inscription inscription = inscriptionRepository.findInscriptionByIdSessionAndIdUtilisateur(
				new Integer(1), listIdUtilisateur.get(0));
		assertNotNull(inscription);
		assertEquals(inscription.getCodeInscription(), 1);
		assertNull(inscription.getMotifDuRefus());
		inscription = inscriptionRepository.findInscriptionByIdSessionAndIdUtilisateur(new Integer(
				1), listIdUtilisateur.get(1));
		assertNotNull(inscription);
		assertEquals(inscription.getCodeInscription(), 1);
		assertNull(inscription.getMotifDuRefus());
	}

	@Ignore
	public void testSupprimerCollaborateursNonFormes() {
		List<Inscription> listInscriptions1 = inscriptionRepository.findAll();
		inscriptionBusiness.supprimerCollaborateursNonFormes(2);
		List<Inscription> listInscriptions2 = inscriptionRepository.findAll();
		assertEquals(listInscriptions1.size() - 2, listInscriptions2.size());
	}
}
