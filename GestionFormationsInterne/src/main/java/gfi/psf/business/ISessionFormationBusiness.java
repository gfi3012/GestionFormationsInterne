package gfi.psf.business;

import gfi.psf.entities.SessionFormation;

public interface ISessionFormationBusiness {

	public void creerSessionFormation(SessionFormation sessionFormation);

	public void affecterFormateurSessionFormation(
			Integer idSessionFormation, Integer idFormateur);
}
