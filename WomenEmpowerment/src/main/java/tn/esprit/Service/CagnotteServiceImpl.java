package tn.esprit.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Entity.Cagnotte;
import tn.esprit.Repository.CagnotteRepository;

import java.util.List;
import java.util.Optional;







@Service
public class CagnotteServiceImpl implements ICagnotteService {

	@Autowired 
	private CagnotteRepository cagnotteRepository;
	
	
	
	private static final Logger L=LogManager.getLogger(CagnotteServiceImpl.class);
	
	@Override
	public Cagnotte addCagnotte(Cagnotte c) {
		
		return cagnotteRepository.save(c);
		
	}

	@Override
	public List<Cagnotte> getAllCagnotte() {
		return (List<Cagnotte>)cagnotteRepository.findAll();
	}
	
	@Override
	public void deleteCagnotte(int idCagnotte) {
		cagnotteRepository.deleteById(idCagnotte);
		
	}
	
	@Override
	public Cagnotte updateCagnotte(Cagnotte c) {
		
		return cagnotteRepository.save(c);
	}
	
	@Override
	public Optional<Cagnotte> getCagnotte_by_ID(int idCagnotte) {
		return cagnotteRepository.findById(idCagnotte);
	}
}
