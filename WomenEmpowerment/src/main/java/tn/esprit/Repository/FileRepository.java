package tn.esprit.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Entity.FileDB;

import java.util.List;
import java.util.Optional;

@Repository
public interface FileRepository extends CrudRepository<FileDB, Integer>{
public Optional<FileDB> findByName(String name);
public List<FileDB> findAll();

}
