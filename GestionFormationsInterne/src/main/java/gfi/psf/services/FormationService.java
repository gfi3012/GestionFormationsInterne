package gfi.psf.services;

import java.util.List;

import gfi.psf.entities.Formation;
import gfi.psf.business.IFormationBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormationService {
	
	@Autowired
	private IFormationBusiness formationBusiness;

	@RequestMapping(value = "/formations", method = RequestMethod.POST)
	public void creerFormation(@RequestBody Formation formation) {
		formationBusiness.creerFormation(formation);
	}

	@RequestMapping(value = "/formations", method = RequestMethod.GET)
	public List<Formation> consulterFormations() {
		return formationBusiness.consulterFormations();
	}

}
