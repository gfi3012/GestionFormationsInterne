package gfi.psf.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import gfi.psf.model.Formation;
import gfi.psf.business.FormationBusiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin("*")
public class FormationRestController {

	@Autowired
	private FormationBusiness formationBusiness;

	@PostMapping("/formations")
	public ResponseEntity<Void> creerFormation(@Valid @RequestBody Formation formation) {
		Formation formationAdded = formationBusiness.creerFormation(formation);
		if (formationAdded == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(formationAdded.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/formations/{idFormation}")
	public void modifierFormation(@PathVariable Integer idFormation,
			@Valid @RequestBody Formation formation) {
		formation.setId(idFormation);
		formationBusiness.modifierFormation(formation);
	}

	@GetMapping("/formations")
	public List<Formation> listerFormations() {
		return formationBusiness.listerFormations();
	}

}
