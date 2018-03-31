package gfi.psf.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gfi.psf.business.UtilisateurBusiness;
import gfi.psf.dao.InscriptionRepository;
import gfi.psf.entities.Inscription;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilisateurBusinessTest {
	@Autowired
	private UtilisateurBusiness utilisateurBusiness;
	@Autowired
	private InscriptionRepository inscriptionRepository;

	@Test
	public void testConfirmerInscriptionSessionFormation() {
		utilisateurBusiness.confirmerInscriptionSessionFormation(1, 1);
		Inscription inscription = inscriptionRepository.findInscriptionByIdSessionAndIdUtilisateur(
				1, 1);
		assertEquals(2, inscription.getCodeInscription());
	}

	@Ignore
	public void testRefuserInscriptionSessionFormation() {
		utilisateurBusiness.refuserInscriptionSessionFormation(1, 2, "congé");
		Inscription inscription = inscriptionRepository.findInscriptionByIdSessionAndIdUtilisateur(
				1, 2);
		assertEquals(3, inscription.getCodeInscription());
		assertNotNull(inscription.getMotifDuRefus());
	}
}
