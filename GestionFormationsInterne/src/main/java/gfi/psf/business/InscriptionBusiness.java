package gfi.psf.business;

import java.util.List;

public interface InscriptionBusiness {

	public void inscrireCollaborateursSessionFormation(List<Integer> listIdCollaborateur,
			Integer idSessionFormation);

	public void confirmerInscriptionSessionFormation(Integer idInscription);

	public void refuserInscriptionSessionFormation(Integer idInscription, String motifDuRefus);

	public void supprimerCollaborateursNonFormes(Integer idSessionFormation);
}
