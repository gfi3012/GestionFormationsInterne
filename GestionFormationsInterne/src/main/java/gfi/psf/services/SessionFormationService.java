package gfi.psf.services;

import gfi.psf.business.SessionFormationBusiness;
import gfi.psf.entities.SessionFormation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionFormationService {

	@Autowired
	private SessionFormationBusiness sessionFormationBusiness;

	@PostMapping("/sessionsformation")
	public void creerSessionFormation(@RequestBody SessionFormation sessionFormation) {
		sessionFormationBusiness.creerSessionFormation(sessionFormation);
	}

	@PutMapping("/sessionsformation")
	public void affecterFormateurSessionFormation(@RequestParam Integer idSessionFormation,
			@RequestParam Integer idFormateur) {
		sessionFormationBusiness.affecterFormateurSessionFormation(idSessionFormation, idFormateur);
	}
}