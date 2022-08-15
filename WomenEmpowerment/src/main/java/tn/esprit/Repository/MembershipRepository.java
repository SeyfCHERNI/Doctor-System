package tn.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Entity.Membership;

@Repository
public interface MembershipRepository extends JpaRepository <Membership, Long>{
   // List<Membership> findByIdIn(List<Long> idMem);
   // List<Membership> findMembershipByAppuser_Id(Long idUser);


}
