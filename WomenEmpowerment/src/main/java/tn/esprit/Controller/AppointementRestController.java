package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entity.Appointement;
import tn.esprit.Service.AppointementService;

import java.util.List;


@RestController
@RequestMapping("/Appointement")
public class AppointementRestController {
	
	@Autowired
	 AppointementService appointementservice ;
	
	
	// http://localhost:8090/Appointement/retrieveAllAppointements
	@GetMapping("/retrieveAllAppointements")
	@ResponseBody
	public List<Appointement> retrieveAllAppointements(){
		return appointementservice.retrieveAllAppointements();
	}
	
	
	// http://localhost:8090/Appointement/retrieveAppointementById/{idAppointement}
	@GetMapping("/retrieveAppointementById/{idAppointement}")
	@ResponseBody
	public Appointement retrieveAppointementById(@PathVariable("idAppointement") Integer  id){
		return appointementservice.retrieveAppointement(id);
	}
	
	
	// http://localhost:8090/Appointement/addAppointement
	@PostMapping("/addAppointement")
	public Appointement addAppointement(@RequestBody Appointement A){
		return appointementservice.addAppointement(A);
	}
	
	
	// http://localhost:8090/Appointement/updateAppointement
	@PutMapping("/updateAppointement")
	@ResponseBody
	public Appointement updateAppointement(@RequestBody Appointement A){
		
		return appointementservice.updateAppointement(A);
	}
	
	
	// http://localhost:8090/Appointement/removeAppointement/{Appointement-id}

	@DeleteMapping("/removeAppointement/{Appointement-id}")
	@ResponseBody
	public void removeAppointement(@PathVariable("Appointement-id") Integer AppointementId) {
		appointementservice.deleteAppointement(AppointementId);
	}
	
	
	
}

