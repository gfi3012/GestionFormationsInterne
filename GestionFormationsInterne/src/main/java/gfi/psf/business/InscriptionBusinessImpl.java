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
public class InscriptionBusinessImpl implements InscriptionBusiness {

	private static final Logger logger = LoggerFactory.getLogger(InscriptionBusinessImpl.class);

	@Autowired
	private InscriptionRepository inscriptionRepository;
	@Autowired
	private SessionFormationRepository sessionFormationRepository;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	public EmailSender emailSender;

	public void inscrireCollaborateursSessionFormation(Integer idSessionFormation,
			List<Integer> listIdCollaborateur) {
		// 1 : inviter | 2 : confirmer | 3 : refuser
		SessionFormation sessionFormation = sessionFormationRepository.findOne(idSessionFormation);
		for (Integer idCollaborateur : listIdCollaborateur) {
			inscriptionRepository.save(new Inscription(1, sessionFormation, new Utilisateur(
					idCollaborateur)));
		}
		logger.info(listIdCollaborateur.size() + " Collaborateurs saved in Inscription");
		for (Integer idCollaborateur : listIdCollaborateur) {
			envoyerEmailCollaborateur(sessionFormation, idCollaborateur);
		}
		logger.info(listIdCollaborateur.size() + " Collaborateurs invited");
	}

	private void envoyerEmailCollaborateur(SessionFormation sessionFormation,
			Integer idCollaborateur) {
		Utilisateur collaborateur = utilisateurRepository.findOne(idCollaborateur);
		String subject = "Invitation à une formation sur "
				+ sessionFormation.getFormation().getNom();
		String text = "Bonjour "
				+ collaborateur.getPrenom()
				+ " "
				+ collaborateur.getNom()
				+ ",\n\nDans le cadre du renforcement des compétences de nos collaborateurs et afin d'accompagner l'évolution des technologies"
				+ " de l'informatique, nous avons le plaisir de vous inviter à participer à une formation sur "
				+ sessionFormation.getFormation().getNom()
				+ ", organisée du "
				+ sessionFormation.getDateDebut()
				+ " au "
				+ sessionFormation.getDateFin()
				+ ", à "
				+ sessionFormation.getLieu()
				+ ".\n\nVous trouverez toutes les informations complémentaires et vous pouvez confirmer/refuser l'inscription à cette formation, "
				+ "en vous connectant à votre compte sur l'application de gestion des formations"
				+ ".\n\nNous restons à votre disposition pour toute question ou suggestion, et vous prie d'agréer, l'expression de nos salutations distinguées"
				+ ".\n\n\nResponsable de formation.\nDirection des Ressources Humaines.";
		emailSender.sendMessage(collaborateur.getEmail(), subject, text);
	}

	public void confirmerInscriptionSessionFormation(Integer idSessionFormation,
			Integer idCollaborateur) {
		Inscription inscription = inscriptionRepository
				.findInscriptionByIdSessionAndIdCollaborateur(idSessionFormation, idCollaborateur);
		inscription.setCodeInscription(2);
		inscriptionRepository.save(inscription);
		logger.info("Inscription confirmed : " + inscription.getIdInscription());
	}

	public void refuserInscriptionSessionFormation(Inscription inscription) {
		inscription.setCodeInscription(3);
		inscriptionRepository.save(inscription);
		logger.info("Inscription refused : " + inscription.getIdInscription());
	}

	public void supprimerCollaborateursNonFormes(Integer idSessionFormation) {
		inscriptionRepository.deleteInscriptionsCollaborateurs(idSessionFormation);
		logger.info("Collaborateurs with codeInscription=3 in SessionFormation="
				+ idSessionFormation + " deleted");
	}
}
