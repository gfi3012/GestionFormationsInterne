package gfi.psf.business;

import gfi.psf.model.Inscription;

import java.util.List;

public interface InscriptionBusiness {

	public void inscrireCollaborateursSessionFormation(List<Integer> listIdCollaborateur,
			Integer idSessionFormation);

	public List<Inscription> chercherInscriptionsParIdSessionFormation(Integer idSessionFormation);

	public void confirmerInscriptionSessionFormation(Integer idInscription);

	public void refuserInscriptionSessionFormation(Integer idInscription, String motifDuRefus);

	public void supprimerInscriptionCollaborateur(Integer idInscription);

	public void supprimerCollaborateursNonFormes(Integer idSessionFormation);

}
