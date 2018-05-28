package gfi.psf.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import gfi.psf.model.Formation;
import gfi.psf.model.SessionFormation;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SessionFormationRepositoryTest {

	@Autowired
	private SessionFormationRepository sessionFormationRepository;

	@Test
	public void testFindTop5ByFormationOrderByDateDebut() {
		List<SessionFormation> sessionsFormation = sessionFormationRepository
				.findTop5ByFormationOrderByDateDebut(new Formation(1));
		assertNotNull(sessionsFormation);
		assertTrue(sessionsFormation.size() <= 5);
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < 5; i++) {
			assertEquals(new Integer(1), sessionsFormation.get(i).getFormation().getId());
			cal.add(Calendar.MONTH, 1);
			assertEquals(sdf.format(cal.getTime()), sessionsFormation.get(i).getDateDebut()
					.toString());
		}
	}

	@Ignore
	public void testFindTop5ByFormationAndDateDebutGreaterThanEqualOrderByDateDebut() {
		Calendar cal = Calendar.getInstance();
		// cal.set(Calendar.YEAR, 2018);
		// cal.set(Calendar.MONTH, 8);
		// cal.set(Calendar.DAY_OF_MONTH, 29);
		List<SessionFormation> sessionsFormation = sessionFormationRepository
				.findTop5ByFormationAndDateDebutGreaterThanEqualOrderByDateDebut(new Formation(1),
						cal.getTime());
		assertNotNull(sessionsFormation);
		assertTrue(sessionsFormation.size() <= 5);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < 5; i++) {
			assertEquals(new Integer(1), sessionsFormation.get(i).getFormation().getId());
			cal.add(Calendar.MONTH, 1);
			assertEquals(sdf.format(cal.getTime()), sessionsFormation.get(i).getDateDebut()
					.toString());
		}
	}
}
