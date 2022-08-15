
package tn.esprit.Service;

import tn.esprit.Entity.Publicity;

import java.util.List;


public interface IPublicityService  {

	public List<Publicity> showAll();
	public void deletePublicity(int id);
	public Publicity updatePublicity(int id,Publicity p);
	public Publicity addPublicity(Publicity p);
	public Publicity GetPublicityById(int id);
	public List<Publicity> GetPublicitiesByName(String name);
	public Publicity findById(int id);
	public float coastOnChannel(String Channel);
	
	
	
	
}

