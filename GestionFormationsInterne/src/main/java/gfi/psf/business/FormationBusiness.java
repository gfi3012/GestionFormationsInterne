package gfi.psf.business;

import java.util.List;

import gfi.psf.model.Formation;

public interface FormationBusiness {
	
	public Formation creerFormation(Formation formation);
	public void modifierFormation(Formation formation);
	public List<Formation> listerFormations();
}
