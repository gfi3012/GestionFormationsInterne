package gfi.psf;

import gfi.psf.business.IUtilisateurBusiness;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilisateurBusinessTest {
	@Autowired
	private IUtilisateurBusiness utilisateurBusiness;
	
	@Test
	public void testConfirmerInscriptionSessionFormation(){
		
	}
	
	@Test
	public void testRefuserInscriptionSessionFormation(){
		
	}
}