package gfi.psf.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Inscription implements Serializable {
	@Id
	@GeneratedValue
	private Integer idInscription;
	private int codeInscription;
	private String motifDuRefus;
	@ManyToOne
	@JoinColumn(name="id_session_formation")
	private SessionFormation sessionFormation;
	@ManyToOne
	@JoinColumn(name="id_utilisateur")
	public Utilisateur utilisateur;
	
	public Integer getIdInscription() {
		return idInscription;
	}

	public void setIdInscription(Integer idInscription) {
		this.idInscription = idInscription;
	}

	public int getCodeInscription() {
		return codeInscription;
	}

	public void setCodeInscription(int codeInscription) {
		this.codeInscription = codeInscription;
	}

	public SessionFormation getSessionFormation() {
		return sessionFormation;
	}

	public void setSessionFormation(SessionFormation sessionFormation) {
		this.sessionFormation = sessionFormation;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Inscription() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Inscription(int codeInscription, String motifDuRefus,
			SessionFormation sessionFormation, Utilisateur utilisateur) {
		super();
		this.codeInscription = codeInscription;
		this.motifDuRefus = motifDuRefus;
		this.sessionFormation = sessionFormation;
		this.utilisateur = utilisateur;
	}

	public String getMotifDuRefus() {
		return motifDuRefus;
	}

	public void setMotifDuRefus(String motifDuRefus) {
		this.motifDuRefus = motifDuRefus;
	}

	

	

}