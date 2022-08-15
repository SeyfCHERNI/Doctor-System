package tn.esprit.Service;

import tn.esprit.Entity.Claim;

import java.util.List;

public interface IClaimService {
	
	Claim addClaim(Claim c);
	
	boolean deleteClaim(int id);
	
	Claim updateClaim(Claim c);

	Claim retrieveClaim(int id);

	List<Claim> retrieveAllClaims();


}
