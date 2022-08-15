package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.Entity.ImageUser;
import tn.esprit.Service.IImageUserService;
import tn.esprit.Service.ImageUserServiceImpl;
import tn.esprit.Response.ResponseMessage;

import java.io.IOException;

@RestController
@CrossOrigin("*")
public class ImageUserRestController {
	
	@Autowired
	private ImageUserServiceImpl usi;
	  
	@Autowired
	IImageUserService ius;
	
		// http://localhost:9091/SpringMVC/servlet/uploaded
		@PostMapping("/uploaded")
		public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";
	    try {
	    usi.addImage(file);
	    message = "Uploaded the file successfully: " + file.getOriginalFilename();
	    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	    }catch (Exception e) {
	    message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	    }
		}




	// http://localhost:9091/SpringMVC/servlet/affect-image-to-user
		@PostMapping("/affect-image-to-user/{idimage}/{iduser}")
		@ResponseBody
		public void affectationImageToUser(@PathVariable("idimage") int idimage,@PathVariable("iduser")Integer iduser) throws IOException{
		usi.affectationImageToUser(idimage, iduser);
		}
		
		// http://localhost:9091/SpringMVC/servlet/retreive-all-image
		@PreAuthorize("hasAuthority('ADMINISTRATOR')")
		@GetMapping ("/retreive-all-image")
		@ResponseBody
		public Iterable<ImageUser> retreiveAllImage(){
			return ius.retreiveAllImage();
		}
}
