package gfi.psf.business;

import gfi.psf.model.SessionFormation;

public interface SessionFormationBusiness {

	public SessionFormation creerSessionFormation(SessionFormation sessionFormation);

	public void affecterFormateurSessionFormation(Integer idFormateur, Integer idSessionFormation);
}
