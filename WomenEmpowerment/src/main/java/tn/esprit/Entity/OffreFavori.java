package tn.esprit.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OffreFavori {
    @Id
    @Column(name = "offre_favori_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offreFavoriId;
    @ManyToOne
    @JoinColumn(name = "condidat_id")
    private Candidat user;
    @ManyToOne
    @JoinColumn(name = "offre_id")
    private Offre offre;


}
