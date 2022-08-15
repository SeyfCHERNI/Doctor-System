package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entity.CharityEvent;
import tn.esprit.Service.ICharityEventService;

import java.util.List;


@RestController
public class RestControlCharityEvent {
	

	@Autowired
	ICharityEventService eS;

	
	// http://localhost:8085/SpringMVC/servlet/ajouterCharityEvent

	@PostMapping("/ajouterCharityEvent")
	@ResponseBody
	public CharityEvent ajouterCharityEvent(@RequestBody CharityEvent event)
	{
		eS.ajouterCharityEvent(event);
		return event;

	}
	
	
	
	// URL : http://localhost:8085/SpringMVC/servlet/deleteCharityEventById/2
    @DeleteMapping("/deleteCharityEventById/{idevent}") 
	@ResponseBody
	public void deleteCharityEventById(@PathVariable("idevent")int eventId) {
    	eS.deleteCharityEventById(eventId);
	}
    
    
	// http://localhost:8085/SpringMVC/servlet/retrieveallEvent
	@GetMapping("/retrieveallEvent")
	@ResponseBody
	public List<CharityEvent> getEvent() {
	List<CharityEvent> list = eS.retreiveAllEvent();
	return list;
	}
	
	
	// Modifier location : http://localhost:8085/SpringMVC/servlet/updateLocationByEventId/2/newlocation
		@PutMapping(value = "/updateLocationByEventId/{id}/{newlocation}") 
		@ResponseBody
		public void updateLocationByEventId(@PathVariable("newlocation") String location, @PathVariable("id") int eventId) {
			eS.updateLocationByEventId(location, eventId);
			
		}
	
}
