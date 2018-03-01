package gfi.psf.dao;

import gfi.psf.entities.Inscription;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InscriptionRepository extends
		JpaRepository<Inscription, Integer> {

	@Query("select i from Inscription i where i.sessionFormation.idSession=:x and i.utilisateur.idUtilisateur=:y")
	public Inscription getInscription(@Param("x") Integer idSession,
			@Param("y") Integer idUtilisateur);

	@Query("delete from Inscription i where i.sessionFormation.idSession=:x and i.codeInscription=3")
	public Inscription deleteInscriptionsCollaborateurs(
			@Param("x") Integer idSession);
}
