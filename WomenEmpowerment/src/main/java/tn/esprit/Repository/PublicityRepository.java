package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.Entity.Publicity;

import java.util.List;

public interface PublicityRepository extends CrudRepository<Publicity, Integer> {
	public Publicity findByNamePublicity(String name);
	public List<Publicity> findAllByNamePublicity(String name);
}
