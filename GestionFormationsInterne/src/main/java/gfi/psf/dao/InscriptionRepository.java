package gfi.psf.dao;

import gfi.psf.entities.Inscription;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface InscriptionRepository extends JpaRepository<Inscription, Integer> {

	@Query("select i from Inscription i where i.sessionFormation.idSession=:x and i.utilisateur.idUtilisateur=:y")
	public Inscription findInscriptionByIdSessionAndIdUtilisateur(@Param("x") Integer idSession,
			@Param("y") Integer idUtilisateur);

	@Transactional
	@Modifying
	@Query("delete from Inscription i where i.sessionFormation.idSession=:x and i.codeInscription=3")
	public void deleteInscriptionsCollaborateurs(@Param("x") Integer idSession);
}
