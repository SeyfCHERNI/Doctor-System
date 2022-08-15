package tn.esprit.Service;

import tn.esprit.Entity.ImageUser;

public interface IImageUserService {
	
	void affectationImageToUser(int idImageUser, Integer idUser);
	
	public Iterable<ImageUser> retreiveAllImage();

}
