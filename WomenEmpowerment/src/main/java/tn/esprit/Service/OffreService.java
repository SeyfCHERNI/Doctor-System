package tn.esprit.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Entity.Offre;
import tn.esprit.Repository.OffreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OffreService {
	
	  @Autowired
	  private OffreRepository offreRepository;
	  

	  // Create job offre
	  public Offre createJobOffre(Offre offre){
		 return offreRepository.save(offre);
	  }
	  
	  //delete job offre by 
	  public void deleteJobOffre(Integer joboffreId){
			  offreRepository.deleteById(joboffreId);
		  }


	// get job offres
	public List<Offre> retrieveJoboffres(){
		  return offreRepository.findAll();
	}

	public Optional<Offre> getJobofferById(Integer id){
		  return offreRepository.findById(id);
	}


	// salary equal
	public List<Offre> filterSalaryEqual(Float salary){
		return offreRepository.findBySalaryEquals(salary);
	}

	//greater then salary
	public List<Offre> filterGreaterThanSalary(Float salary){
		return offreRepository.findBySalaryIsGreaterThanEqual(salary);
	}

	// less then salary
	public List<Offre> filterLessThanSalary(Float salary){
		return offreRepository.findBySalaryLessThan(salary);
	}

	// Filtrage des candidatures
	public void filterCandidat( Long id) {

	}

}
