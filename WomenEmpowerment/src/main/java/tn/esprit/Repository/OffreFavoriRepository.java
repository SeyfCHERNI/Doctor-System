package tn.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Entity.OffreFavori;

@Repository
public interface OffreFavoriRepository extends JpaRepository<OffreFavori,Long> {
}
