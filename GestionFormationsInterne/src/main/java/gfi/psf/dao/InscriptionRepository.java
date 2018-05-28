package gfi.psf.dao;

import java.util.List;

import gfi.psf.model.EtatInscription;
import gfi.psf.model.Inscription;
import gfi.psf.model.SessionFormation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface InscriptionRepository extends JpaRepository<Inscription, Integer> {

	public List<Inscription> findTop5BySessionFormationOrderByEtat(SessionFormation sessionFormation);

	@Transactional
	public void deleteBySessionFormationAndEtat(SessionFormation sessionFormation,
			EtatInscription etat);
}
