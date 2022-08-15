package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entity.Cagnotte;
import tn.esprit.Repository.CagnotteRepository;
import tn.esprit.Service.ICagnotteService;

import javax.servlet.ServletContext;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
public class CagnotteController {
	
	@Autowired
	private ICagnotteService cagnotteService;
	
	@Autowired
	CagnotteRepository cr;
	@Autowired
	ServletContext context;
	
	// http://localhost:8085/SpringMVC/servlet/add-cagnotte

		//@PreAuthorize("hasAuthority('ADMINISTRATOR')")



		//@PreAuthorize("hasAuthority('ADMINISTRATOR')")


		@PostMapping("/add-cagnotte")
		@ResponseBody
		public Cagnotte addCagnotte(@RequestBody Cagnotte c) {
		Cagnotte cagnotte = cagnotteService.addCagnotte(c);
		return cagnotte;
		}
	
	// URL : http://localhost:8085/SpringMVC/servlet/getAllCagnotte
		
		@GetMapping(value = "getAllCagnotte")

	    public List<Cagnotte> getAllCagnotte(){
		return cagnotteService.getAllCagnotte();
		}
	    
		
		
		
	 // URL : http://localhost:8085/SpringMVC/servlet/delete-cagnotte
		   @DeleteMapping(value = "delete-cagnotte/{idCagnotte}")


			public void deleteCagnotte(@PathVariable("idCagnotte")int idCagnotte){
			   cagnotteService.deleteCagnotte(idCagnotte);
		   }
		   
		   
		   
		   
		   
		// http://localhost:8085/SpringMVC/servlet/modify-cagnotte
			
		   	@PutMapping("/modify-cagnotte")
			@ResponseBody
			public Cagnotte modifyCagnotte(@RequestBody Cagnotte cagnotte) {
			return cagnotteService.updateCagnotte(cagnotte);
			}
			
		   	
		   	
		   	
		   	
		// URL : http://localhost:8085/SpringMVC/servlet/getCagnotte_by_ID
		   	
			 @GetMapping(value = "getCagnotte_by_ID/{idCagnotte}")
			 public Optional<Cagnotte> getCagnotte_by_ID(@PathVariable("idCagnotte")int idCagnotte) {
					return cagnotteService.getCagnotte_by_ID(idCagnotte);
			}
		
			 
}

