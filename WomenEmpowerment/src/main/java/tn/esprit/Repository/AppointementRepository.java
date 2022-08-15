package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Entity.Appointement;
@Repository
public interface AppointementRepository extends CrudRepository<Appointement, Integer> {

}
