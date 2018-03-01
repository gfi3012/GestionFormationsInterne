package gfi.psf.business;

import gfi.psf.dao.InscriptionRepository;
import gfi.psf.dao.SessionFormationRepository;
import gfi.psf.dao.UtilisateurRepository;
import gfi.psf.entities.Inscription;
import gfi.psf.entities.SessionFormation;
import gfi.psf.entities.Utilisateur;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InscriptionBusinessImpl implements IInscriptionBusiness {

	private static final Logger logger = LoggerFactory.getLogger(InscriptionBusinessImpl.class);

	@Autowired
	private InscriptionRepository inscriptionRepository;
	@Autowired
	private SessionFormationRepository sessionFormationRepository;
	@Autowired
	private UtilisateurRepository utilisateurRepository;

	public void inscrireCollaborateursSessionFormation(Integer idSessionFormation,
			List<Integer> listIdUtilisateur) {
		// 1 : inviter | 2 : confirmer | 3 : refuser
		SessionFormation sessionFormation = sessionFormationRepository.findOne(idSessionFormation);
		for (Integer idUtilisateur : listIdUtilisateur) {
			inscriptionRepository.save(new Inscription(1, "", sessionFormation, new Utilisateur(
					idUtilisateur)));
		}
		logger.info(listIdUtilisateur.size() + " Collaborateurs saved in Inscription");
		// for (Integer idUtilisateur : listIdUtilisateur) {
		// envoyerEmailCollaborateur(sessionFormation,idUtilisateur);
		// }
		// logger.info(listIdUtilisateur.size() + " Collaborateurs invited");
	}

	private void envoyerEmailCollaborateur(SessionFormation sessionFormation, Integer idUtilisateur) {
		// Utilisateur utilisateur =
		// utilisateurRepository.findOne(idUtilisateur);
	}

	public void supprimerCollaborateursNonFormes(Integer idSessionFormation) {
		inscriptionRepository.deleteInscriptionsCollaborateurs(idSessionFormation);
		logger.info("Collaborateurs with codeInscription=3 and invited in SessionFormation="
				+ idSessionFormation + " deleted");
	}
}
