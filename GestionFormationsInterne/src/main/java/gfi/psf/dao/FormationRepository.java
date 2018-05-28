package gfi.psf.dao;

import java.util.List;

import gfi.psf.model.Formation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FormationRepository extends JpaRepository<Formation, Integer> {

	public List<Formation> findTop5ByOrderByNom();

	public List<Formation> findTop5ByNomLikeOrderByNom(String nom);
}
