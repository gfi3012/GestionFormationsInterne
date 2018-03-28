package gfi.psf.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Formation implements Serializable {

	private static final long serialVersionUID = 8893944213339743866L;
	@Id
	@GeneratedValue
	private Integer idFormation;
	@Column(length = 40)
	private String nom;
	@Column(length = 80)
	private String domaine;
	private String objectif;
	private double budget;
	@OneToMany(mappedBy = "formation")
	private Collection<SessionFormation> sessionFormations;

	public Integer getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(Integer idFormation) {
		this.idFormation = idFormation;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDomaine() {
		return domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}

	public String getObjectif() {
		return objectif;
	}

	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public Collection<SessionFormation> getSessionFormations() {
		return sessionFormations;
	}

	public void setSessionFormations(Collection<SessionFormation> sessionFormations) {
		this.sessionFormations = sessionFormations;
	}

	public Formation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Formation(String nom, String domaine, String objectif, double budget) {
		super();
		this.nom = nom;
		this.domaine = domaine;
		this.objectif = objectif;
		this.budget = budget;
	}

	@Override
	public String toString() {
		return "Formation [idFormation=" + idFormation + ", nom=" + nom + ", domaine=" + domaine
				+ ", objectif=" + objectif + ", budget=" + budget + "]";
	}

}
