package gfi.psf.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "id_session_formation",
		"id_collaborateur" }))
public class Inscription implements Serializable {

	private static final long serialVersionUID = 4837113087759614721L;
	
	@Id
	@GeneratedValue
	private Integer id;
	@Enumerated(EnumType.STRING)
	@Column(length = 9)
	@NotNull
	private EtatInscription etat;
	@Size(min = 1)
	private String motifDuRefus;

	@ManyToOne
	@JoinColumn(name = "id_session_formation", nullable = false)
	@JsonBackReference(value = "sessionFormation-inscriptions")
	private SessionFormation sessionFormation;

	@ManyToOne
	@JoinColumn(name = "id_collaborateur", nullable = false)
	private Utilisateur collaborateur;

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