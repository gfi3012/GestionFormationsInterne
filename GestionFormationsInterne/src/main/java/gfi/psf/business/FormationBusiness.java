package gfi.psf.business;

import java.util.List;
import gfi.psf.entities.Formation;

public interface FormationBusiness {
	
	public void creerFormation(Formation formation);
	public List<Formation> consulterFormations();
}
