package gfi.psf.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import gfi.psf.dao.FormationRepository;
import gfi.psf.model.Formation;
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
		int size1 = formationRepository.findAll().size();
		formationBusiness.creerFormation(new Formation("nomC", "domaineC", "objectifC", 5000));
		formationBusiness.creerFormation(new Formation("nomA", "domaineA", "objectifA", 6000));
		formationBusiness.creerFormation(new Formation("nomF", "domaineF", "objectifF", 13000));
		formationBusiness.creerFormation(new Formation("nomB", "domaineB", "objectifB", 25000));
		formationBusiness.creerFormation(new Formation("nomE", "domaineE", "objectifE", 1000));
		formationBusiness.creerFormation(new Formation("nomD", "domaineD", "objectifD", 3000));
		formationBusiness.creerFormation(new Formation("opc", "domaineK", "objectifK", 5500));
		formationBusiness.creerFormation(new Formation("yopq", "domaineL", "objectifL", 46000));
		formationBusiness.creerFormation(new Formation("ropf", "domaineM", "objectifM", 43000));
		formationBusiness.creerFormation(new Formation("opa", "domaineN", "objectifN", 24000));
		formationBusiness.creerFormation(new Formation("top", "domaineO", "objectifO", 4000));
		formationBusiness.creerFormation(new Formation("pop", "domaineP", "objectifP", 3400));
		int size2 = formationRepository.findAll().size();
		assertEquals(size1 + 12, size2);
	}

	@Ignore
	public void testModifierFormation() {
		Formation formation = formationRepository.findOne(1);
		formation.setNom("nomJ");
		formation.setDomaine("domaineJ");
		formation.setObjectif("objectifJ");
		formation.setBudget(8000);
		formationBusiness.modifierFormation(formation);
		formation = formationRepository.findOne(1);
		assertEquals("nomJ", formation.getNom());
		assertEquals("domaineJ", formation.getDomaine());
		assertEquals("objectifJ", formation.getObjectif());
		assertTrue(8000 == formation.getBudget());
	}

	@Ignore
	public void testSupprimerFormation() {
		int size1 = formationRepository.findAll().size();
		formationBusiness.supprimerFormation(3);
		int size2 = formationRepository.findAll().size();
		assertEquals(size1 - 1, size2);
	}

	@Ignore
	public void testChercherFormationsParNom() {
		List<Formation> formations = formationBusiness.chercherFormationsParNom("%op%");
		assertNotNull(formations);
		assertTrue(formations.size() <= 5);
	}

	@Ignore
	public void testChercherTop5Formations() {
		List<Formation> formations = formationBusiness.chercherTop5Formations();
		assertNotNull(formations);
		assertTrue(formations.size() <= 5);
	}

}
