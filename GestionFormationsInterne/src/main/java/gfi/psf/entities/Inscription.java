package gfi.psf.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Inscription implements Serializable {

	private static final long serialVersionUID = 8596277452265934983L;
	@Id
	@GeneratedValue
	private Integer id;
	@Enumerated(EnumType.STRING)
	@Column(length = 9)
	private EtatInscription etat;
	private String motifDuRefus;
	@ManyToOne
	@JoinColumn(name = "id_session_formation")
	@JsonBackReference
	private SessionFormation sessionFormation;
	@ManyToOne
	@JoinColumn(name = "id_collaborateur")
	@JsonBackReference
	public Utilisateur collaborateur;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EtatInscription getEtat() {
		return etat;
	}

	public void setEtat(EtatInscription etat) {
		this.etat = etat;
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

	public String getMotifDuRefus() {
		return motifDuRefus;
	}

	public void setMotifDuRefus(String motifDuRefus) {
		this.motifDuRefus = motifDuRefus;
	}

	public Inscription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Inscription(EtatInscription etat, SessionFormation sessionFormation,
			Utilisateur collaborateur) {
		super();
		this.etat = etat;
		this.sessionFormation = sessionFormation;
		this.collaborateur = collaborateur;
	}

	@Override
	public String toString() {
		return "Inscription [id=" + id + ", etat=" + etat + ", motifDuRefus=" + motifDuRefus
				+ ", idSessionFormation=" + sessionFormation.getId() + ", idCollaborateur="
				+ collaborateur.getId() + "]";
	}

}