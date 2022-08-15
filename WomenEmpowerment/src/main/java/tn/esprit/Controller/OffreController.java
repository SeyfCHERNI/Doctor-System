package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entity.Candidat;
import tn.esprit.Entity.Offre;

import tn.esprit.Repository.CandidatRepository;
import tn.esprit.Repository.OffreRepository;
import tn.esprit.Service.OffreService;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/Offers")
public class OffreController {
	
	 @Autowired
	 private OffreService offreService;

	@Autowired
	private OffreRepository offreRepository;

	@Autowired
	private CandidatRepository candidatRepository;

	 // create
	  @PostMapping(value = "/CreateJoboffre")
	  //@RequestMapping(value = "/CreateJoboffre", method = RequestMethod.POST)
	  public Offre saveJoboffre(@RequestBody Offre offre) {
	    return offreService.createJobOffre(offre);
	  }

	  //delete
	  @RequestMapping(value = "/deleteJoboffre", method = RequestMethod.DELETE)
	  public void deleteJoboffre(@RequestParam(name = "jobOffreId") final Integer id) {
	     offreService.deleteJobOffre(id);
	  }

	  //update
	@RequestMapping(value = "/updateJoboffre", method = RequestMethod.PUT)
	Offre replaceJobOffre(@RequestBody Offre newJoboffre, @RequestParam(name = "jobOffreId") final Integer id) {

		return offreRepository.findById(id)
				.map(jobOffre -> {
					jobOffre.setTitleOffre(newJoboffre.getTitleOffre());
					jobOffre.setSalary(newJoboffre.getSalary());
					jobOffre.setOffreDescription(newJoboffre.getOffreDescription());
					return offreRepository.save(jobOffre);
				})
				.orElseGet(() -> {
					return offreRepository.save(newJoboffre);
				});
	}

	//get job offres
	@RequestMapping(value = "/jobOffers", method = RequestMethod.GET)
	public List<Offre> retrieveJobOffers() {
		return offreService.retrieveJoboffres();
	}

	//get job offre by id
	@RequestMapping(value = "/jobOffer", method = RequestMethod.GET)
	public Offre retrieveJobOfferById(@RequestParam(name = "jobOffreId") final Integer id) {
		return offreService.getJobofferById(id).orElse(null);
	}

	//filter salary
	@RequestMapping(value = "/jobOfferBySalaryEqual", method = RequestMethod.GET)
	public List<Offre> retrieveJobOfferBySalaryEqual(@RequestParam(name = "salary") final Float salary) {
		return offreService.filterSalaryEqual(salary);
	}

	//filter greater salary
	@RequestMapping(value = "/jobOfferBySalaryGreater", method = RequestMethod.GET)
	public List<Offre> retrieveJobOfferBySalaryGreater(@RequestParam(name = "salary") final Float salary) {
		return offreService.filterGreaterThanSalary(salary);
	}

	//filter less salary
	@RequestMapping(value = "/jobOfferBySalaryLess", method = RequestMethod.GET)
	public List<Offre> retrieveJobOfferBySalaryLess(@RequestParam(name = "salary") final Float salary) {
		return offreService.filterLessThanSalary(salary);
	}

	// Filtrage des candidatures
	@RequestMapping(value = "/filterCondidat", method = RequestMethod.PUT)
	public Candidat updateCondidat(
			@RequestParam(name = "idCondidat") final Long idCondidat,
			@RequestParam(name = "status") final String status) {

		  Candidat con = candidatRepository.findById(idCondidat).orElse(null);
		assert con != null;
		con.setStatus(status);
		  return candidatRepository.save(con);
	}


}
