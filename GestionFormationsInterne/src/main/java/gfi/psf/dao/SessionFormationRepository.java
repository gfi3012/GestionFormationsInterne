package gfi.psf.dao;

import java.util.Date;
import java.util.List;

import gfi.psf.model.Formation;
import gfi.psf.model.SessionFormation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionFormationRepository extends JpaRepository<SessionFormation, Integer> {

	public List<SessionFormation> findTop5ByFormationOrderByDateDebut(Formation formation);

	public List<SessionFormation> findTop5ByFormationAndDateDebutGreaterThanEqualOrderByDateDebut(
			Formation formation, Date dateDebut);

}
