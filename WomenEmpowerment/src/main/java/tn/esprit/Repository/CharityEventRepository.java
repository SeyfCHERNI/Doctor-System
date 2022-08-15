package tn.esprit.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Entity.CharityEvent;



@Repository
public interface CharityEventRepository extends JpaRepository<CharityEvent , Integer>{

	
	
}