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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InscriptionService {

	@Autowired
	private InscriptionBusiness inscriptionBusiness;

	@PostMapping("/inscriptioncollaborateurs")
	public void inscrireCollaborateursSessionFormation(@RequestParam Integer idSessionFormation,
			@RequestBody List<Integer> listIdCollaborateur) {
		inscriptionBusiness.inscrireCollaborateursSessionFormation(idSessionFormation,
				listIdCollaborateur);
	}

	@PutMapping("/confirmationinscription")
	public void confirmerInscriptionSessionFormation(@RequestParam Integer idSessionFormation,
			@RequestParam Integer idCollaborateur) {
		inscriptionBusiness.confirmerInscriptionSessionFormation(idSessionFormation,
				idCollaborateur);
	}

	@PutMapping("/refusinscription")
	public void refuserInscriptionSessionFormation(@RequestParam Integer idSessionFormation,
			@RequestParam Integer idCollaborateur, @RequestBody String motifDuRefus) {
		inscriptionBusiness.refuserInscriptionSessionFormation(idSessionFormation, idCollaborateur,
				motifDuRefus);
	}

	 @DeleteMapping("/suppressioninscriptions")
	public void supprimerCollaborateursNonFormes(@RequestParam Integer idSessionFormation) {
		inscriptionBusiness.supprimerCollaborateursNonFormes(idSessionFormation);
	}
}
