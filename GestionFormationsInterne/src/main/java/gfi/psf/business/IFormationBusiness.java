package gfi.psf.business;

import java.util.List;
import gfi.psf.entities.Formation;

public interface IFormationBusiness {
	
	public void creerFormation(Formation formation);
	public List<Formation> consulterFormations();
}
