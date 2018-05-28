package gfi.psf.business;

import java.util.List;

import gfi.psf.model.Formation;

public interface FormationBusiness {

	public Formation creerFormation(Formation formation);

	public void modifierFormation(Formation formation);

	public void supprimerFormation(Integer idFormation);

	public List<Formation> chercherFormationsParNom(String nomFormation);

	public List<Formation> chercherTop5Formations();
}
