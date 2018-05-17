package gfi.psf.dao;

import gfi.psf.model.Inscription;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface InscriptionRepository extends JpaRepository<Inscription, Integer> {

	@Transactional
	@Modifying
	@Query("delete from Inscription i where i.sessionFormation.id=:id and i.etat=gfi.psf.model.EtatInscription.REFUSED")
	public void deleteInscriptionsCollaborateurs(@Param("id") Integer idSession);
}
