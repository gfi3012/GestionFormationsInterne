package gfi.psf.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import gfi.psf.model.Formation;

import java.util.List;

import org.junit.Ignore;
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
	public void testFindTop5ByOrderByNom() {
		List<Formation> formations = formationRepository.findTop5ByOrderByNom();
		assertNotNull(formations);
		assertTrue(formations.size() <= 5);
		assertEquals("nomA", formations.get(0).getNom());
		assertEquals("nomB", formations.get(1).getNom());
		assertEquals("nomC", formations.get(2).getNom());
		assertEquals("nomD", formations.get(3).getNom());
		assertEquals("nomE", formations.get(4).getNom());
	}

	@Ignore
	public void testFindTop5ByNomLikeOrderByNom() {
		List<Formation> formations = formationRepository.findTop5ByNomLikeOrderByNom("%op%");
		assertNotNull(formations);
		assertTrue(formations.size() <= 5);
		assertEquals("opa", formations.get(0).getNom());
		assertEquals("opc", formations.get(1).getNom());
		assertEquals("pop", formations.get(2).getNom());
		assertEquals("ropf", formations.get(3).getNom());
		assertEquals("top", formations.get(4).getNom());
	}
}
