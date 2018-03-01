package gfi.psf;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import gfi.psf.dao.FormationRepository;
import gfi.psf.entities.Formation;
import gfi.psf.business.IFormationBusiness;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FormationBusinessTest {

	@Autowired
	private IFormationBusiness formationBusiness;
	@Autowired
	private FormationRepository formationRepository;

//	@Test
//	public void testCreerFormation() {
//		List<Formation> listFormations1 = formationRepository.getFormations();
//		formationBusiness.creerFormation(new Formation("nom35", "domaine35",
//				"objectif35", 3500));
//		formationBusiness.creerFormation(new Formation("nom356", "domaine356",
//				"objectif356", 35600));
//		List<Formation> listFormations2 = formationRepository.getFormations();
//		assertTrue(listFormations1.size() + 2 == listFormations2.size());
//	}
//	
	@Test
	public void testConsulterFormations() {
		List<Formation> formations = formationBusiness.consulterFormations();
		assertNotNull(formations);
		for (Formation formation : formations) {
			System.out.println(formation);
		}
	}

}
