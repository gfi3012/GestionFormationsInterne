package gfi.psf.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Formation implements Serializable {

	private static final long serialVersionUID = -6646282979702556229L;

	@Id
	@GeneratedValue
	private Integer id;
	@Column(length = 100)
	@NotNull
	@Size(min = 1)
	private String nom;
	private String domaine;
	@NotNull
	@Size(min = 1)
	private String objectif;
	@Min(value = 0)
	private double budget;

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "formation")
	@JsonManagedReference(value = "formation-sessionsFormation")
	private Collection<SessionFormation> sessionsFormation;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Collection<SessionFormation> getSessionsFormation() {
		return sessionsFormation;
	}

	public void setSessionsFormation(Collection<SessionFormation> sessionsFormation) {
		this.sessionsFormation = sessionsFormation;
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

	public Formation(Integer id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "Formation [id=" + id + ", nom=" + nom + ", domaine=" + domaine + ", objectif="
				+ objectif + ", budget=" + budget + "]";
	}

}
