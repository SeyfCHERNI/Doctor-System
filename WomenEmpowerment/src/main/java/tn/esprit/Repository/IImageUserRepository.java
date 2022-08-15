package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Entity.ImageUser;

@Repository
public interface IImageUserRepository extends CrudRepository <ImageUser,Integer>{

}
