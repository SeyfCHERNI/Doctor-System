package tn.esprit.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.Entity.Candidat;
import tn.esprit.Entity.Cv;
import tn.esprit.Repository.CandidatRepository;
import tn.esprit.Repository.CvRepository;
import tn.esprit.Repository.OffreRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CandidatService {

    @Autowired
    private CandidatRepository candidatRepository;
    @Autowired
    private CvRepository cvRepository ;

    @Autowired
    private OffreRepository offreRepository;

    @Autowired
    private OffreService offreService;

    // Create candidat
    public Candidat addCondidat(Candidat candidat){
        return candidatRepository.save(candidat);
    }
    //delete Candidat by Id
    public void deleteCondidat(Long condidatId){
        candidatRepository.deleteById(condidatId);
    }

    // get all candidats
    public List<Candidat> retrieveAllCondidats(){
        return candidatRepository.findAll();
    }

    // get condidat by id
    public Optional<Candidat> getCondidatById(Long id){
        return candidatRepository.findById(id);
    }

    //filter candidats with status
    public List<Candidat> getCondidatByStatus(String status){
        return candidatRepository.findByStatusEquals(status);
    }

    public Cv addCv(MultipartFile file) throws IOException {
        String nameCv = StringUtils.cleanPath(file.getOriginalFilename());
        Cv Cv = new Cv(nameCv, file.getContentType(), file.getBytes());

        return cvRepository.save(Cv);
    }


}
