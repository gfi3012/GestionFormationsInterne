package gfi.psf.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import gfi.psf.dao.FormationRepository;
import gfi.psf.entities.Formation;
import gfi.psf.business.FormationBusiness;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FormationBusinessTest {

	@Autowired
	private FormationBusiness formationBusiness;
	@Autowired
	private FormationRepository formationRepository;

	@Ignore
	public void testCreerFormation() {
		List<Formation> listFormations1 = formationRepository.findAllFormations();
		formationBusiness.creerFormation(new Formation("nomC", "domaineC", "objectifC", 5000));
		formationBusiness
				.creerFormation(new Formation("nomA", "domaineA", "objectifA", 6000));
		formationBusiness.creerFormation(new Formation("nomB", "domaineB", "objectifB", 35000));
		List<Formation> listFormations2 = formationRepository.findAllFormations();
		assertEquals(listFormations1.size() + 3, listFormations2.size());
	}

//	@Ignore
	@Test
	public void testListerFormations() {
		List<Formation> formations = formationBusiness.listerFormations();
		assertNotNull(formations);
		assertEquals(3, formations.size());
	}

}
