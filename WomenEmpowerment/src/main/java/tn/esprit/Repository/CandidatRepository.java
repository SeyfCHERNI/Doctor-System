package tn.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Entity.Candidat;

import java.util.List;

@Repository
public interface CandidatRepository extends JpaRepository<Candidat, Long> {
    List<Candidat> findByStatusEquals(String status);


}
