package gfi.psf.dao;

import static org.junit.Assert.assertNotNull;
import gfi.psf.entities.Formation;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FormationRepositoryTest {
	
	@Autowired
	private FormationRepository formationRepository;

	@Test
	public void testGetFormations() {
		formationRepository.save(new Formation("nomC", "domaineC", "objectifC", 5000));
		formationRepository.save(new Formation("nomA", "domaineA", "objectifA", 5000));
		formationRepository.save(new Formation("nomB", "domaineB", "objectifB", 5000));
		List<Formation> formations = formationRepository.getFormations();
		assertNotNull(formations);
		for (Formation formation : formations) {
			System.out.println(formation);
		}
	}

}
