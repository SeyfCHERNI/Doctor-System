package tn.esprit.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Entity.CharityEvent;
import tn.esprit.Entity.User;
import tn.esprit.Repository.CharityEventRepository;
import tn.esprit.Repository.IUserRepository;

import java.util.List;



@Service
public class CharityEventServiceImpl implements ICharityEventService{
	
	@Autowired 
	CharityEventRepository eR;
	
	@Autowired 
	IUserRepository us;
	   
	@Override 
	public int ajouterCharityEvent(CharityEvent event) {
		eR.save(event); 
		   
		  
		User userManagedEntity = us.findById(1).get();
	
		
				
		System.out.println("userssss" + userManagedEntity.getEmailUser());

	

		    	
		    
		return event.getIdEvent();
	} 

	
	
	@Override
	public void deleteCharityEventById(int eventId) {
		CharityEvent eventManagedEntity = eR.findById(eventId).orElse(null);
		eR.delete(eventManagedEntity);


	}
	
	
	@Override
	public List<CharityEvent>retreiveAllEvent(){
		
		List<CharityEvent> e = (List <CharityEvent>)eR.findAll();
		return e;
	}
	
	
	@Override
	public void updateLocationByEventId(String location, int eventId) {
		CharityEvent event = eR.findById(eventId).get();
		event.setLocation(location);
		eR.save(event);

	}
}