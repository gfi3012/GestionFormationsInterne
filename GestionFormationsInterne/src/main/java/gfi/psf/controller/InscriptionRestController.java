package gfi.psf.controller;

import java.util.List;

import gfi.psf.business.InscriptionBusiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class InscriptionRestController {

	@Autowired
	private InscriptionBusiness inscriptionBusiness;

	@PostMapping("/inscriptions/sessionformation/{idSessionFormation}")
	public void inscrireCollaborateursSessionFormation(@PathVariable Integer idSessionFormation,
			@RequestBody List<Integer> listIdCollaborateur) {
		inscriptionBusiness.inscrireCollaborateursSessionFormation(listIdCollaborateur,
				idSessionFormation);
	}

	@PutMapping("/inscriptions/{idInscription}/confirmer")
	public void confirmerInscriptionSessionFormation(@PathVariable Integer idInscription) {
		inscriptionBusiness.confirmerInscriptionSessionFormation(idInscription);
	}

	@PutMapping("/inscriptions/{idInscription}/refuser")
	public void refuserInscriptionSessionFormation(@PathVariable Integer idInscription,
			@RequestBody String motifDuRefus) {
		inscriptionBusiness.refuserInscriptionSessionFormation(idInscription, motifDuRefus);
	}

	@DeleteMapping("/inscriptions/sessionformation/{idSessionFormation}/supprimer-collaborateurs-non-formes")
	public void supprimerCollaborateursNonFormes(@PathVariable Integer idSessionFormation) {
		inscriptionBusiness.supprimerCollaborateursNonFormes(idSessionFormation);
	}
}
