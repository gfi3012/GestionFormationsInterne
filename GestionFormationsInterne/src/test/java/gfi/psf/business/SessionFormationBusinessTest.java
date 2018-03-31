package gfi.psf.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import gfi.psf.business.SessionFormationBusiness;
import gfi.psf.dao.SessionFormationRepository;
import gfi.psf.dao.UtilisateurRepository;
import gfi.psf.entities.SessionFormation;

import org.junit.Ignore;
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

	@Ignore
	public void testCreerSessionFormation() {
		List<SessionFormation> listSessionFormation1 = sessionFormationRepository.findAll();
		sessionFormationBusiness.creerSessionFormation(new SessionFormation(new Date(), new Date(),
				20, "lieu1"));
		sessionFormationBusiness.creerSessionFormation(new SessionFormation(new Date(), new Date(),
				10, "lieu2"));
		List<SessionFormation> listSessionFormation2 = sessionFormationRepository.findAll();
		assertEquals(listSessionFormation1.size() + 2, listSessionFormation2.size());
	}

//	@Ignore
	@Test
	public void testAffecterFormateurSessionFormation() {
		sessionFormationBusiness.affecterFormateurSessionFormation(new Integer(2), new Integer(1));
		SessionFormation sessionFormation = sessionFormationRepository.findOne(new Integer(2));
		assertNotNull(sessionFormation.getFormateur());
		assertEquals(sessionFormation.getFormateur().getIdUtilisateur(), new Integer(1));
	}

}
