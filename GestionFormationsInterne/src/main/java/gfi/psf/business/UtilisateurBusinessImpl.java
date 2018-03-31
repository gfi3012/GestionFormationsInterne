package gfi.psf.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gfi.psf.dao.InscriptionRepository;
import gfi.psf.entities.Inscription;

@Service
@Transactional
public class UtilisateurBusinessImpl implements UtilisateurBusiness {

	private static final Logger logger = LoggerFactory.getLogger(UtilisateurBusinessImpl.class);

	@Autowired
	private InscriptionRepository inscriptionRepository;

	public void confirmerInscriptionSessionFormation(Integer idSessionFormation,
			Integer idUtilisateur) {
		Inscription inscription = inscriptionRepository.findInscriptionByIdSessionAndIdUtilisateur(
				idSessionFormation, idUtilisateur);
		inscription.setCodeInscription(2);
		inscriptionRepository.save(inscription);
		logger.info("Inscription confirmed : " + inscription.getIdInscription());

	}

	public void refuserInscriptionSessionFormation(Integer idSessionFormation,
			Integer idUtilisateur, String motifDuRefus) {
		Inscription inscription = inscriptionRepository.findInscriptionByIdSessionAndIdUtilisateur(
				idSessionFormation, idUtilisateur);
		inscription.setCodeInscription(3);
		inscription.setMotifDuRefus(motifDuRefus);
		inscriptionRepository.save(inscription);
		logger.info("Inscription refused : " + inscription.getIdInscription());

	}

}
