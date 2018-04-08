package gfi.psf.dao;

import gfi.psf.entities.Inscription;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface InscriptionRepository extends JpaRepository<Inscription, Integer> {

	@Transactional
	@Modifying
	@Query("delete from Inscription i where i.sessionFormation.id=:x and i.etat=gfi.psf.entities.EtatInscription.REFUSED")
	public void deleteInscriptionsCollaborateurs(@Param("x") Integer idSession);
}
