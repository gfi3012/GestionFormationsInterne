package gfi.psf.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;

import gfi.psf.business.SessionFormationBusiness;
import gfi.psf.dao.SessionFormationRepository;
import gfi.psf.model.Formation;
import gfi.psf.model.SessionFormation;

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

	@Test
	public void testCreerSessionFormation() {
		int size1 = sessionFormationRepository.findAll().size();
		Calendar cal = Calendar.getInstance();
		for (int i = 1; i < 7; i++) {
			cal.add(Calendar.MONTH, 1);
			sessionFormationBusiness.creerSessionFormation(new SessionFormation(cal.getTime(), cal
					.getTime(), i * 10, "lieu" + i, new Formation(1)));
		}
		int size2 = sessionFormationRepository.findAll().size();
		assertEquals(size1 + 6, size2);
	}

	@Ignore
	public void testAffecterFormateurSessionFormation() {
		sessionFormationBusiness.affecterFormateurSessionFormation(2, 1);
		SessionFormation sessionFormation = sessionFormationRepository.findOne(1);
		assertNotNull(sessionFormation.getFormateur());
		assertEquals(new Integer(2), sessionFormation.getFormateur().getId());
	}
}
