package gfi.psf.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class Utilisateur implements Serializable {

	private static final long serialVersionUID = 4966506789826852562L;

	@Id
	@GeneratedValue
	private Integer id;
	@Column(length = 40, unique = true)
	@NotNull
	@Size(min = 1)
	private String cin;
	@Column(length = 40)
	@NotNull
	@Size(min = 1)
	private String nom;
	@Column(length = 40)
	@NotNull
	@Size(min = 1)
	private String prenom;
	@Column(length = 40)
	private String email;
	@Temporal(TemporalType.DATE)
	@Past
	private Date dateDeNaissance;
	@Temporal(TemporalType.DATE)
	private Date dateEntree;
	@Column(length = 40, unique = true)
	@NotNull
	@Size(min = 1)
	private String identifiant;
	@Column(length = 40)
	@NotNull
	@Size(min = 1)
	private String motDePasse;
	private boolean actif;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public Date getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utilisateur(Integer id) {
		super();
		this.id = id;
	}

}