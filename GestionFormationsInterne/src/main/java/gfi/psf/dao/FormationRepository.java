package gfi.psf.dao;

import java.util.List;

import gfi.psf.entities.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FormationRepository extends JpaRepository<Formation, Integer>{
	
	@Query("select f from Formation f order by f.nom asc")
	public List<Formation> getFormations();
}
