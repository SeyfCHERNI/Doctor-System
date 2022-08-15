package tn.esprit.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Entity.Claim;
import tn.esprit.Repository.IClaimRepository;

import java.util.List;

@Service
public class ClaimServiceImpl implements IClaimService {

	
	
	
	@Autowired
	IClaimRepository cr;
	

	
	@Override
	public Claim addClaim(Claim c) {
		
		return cr.save(c);
	}

	@Override
	public boolean deleteClaim(int id) {
		if(cr.existsById(id)){
			cr.deleteById(id);
			return true; 
			
		}else
		{return false;}
	}
	
	@Override
	public Claim updateClaim(Claim c){
		
		return cr.save(c);
	}

	@Override
	public Claim retrieveClaim(int id){
		return cr.findById(id) .get();
	}
	
	@Override
	public List<Claim> retrieveAllClaims(){
		return (List<Claim>) cr.findAll();	
		
	}
	
	
	
}