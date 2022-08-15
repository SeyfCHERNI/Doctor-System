package tn.esprit.Repository;

import tn.esprit.Entity.Resource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends CrudRepository <Resource, Long> {
}