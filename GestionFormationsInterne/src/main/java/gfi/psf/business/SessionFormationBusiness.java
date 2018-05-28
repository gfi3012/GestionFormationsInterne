package gfi.psf.business;

import java.util.List;

import gfi.psf.model.SessionFormation;

public interface SessionFormationBusiness {

	public SessionFormation creerSessionFormation(SessionFormation sessionFormation);

	public void modifierSessionFormation(SessionFormation sessionFormation);

	public void supprimerSessionFormation(Integer idSessionFormation);

	public List<SessionFormation> chercherSessionsFormationParIdFormation(Integer idFormation);

	public List<SessionFormation> chercherSessionsFormationParIdFormationEtDateDebut(
			Integer idFormation, String dateDebut);

	public void affecterFormateurSessionFormation(Integer idFormateur, Integer idSessionFormation);
}
