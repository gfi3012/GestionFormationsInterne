package gfi.psf.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import gfi.psf.business.SessionFormationBusiness;
import gfi.psf.model.SessionFormation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin("*")
public class SessionFormationRestController {

	@Autowired
	private SessionFormationBusiness sessionFormationBusiness;

	@PostMapping("/sessionsformation")
	public ResponseEntity<Void> creerSessionFormation(
			@Valid @RequestBody SessionFormation sessionFormation) {
		SessionFormation sessionFormationAdded = sessionFormationBusiness
				.creerSessionFormation(sessionFormation);
		if (sessionFormationAdded == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(sessionFormationAdded.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/sessionsformation/{idSessionFormation}")
	public void modifierSessionFormation(@PathVariable Integer idSessionFormation,
			@Valid @RequestBody SessionFormation sessionFormation) {
		sessionFormation.setId(idSessionFormation);
		sessionFormationBusiness.modifierSessionFormation(sessionFormation);
	}

	@DeleteMapping("/sessionsformation/{idSessionFormation}")
	public void supprimerSessionFormation(@PathVariable Integer idSessionFormation) {
		sessionFormationBusiness.supprimerSessionFormation(idSessionFormation);
	}

	@GetMapping("/sessionsformation/formation/{idFormation}")
	public List<SessionFormation> chercherSessionsFormationParIdFormation(
			@PathVariable Integer idFormation) {
		return sessionFormationBusiness.chercherSessionsFormationParIdFormation(idFormation);
	}

	@GetMapping("/sessionsformation/formation/{idFormation}/datedebut/{dateDebut}")
	public List<SessionFormation> chercherSessionsFormationParIdFormationEtDateDebut(
			@PathVariable Integer idFormation, @PathVariable String dateDebut) {
		return sessionFormationBusiness.chercherSessionsFormationParIdFormationEtDateDebut(
				idFormation, dateDebut);
	}

	@PutMapping("/sessionsformation/{idSessionFormation}/formateur/{idFormateur}/affecter-formateur")
	public void affecterFormateurSessionFormation(@PathVariable Integer idSessionFormation,
			@PathVariable Integer idFormateur) {
		sessionFormationBusiness.affecterFormateurSessionFormation(idFormateur, idSessionFormation);
	}
}
