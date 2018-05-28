package gfi.psf.business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gfi.psf.dao.FormationRepository;
import gfi.psf.model.Formation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FormationBusinessImpl implements FormationBusiness {

	private static final Logger logger = LoggerFactory.getLogger(FormationBusinessImpl.class);

	@Autowired
	private FormationRepository formationRepository;

	public Formation creerFormation(Formation formation) {
		formationRepository.save(formation);
		logger.info("Formation saved : " + formation);
		return formation;
	}

	public void modifierFormation(Formation formation) {
		formationRepository.save(formation);
		logger.info("Formation modified : " + formation);
	}

	public void supprimerFormation(Integer idFormation) {
		logger.info("idFormation to remove : " + idFormation);
		formationRepository.delete(idFormation);
	}

	public List<Formation> chercherFormationsParNom(String nomFormation) {
		List<Formation> listFormation = formationRepository
				.findTop5ByNomLikeOrderByNom(nomFormation);
		logger.info("listFormation size : " + listFormation.size());
		return listFormation;
	}

	public List<Formation> chercherTop5Formations() {
		List<Formation> listFormation = formationRepository.findTop5ByOrderByNom();
		logger.info("listFormation size : " + listFormation.size());
		return listFormation;
	}
}
