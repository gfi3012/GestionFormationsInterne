package gfi.psf.business;


public interface UtilisateurBusiness {
	
	public void confirmerInscriptionSessionFormation(Integer idSessionFormation, Integer idUtilisateur);
	public void refuserInscriptionSessionFormation(
			Integer idSessionFormation, Integer idUtilisateur, String motifDuRefus);
}
