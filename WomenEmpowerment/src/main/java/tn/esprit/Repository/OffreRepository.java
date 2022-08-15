package tn.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Entity.Offre;

import java.util.List;

@Repository
public interface OffreRepository extends JpaRepository<Offre,Integer> {
    List<Offre> findBySalaryEquals(Float Salary);

    List<Offre> findBySalaryIsGreaterThanEqual(Float salary);

    List<Offre> findBySalaryLessThan(Float salary);
}
