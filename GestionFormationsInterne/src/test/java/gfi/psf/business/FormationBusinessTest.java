package gfi.psf.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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

	@Test
	public void testCreerFormation() {
		List<Formation> listFormations1 = formationRepository.findAllFormations();
		formationBusiness.creerFormation(new Formation("nomC", "domaineC", "objectifC", 5000));
		formationBusiness.creerFormation(new Formation("nomA", "domaineA", "objectifA", 6000));
		formationBusiness.creerFormation(new Formation("nomB", "domaineB", "objectifB", 35000));
		List<Formation> listFormations2 = formationRepository.findAllFormations();
		assertEquals(listFormations1.size() + 3, listFormations2.size());
	}

	@Ignore
	public void testModifierFormation() {
		Formation formation = formationRepository.findOne(new Integer(1));
		formation.setNom("nomD");
		formation.setDomaine("domaineD");
		formation.setObjectif("objectifD");
		formation.setBudget(8000);
		formationBusiness.modifierFormation(formation);
		formation = formationRepository.findOne(new Integer(1));
		assertEquals("nomD", formation.getNom());
		assertEquals("domaineD", formation.getDomaine());
		assertEquals("objectifD", formation.getObjectif());
		assertTrue(8000 == formation.getBudget());
	}

	@Ignore
	public void testListerFormations() {
		List<Formation> formations = formationBusiness.listerFormations();
		assertNotNull(formations);
		assertEquals(3, formations.size());
	}

}
