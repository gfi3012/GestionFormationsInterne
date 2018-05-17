package gfi.psf.dao;

import gfi.psf.model.Utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

}
