package tn.esprit.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.Entity.OffreFavori;
import tn.esprit.Service.OffreFavoriService;

@RestController
public class OffreFavoriController {

    @Autowired
    private OffreFavoriService offreFavoriService;

    // create Offre Favori
    @PostMapping(value = "/createOffreFavori")
    public OffreFavori saveJoboffre(@RequestBody OffreFavori offreFavori) {
        return offreFavoriService.addJobOffreFavori(offreFavori);
    }
}
