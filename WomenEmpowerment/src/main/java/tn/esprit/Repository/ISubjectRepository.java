package tn.esprit.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Entity.Subject;

import java.util.List;

@Repository
public interface ISubjectRepository extends  CrudRepository <Subject, Integer>{
	
List<Subject> findByTitleSubject(String titleSubject);
	
	List<Subject> findByStarsNumberSubjectGreaterThan(float starsNumberSubject);
	
	List<Subject> findByStarsNumberSubjectLessThan(float starsNumberSubject);

	@Query("SELECT AVG(s.starsNumberSubject) from Subject s")
	float retrievemoySubjectByStars();

	@Query("SELECT MAX(s.starsNumberSubject) from Subject s")
	float retrievemaxSubjectByStars();

	@Query("SELECT MIN(s.starsNumberSubject) from Subject s")
	float retrieveminSubjectByStars();

	@Query("SELECT s FROM Subject s ORDER BY s.starsNumberSubject DESC")
	List<Subject> retrievesuborderbystars();
	
	boolean existsByTitleSubject(String titleSubject);

}
