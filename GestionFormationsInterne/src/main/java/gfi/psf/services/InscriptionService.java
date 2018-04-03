package gfi.psf.services;

import java.util.List;

import gfi.psf.business.InscriptionBusiness;
import gfi.psf.entities.Inscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InscriptionService {

	@Autowired
	private InscriptionBusiness inscriptionBusiness;

//	@PostMapping("/inscriptionscollaborateurs/{idSessionFormation}/idsessionformation")
	public void inscrireCollaborateursSessionFormation(@PathVariable Integer idSessionFormation,
			List<Integer> listIdCollaborateur) {
		inscriptionBusiness.inscrireCollaborateursSessionFormation(idSessionFormation,
				listIdCollaborateur);
	}

//	@DeleteMapping("/inscriptions/{idSessionFormation}/idsessionformation")
	public void supprimerCollaborateursNonFormes(@PathVariable Integer idSessionFormation) {
		inscriptionBusiness.supprimerCollaborateursNonFormes(idSessionFormation);
	}
	
//	@PutMapping("/confirmations/idsessionformation/{idSessionFormation}/")
	public void confirmerInscriptionSessionFormation(@PathVariable Integer idSessionFormation,
			@PathVariable Integer idCollaborateur) {
		inscriptionBusiness.confirmerInscriptionSessionFormation(idSessionFormation, idCollaborateur);
	}

//	@PutMapping("/refus/idsessionformation/{idSessionFormation}/")
	public void refuserInscriptionSessionFormation(@RequestBody Inscription inscription) {
		inscriptionBusiness.refuserInscriptionSessionFormation(inscription);
	}
}
