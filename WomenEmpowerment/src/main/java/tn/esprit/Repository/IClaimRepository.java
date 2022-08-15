package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Entity.Claim;

@Repository
public interface IClaimRepository extends CrudRepository<Claim,Integer> {
	
}