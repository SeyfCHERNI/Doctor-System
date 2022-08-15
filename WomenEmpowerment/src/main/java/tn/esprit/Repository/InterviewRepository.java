package tn.esprit.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Entity.Interview;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Long> {
}
