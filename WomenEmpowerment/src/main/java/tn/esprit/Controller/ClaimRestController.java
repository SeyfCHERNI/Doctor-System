package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entity.Claim;
import tn.esprit.Service.IClaimService;

import java.util.List;

@RestController

@CrossOrigin("*")

public class ClaimRestController{
	
	@Autowired
	IClaimService Cs;
	
	
	// http://localhost:9091/SpringMVC/servlet/retrieve-all-claims
	//@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@GetMapping("/retrieve-all-claims")
	@ResponseBody
	public List<Claim> getClaims() {
	List<Claim> list = Cs.retrieveAllClaims();
	return list;
	}
	
	// http://localhost:9091/SpringMVC/servlet/add-claim
	@PostMapping("/add-claim")
	@ResponseBody
	public Claim addClaim(@RequestBody Claim c) {
	Claim claim= Cs.addClaim(c);
	return claim;
	}
	
	// http://localhost:9091/SpringMVC/servlet/retrieve-claim/{claim-id}
	@GetMapping("/retrieve-claim/{claim-id}")
	@ResponseBody
	public Claim retrieveClaim(@PathVariable("claim-id") int idClaim) {
	return Cs.retrieveClaim(idClaim);
	}
	
	// http://localhost:9091/SpringMVC/servlet/remove-claim/{claim-id}
	//@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@DeleteMapping("/remove-claim/{claim-id}")
	@ResponseBody
	public void removeUser(@PathVariable("claim-id") int idClaim) {
	Cs.deleteClaim(idClaim);
	}
	
	// http://localhost:9091/SpringMVC/servlet/modify-claim
	//@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@PutMapping("/modify-claim")
	@ResponseBody
	public Claim modifyClaim(@RequestBody Claim c) {
	return Cs.updateClaim(c);
}
	}
