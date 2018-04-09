package gfi.psf.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gfi.psf.dao.SessionFormationRepository;
import gfi.psf.entities.SessionFormation;
import gfi.psf.entities.Utilisateur;

@Service
@Transactional
public class SessionFormationBusinessImpl implements SessionFormationBusiness {

	private static final Logger logger = LoggerFactory
			.getLogger(SessionFormationBusinessImpl.class);

	@Autowired
	private SessionFormationRepository sessionFormationRepository;

	public void creerSessionFormation(SessionFormation sessionFormation) {
		sessionFormationRepository.save(sessionFormation);
		logger.info("SessionFormation saved : " + sessionFormation);
	}

	public void affecterFormateurSessionFormation(Integer idFormateur, Integer idSessionFormation) {
		SessionFormation sessionFormation = sessionFormationRepository.findOne(idSessionFormation);
		sessionFormation.setFormateur(new Utilisateur(idFormateur));
		sessionFormationRepository.save(sessionFormation);
		logger.info("idFormateur affected : " + idFormateur + " to idSessionFormation : "
				+ idSessionFormation);
	}

}
