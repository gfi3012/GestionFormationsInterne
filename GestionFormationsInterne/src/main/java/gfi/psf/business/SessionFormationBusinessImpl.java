package gfi.psf.business;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gfi.psf.dao.SessionFormationRepository;
import gfi.psf.model.Formation;
import gfi.psf.model.SessionFormation;
import gfi.psf.model.Utilisateur;

@Service
@Transactional
public class SessionFormationBusinessImpl implements SessionFormationBusiness {

	private static final Logger logger = LoggerFactory
			.getLogger(SessionFormationBusinessImpl.class);

	@Autowired
	private SessionFormationRepository sessionFormationRepository;

	public SessionFormation creerSessionFormation(SessionFormation sessionFormation) {
		sessionFormationRepository.save(sessionFormation);
		logger.info("SessionFormation saved : " + sessionFormation);
		return sessionFormation;
	}

	public void modifierSessionFormation(SessionFormation sessionFormation) {
		sessionFormationRepository.save(sessionFormation);
		logger.info("SessionFormation modified : " + sessionFormation);
	}

	public void supprimerSessionFormation(Integer idSessionFormation) {
		logger.info("idSessionFormation deleted : " + idSessionFormation);
		sessionFormationRepository.delete(idSessionFormation);
	}

	public List<SessionFormation> chercherSessionsFormationParIdFormation(Integer idFormation) {
		List<SessionFormation> listSessionFormation = sessionFormationRepository
				.findTop5ByFormationOrderByDateDebut(new Formation(idFormation));
		logger.info("listSessionFormation size : " + listSessionFormation.size());
		return listSessionFormation;
	}

	public List<SessionFormation> chercherSessionsFormationParIdFormationEtDateDebut(
			Integer idFormation, String dateDebut) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
		LocalDate date = LocalDate.parse(dateDebut, formatter);
		List<SessionFormation> listSessionFormation = sessionFormationRepository
				.findTop5ByFormationAndDateDebutGreaterThanEqualOrderByDateDebut(new Formation(
						idFormation), java.sql.Date.valueOf(date));
		logger.info("listSessionFormation size : " + listSessionFormation.size());
		return listSessionFormation;
	}

	public void affecterFormateurSessionFormation(Integer idFormateur, Integer idSessionFormation) {
		SessionFormation sessionFormation = sessionFormationRepository.findOne(idSessionFormation);
		sessionFormation.setFormateur(new Utilisateur(idFormateur));
		sessionFormationRepository.save(sessionFormation);
		logger.info("idFormateur affected : " + idFormateur + " to idSessionFormation : "
				+ idSessionFormation);
	}
}
