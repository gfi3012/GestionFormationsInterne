package gfi.psf.business;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import gfi.psf.business.SessionFormationBusiness;
import gfi.psf.dao.SessionFormationRepository;
import gfi.psf.dao.UtilisateurRepository;
import gfi.psf.entities.SessionFormation;
import gfi.psf.entities.Utilisateur;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SessionFormationBusinessTest {

	@Autowired
	private SessionFormationBusiness sessionFormationBusiness;
	@Autowired
	private SessionFormationRepository sessionFormationRepository;
	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Test
	public void testCreerSessionFormation() {
		List<SessionFormation> listSessionFormation1 = sessionFormationRepository.findAll();
		sessionFormationBusiness.creerSessionFormation(new SessionFormation(new Date(), new Date(),
				20, "lieu1"));
		sessionFormationBusiness.creerSessionFormation(new SessionFormation(new Date(), new Date(),
				10, "lieu2"));
		List<SessionFormation> listSessionFormation2 = sessionFormationRepository.findAll();
		assertTrue(listSessionFormation1.size() + 2 == listSessionFormation2.size());
	}

	@Test
	public void testAffecterFormateurSessionFormation() {
		List<Utilisateur> listUtilisateur = utilisateurRepository.findAll();
		Utilisateur utilisateur = listUtilisateur.get(1);
		List<SessionFormation> listSessionFormation = sessionFormationRepository.findAll();
		SessionFormation sessionFormation = listSessionFormation.get(0);
		sessionFormationBusiness.affecterFormateurSessionFormation(sessionFormation.getIdSession(),
				utilisateur.getIdUtilisateur());
		sessionFormation = sessionFormationRepository.findOne(sessionFormation.getIdSession());
		assertEquals(sessionFormation.getFormateur().getIdUtilisateur(),
				utilisateur.getIdUtilisateur());
	}

}
