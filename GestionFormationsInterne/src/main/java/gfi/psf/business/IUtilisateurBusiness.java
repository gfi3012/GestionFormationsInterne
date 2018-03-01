package gfi.psf.business;


public interface IUtilisateurBusiness {
	
	public void confirmerInscriptionSessionFormation(Integer idSessionFormation, Integer idUtilisateur);
	public void refuserInscriptionSessionFormation(
			Integer idSessionFormation, Integer idUtilisateur, String motifDuRefus);
}
