package gfi.psf.business;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import gfi.psf.business.InscriptionBusiness;
import gfi.psf.dao.InscriptionRepository;
import gfi.psf.dao.SessionFormationRepository;
import gfi.psf.dao.UtilisateurRepository;
import gfi.psf.entities.EtatInscription;
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
		inscriptionBusiness.inscrireCollaborateursSessionFormation(listIdUtilisateur,
				new Integer(1));
		List<Inscription> listInscription2 = inscriptionRepository.findAll();
		assertEquals(listInscription1.size() + 2, listInscription2.size());
		Inscription inscription = inscriptionRepository.findOne(new Integer(1));
		assertNotNull(inscription);
		assertEquals(EtatInscription.INVITED, inscription.getEtat());
		inscription = inscriptionRepository.findOne(new Integer(2));
		assertNotNull(inscription);
		assertEquals(EtatInscription.INVITED, inscription.getEtat());
	}

	@Ignore
	public void testConfirmerInscriptionSessionFormation() {
		inscriptionBusiness.confirmerInscriptionSessionFormation(1);
		Inscription inscription = inscriptionRepository.findOne(new Integer(1));
		assertEquals(EtatInscription.CONFIRMED, inscription.getEtat());
	}

	@Ignore
	public void testRefuserInscriptionSessionFormation() {
		inscriptionBusiness.refuserInscriptionSessionFormation(2, "motifs");
		Inscription inscription = inscriptionRepository.findOne(new Integer(2));
		assertEquals(EtatInscription.REFUSED, inscription.getEtat());
		assertEquals("motifs", inscription.getMotifDuRefus());
	}

	@Ignore
	public void testSupprimerCollaborateursNonFormes() {
		List<Inscription> listInscriptions1 = inscriptionRepository.findAll();
		inscriptionBusiness.supprimerCollaborateursNonFormes(1);
		List<Inscription> listInscriptions2 = inscriptionRepository.findAll();
		assertEquals(listInscriptions1.size() - 1, listInscriptions2.size());
	}
}
