package gfi.psf.entities;

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

@Entity
public class SessionFormation implements Serializable {

	private static final long serialVersionUID = -6104727009777247909L;
	@Id
	@GeneratedValue
	private Integer idSession;
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	private int nbrPlaces;
	@Column(length = 120)
	private String lieu;
	@ManyToOne
	@JoinColumn(name = "id_formation")
	private Formation formation;
	@OneToMany(mappedBy = "sessionFormation")
	public Collection<Inscription> inscriptions;
	@OneToOne
	@JoinColumn(name = "id_formateur")
	public Utilisateur formateur;

	public Integer getIdSession() {
		return idSession;
	}

	public void setIdSession(Integer idSession) {
		this.idSession = idSession;
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

	public SessionFormation(Date dateDebut, Date dateFin, int nbrPlaces, String lieu) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.nbrPlaces = nbrPlaces;
		this.lieu = lieu;
	}

	@Override
	public String toString() {
		return "SessionFormation [idSession=" + idSession + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + ", nbrPlaces=" + nbrPlaces + ", lieu=" + lieu + "]";
	}

}