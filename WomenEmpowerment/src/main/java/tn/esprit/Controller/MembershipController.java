package tn.esprit.Controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entity.Membership;
import tn.esprit.Service.IMembershipService;
import tn.esprit.Service.UserServiceImpl;
import tn.esprit.Exception.*;
import tn.esprit.util.CodeQR;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@Slf4j
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/membership")

public class MembershipController {

	private IMembershipService membershipService;
	private UserServiceImpl userService;
	private final String imagePath = "./src/main/resources/qrcodes/QRCode.png";
	@PostMapping("/addMembership")

	Membership addMembership(@RequestBody Membership membership){
		return membershipService.addMembership(membership);
	}





	@PostMapping("/add-membership/{idUser}")
	@ResponseBody
	public Membership  addMebership2 (@RequestBody Membership membership,@PathVariable ("idUser") Integer idUser) {
		Membership listMemberships= membershipService.addMembership2(membership,idUser);
		return listMemberships;
	}


	@GetMapping("/getMembership/{idMem}")

	Membership getMembershipById(@PathVariable("idMem") Long idMem){
		return membershipService.getMembershipById(idMem);
	}

	/*@GetMapping("/get-Memberships/{idUser}")

	List <Membership> listedeMemberships(@PathVariable("idUser") Long idUser){
		return membershipService.listedeMemberships(idUser);
	}*/
	@DeleteMapping("/delete-membership/{idMem}")
	void deleteMembership (@PathVariable("idMem") Long idMem){
		membershipService.deleteMembership(idMem);
	}

	@GetMapping("/get-All-Memberships")

	List<Membership>  getAllMembership(){
		return 	membershipService.getMemberships();
	}


	@PutMapping ("/updateMembership")
	Membership updateMembership(@RequestBody Membership membership){
		return membershipService.updateMembership(membership);
	}


	@GetMapping("/generateByteQRCode/{idMem}")
	public ResponseEntity<Membership> generateByteQRCode(@PathVariable("idMem") Long idMem) {
		log.info("MembershipController - generateByteQRCode");
		Membership membershipObject = null;
		Optional<Membership> membership = membershipService.findById(idMem);
		if (!membership.isPresent()) {
			throw new NotFoundException("Membership not found");
		} else {
			membershipObject = membership.get();
			membershipObject.setBase64QRCode(CodeQR.generateByteQRCode(membershipObject.getQRCodeMem(), 250, 250));
			membershipObject.add(linkTo(methodOn(MembershipController.class).findAll()).withSelfRel());
		}
		return new ResponseEntity<>(membershipObject, HttpStatus.OK);
	}

	@GetMapping("/generateImageQRCode/{idMem}")
	public ResponseEntity<Membership> generateImageQRCode(@PathVariable("idMem") Long idMem) {
		log.info("membershipResourceImpl - generateImageQRCode");
		Membership membershipObject = null;
		Optional<Membership> membership = membershipService.findById(idMem);
		if (!membership.isPresent()) {
			throw new NotFoundException("membership not found");
		} else {
			membershipObject = membership.get();
			CodeQR.generateImageQRCode(membershipObject.getQRCodeMem(), 250, 250, imagePath);
			membershipObject.add(linkTo(methodOn(MembershipController.class).findAll()).withSelfRel());
		}
		return new ResponseEntity<>(membershipObject, HttpStatus.OK);
	}

	public ResponseEntity<Collection<Membership>> findAll() {
		log.info("MembershipController - findAll");
		Collection<Membership> memberships = membershipService.findAll();
		List<Membership> response = new ArrayList<>();
		memberships.forEach(membership -> {
			membership.add(linkTo(methodOn(MembershipController.class).findById(membership.getIdMem())).withSelfRel());
			response.add(membership);
		});
		return new ResponseEntity<>(response, HttpStatus.OK);
	}


	public ResponseEntity<Membership> findById(Long idMem) {
		log.info("MembershipController - findById");
		Membership membershipObject = null;
		Optional<Membership> membership = membershipService.findById(idMem);
		if (!membership.isPresent()) {
			throw new NotFoundException("Membership not found");
		} else {
			membershipObject = membership.get();
			membershipObject.add(linkTo(methodOn(MembershipController.class).findAll()).withSelfRel());
		}
		return new ResponseEntity<>(membershipObject, HttpStatus.OK);
	}

	//@PostMapping("/addMembership2")
	public ResponseEntity<Membership> save(Membership membership) {
		log.info("MembershipResourceImpl - save");
		if (membership.getIdMem() != null) {
			throw new ApplicationException("Membership ID found, ID is not required for save the data");
		} else {
			Membership savedMembership = membershipService.saveOrUpdate(membership);
			savedMembership.add(linkTo(methodOn(MembershipController.class).findById(savedMembership.getIdMem())).withSelfRel());
			savedMembership.add(linkTo(methodOn(MembershipController.class).findAll()).withSelfRel());
			return new ResponseEntity<>(savedMembership, HttpStatus.CREATED);
		}
	}


}
