package gfi.psf.business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import gfi.psf.dao.FormationRepository;
import gfi.psf.entities.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FormationBusinessImpl implements IFormationBusiness {

	private static final Logger logger = LoggerFactory.getLogger(FormationBusinessImpl.class);

	@Autowired
	private FormationRepository formationRepository;

	public void creerFormation(Formation formation) {
		formationRepository.save(formation);
		logger.info("Formation saved : " + formation);
	}

	public List<Formation> consulterFormations() {
		logger.info("Formations list size : " + formationRepository.getFormations().size());
		return formationRepository.getFormations();
	}

}
