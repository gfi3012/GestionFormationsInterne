package gfi.psf.business;

import gfi.psf.entities.Inscription;

import java.util.List;

public interface InscriptionBusiness {

	public void inscrireCollaborateursSessionFormation(Integer idSessionFormation,
			List<Integer> listIdCollaborateur);

	public void confirmerInscriptionSessionFormation(Integer idSessionFormation,
			Integer idCollaborateur);

	public void refuserInscriptionSessionFormation(Inscription inscription);

	public void supprimerCollaborateursNonFormes(Integer idSessionFormation);
}
