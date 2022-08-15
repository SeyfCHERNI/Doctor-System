package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.Entity.Candidat;
import tn.esprit.Repository.CandidatRepository;
import tn.esprit.Response.ResponseMessage;
import tn.esprit.Service.CandidatService;

import java.util.List;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/Condidats")
public class CandidatController {

    @Autowired
    private CandidatService candidatService;

    @Autowired
    private CandidatRepository candidatRepository;

    // create
    @RequestMapping(value = "/CreateCondidat", method = RequestMethod.POST)
    public Candidat saveCondidat(@RequestBody Candidat candidat) {
        return candidatService.addCondidat(candidat);
    }


    //delete
    @RequestMapping(value = "/deleteCondidat", method = RequestMethod.DELETE)
    public void deleteCondidat(@RequestParam(name = "condidatId") final Long id) {
        candidatService.deleteCondidat(id);
    }

    //update
    @RequestMapping(value = "/updateCondidat", method = RequestMethod.PUT)
    Candidat updateCondidat(@RequestBody Candidat newCandidat, @RequestParam(name = "condidatId") final Long id) {

        return candidatRepository.findById(id)
                .map(condidat -> {
                    condidat.setUsername(newCandidat.getUsername());
                    condidat.setLastName(newCandidat.getLastName());
                    condidat.setPhoneNumber(newCandidat.getPhoneNumber());
                    condidat.setEmail(newCandidat.getEmail());
                    condidat.setPassword(newCandidat.getPassword());
                    condidat.setGender(newCandidat.getGender());
                    condidat.setImage(newCandidat.getImage());
                    condidat.setBirthDate(newCandidat.getBirthDate());
                    condidat.setAdress(newCandidat.getAdress());
                    condidat.setStatus(newCandidat.getStatus());

                    return candidatRepository.save(condidat);
                })
                .orElseGet(() -> {
                    return candidatRepository.save(newCandidat);
                });
    }

    //get all candidats
    @RequestMapping(value = "/condidats", method = RequestMethod.GET)
    public List<Candidat> getAllCondidats() {
        return candidatService.retrieveAllCondidats();
    }

    // get condidat by id
    @RequestMapping(value = "/condidat", method = RequestMethod.GET)
    public Candidat retrieveCondidatById(@RequestParam(name = "condidatId") final Long id) {
        return candidatService.getCondidatById(id).orElse(null);
    }

    // apply for job offer
    @RequestMapping(value = "/applyForJobOffer", method = RequestMethod.POST)
    public void applyForJobOffer(@RequestBody Candidat candidat)
    {
        candidatService.addCondidat(candidat);
    }

    //filter candidats with status
    @RequestMapping(value = "/filterCondidatStatus", method = RequestMethod.GET)
    public List<Candidat> filterCondidatWithStatus(@RequestParam(name = "status") final String status)
    {
        return candidatService.getCondidatByStatus(status);
    }

    @PostMapping("/uploadedCv")
    public ResponseEntity<ResponseMessage> uploadCV(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            candidatService.addCv(file);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        }catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }




}
