package tn.esprit.Service;

import tn.esprit.Entity.Cagnotte;

import java.util.List;
import java.util.Optional;



public interface ICagnotteService {
	
	Cagnotte addCagnotte(Cagnotte c);

	List<Cagnotte> getAllCagnotte();

	void deleteCagnotte(int idCagnotte);

	Cagnotte updateCagnotte(Cagnotte c);

	Optional<Cagnotte> getCagnotte_by_ID(int idCagnotte);

}
