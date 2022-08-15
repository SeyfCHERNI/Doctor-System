package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Entity.Cv;


@Repository
public interface CvRepository extends CrudRepository <Cv,Integer>{

}
