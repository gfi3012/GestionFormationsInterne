package gfi.psf;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import gfi.psf.business.IInscriptionBusiness;
import gfi.psf.dao.InscriptionRepository;
import gfi.psf.dao.SessionFormationRepository;
import gfi.psf.dao.UtilisateurRepository;
import gfi.psf.entities.Inscription;
import gfi.psf.entities.SessionFormation;
import gfi.psf.entities.Utilisateur;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InscriptionBusinessTest {

	@Autowired
	private IInscriptionBusiness inscriptionBusiness;
	@Autowired
	private InscriptionRepository inscriptionRepository;
	@Autowired
	private SessionFormationRepository sessionFormationRepository;
	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Test
	public void testInscrireCollaborateursSessionFormation() {
		utilisateurRepository.save(new Utilisateur());
		utilisateurRepository.save(new Utilisateur());
		List<Utilisateur> listUtilisateur = utilisateurRepository.findAll();
		List<Integer> listIdUtilisateur = new ArrayList<Integer>(2);
		listIdUtilisateur.add(listUtilisateur.get(0).getIdUtilisateur());
		listIdUtilisateur.add(listUtilisateur.get(1).getIdUtilisateur());
		List<SessionFormation> listSessionFormation = sessionFormationRepository.findAll();
		inscriptionBusiness.inscrireCollaborateursSessionFormation(listSessionFormation.get(0)
				.getIdSession(), listIdUtilisateur);
		Inscription inscription = inscriptionRepository.getInscription(listSessionFormation.get(0)
				.getIdSession(), listIdUtilisateur.get(0));
		assertNotNull(inscription);
		assertTrue(inscription.getCodeInscription() == 1);
		inscription = inscriptionRepository.getInscription(listSessionFormation.get(0)
				.getIdSession(), listIdUtilisateur.get(1));
		assertNotNull(inscription);
		assertTrue(inscription.getCodeInscription() == 1);
	}

	// @Test
	// public void testSupprimerCollaborateursNonFormes(){
	//
	// }
}
