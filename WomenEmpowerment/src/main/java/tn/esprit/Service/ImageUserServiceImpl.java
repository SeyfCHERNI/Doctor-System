package tn.esprit.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.Entity.User;
import tn.esprit.Entity.ImageUser;
import tn.esprit.Repository.IImageUserRepository;
import tn.esprit.Repository.IUserRepository;

import java.io.IOException;

@Service
public class ImageUserServiceImpl implements IImageUserService{

	
	@Autowired
	IImageUserRepository iur;
	
	@Autowired
	IUserRepository ur;
	
	 public ImageUser addImage(MultipartFile file) throws IOException {
		    String nameImageUser = StringUtils.cleanPath(file.getOriginalFilename());
		    ImageUser ImageUser = new ImageUser(nameImageUser, file.getContentType(), file.getBytes());

		    return iur.save(ImageUser);
		  }
	 
	 @Override
		public void affectationImageToUser(int idImageUser, Integer idUser) {
			// TODO Auto-generated method stub
			User user =ur.findById(idUser).get();
			ImageUser imageUser=iur.findById(idImageUser).get();
			imageUser.setUser(user);
			iur.save(imageUser);
}


		@Override
		public Iterable<ImageUser> retreiveAllImage() {
			return iur.findAll();
		}


}
