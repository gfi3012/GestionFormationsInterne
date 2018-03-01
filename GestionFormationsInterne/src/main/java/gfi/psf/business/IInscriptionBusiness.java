package gfi.psf.business;

import java.util.List;

public interface IInscriptionBusiness {

	public void inscrireCollaborateursSessionFormation(
			Integer idSessionFormation, List<Integer> listIdUtilisateur);

	public void supprimerCollaborateursNonFormes(Integer idSessionFormation);
}
