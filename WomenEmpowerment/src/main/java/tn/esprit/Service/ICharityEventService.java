package tn.esprit.Service;

import tn.esprit.Entity.CharityEvent;

import java.util.List;

public interface ICharityEventService {
	
	public int ajouterCharityEvent(CharityEvent event) ;
	
	public void deleteCharityEventById(int eventId); 
	
	List<CharityEvent>retreiveAllEvent();
	

	public void updateLocationByEventId(String location, int eventId);
}
 