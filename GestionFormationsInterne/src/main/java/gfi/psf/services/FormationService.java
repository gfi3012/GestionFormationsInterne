package gfi.psf.services;

import java.util.List;

import gfi.psf.entities.Formation;
import gfi.psf.business.FormationBusiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class FormationService {

	@Autowired
	private FormationBusiness formationBusiness;

	@PostMapping("/formations")
	public void creerFormation(@RequestBody Formation formation) {
		formationBusiness.creerFormation(formation);
	}

	@PutMapping("/formations/{idFormation}")
	public void modifierFormation(@PathVariable Integer idFormation, @RequestBody Formation formation) {
		formation.setId(idFormation);
		formationBusiness.modifierFormation(formation);
	}

	@GetMapping("/formations")
	public List<Formation> listerFormations() {
		return formationBusiness.listerFormations();
	}

}
