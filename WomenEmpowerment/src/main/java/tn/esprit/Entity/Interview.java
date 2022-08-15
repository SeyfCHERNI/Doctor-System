package tn.esprit.Entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Interview {
    @Id
    @Column(name = "interview_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long InterviewId;
    private Date dateDebut;
    private Date dateFin;
    @ManyToOne
    @JoinColumn(name = "condidat_id")
    private Candidat user;
    @ManyToOne
    @JoinColumn(name = "offre_id")
    private Offre offre;

}
