package tn.esprit.Service;

import tn.esprit.Entity.Membership;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface IMembershipService {
     List<Membership> getMemberships();
     Membership getMembershipById(Long idMem);
     Membership addMembership (Membership membership);
     Membership updateMembership (Membership membership);
     void  deleteMembership (Long idMem);
      Collection<Membership> findAll() ;
      Optional<Membership> findById(Long id);
     Membership saveOrUpdate(Membership membership);
    public Membership addMembership2(Membership membership, Integer idUser);



}
