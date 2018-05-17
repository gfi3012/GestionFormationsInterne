package gfi.psf.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class SessionFormation implements Serializable {

	private static final long serialVersionUID = -7280221572134573814L;

	@Id
	@GeneratedValue
	private Integer id;
	@Temporal(TemporalType.DATE)
	@NotNull
	@Future
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	@NotNull
	@Future
	private Date dateFin;
	@Min(value = 1)
	private int nbrPlaces;
	@Column(length = 170)
	@Size(min = 3)
	private String lieu;

	@ManyToOne
	@JoinColumn(name = "id_formation", nullable = false)
	@JsonBackReference(value = "formation-sessionsFormation")
	private Formation formation;

	@OneToMany(mappedBy = "sessionFormation")
	@JsonManagedReference(value = "sessionFormation-inscriptions")
	public Collection<Inscription> inscriptions;

	@OneToOne
	@JoinColumn(name = "id_formateur")
	public Utilisateur formateur;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public int getNbrPlaces() {
		return nbrPlaces;
	}

	public void setNbrPlaces(int nbrPlaces) {
		this.nbrPlaces = nbrPlaces;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Collection<Inscription> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(Collection<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	public Utilisateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Utilisateur formateur) {
		this.formateur = formateur;
	}

	public SessionFormation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SessionFormation(Date dateDebut, Date dateFin, int nbrPlaces, String lieu,
			Formation formation) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.nbrPlaces = nbrPlaces;
		this.lieu = lieu;
		this.formation = formation;
	}

	@Override
	public String toString() {
		return "SessionFormation [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
				+ ", nbrPlaces=" + nbrPlaces + ", lieu=" + lieu + ", idFormation="
				+ formation.getId() + "]";
	}

}