package gfi.psf.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Inscription implements Serializable {

	private static final long serialVersionUID = -5235047697345217624L;
	@Id
	@GeneratedValue
	private Integer idInscription;
	private int codeInscription;
	private String motifDuRefus;
	@ManyToOne
	@JoinColumn(name = "id_session_formation")
	@JsonBackReference
	private SessionFormation sessionFormation;
	@ManyToOne
	@JoinColumn(name = "id_collaborateur")
	@JsonBackReference
	public Utilisateur collaborateur;

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

	public Utilisateur getCollaborateur() {
		return collaborateur;
	}

	public void setCollaborateur(Utilisateur collaborateur) {
		this.collaborateur = collaborateur;
	}

	public Inscription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Inscription(int codeInscription, SessionFormation sessionFormation,
			Utilisateur collaborateur) {
		super();
		this.codeInscription = codeInscription;
		this.sessionFormation = sessionFormation;
		this.collaborateur = collaborateur;
	}

	public String getMotifDuRefus() {
		return motifDuRefus;
	}

	public void setMotifDuRefus(String motifDuRefus) {
		this.motifDuRefus = motifDuRefus;
	}

	@Override
	public String toString() {
		return "Inscription [idInscription=" + idInscription + ", codeInscription="
				+ codeInscription + ", motifDuRefus=" + motifDuRefus + ", idSessionFormation="
				+ sessionFormation.getIdSession() + ", idCollaborateur=" + collaborateur.getIdUtilisateur() + "]";
	}

}