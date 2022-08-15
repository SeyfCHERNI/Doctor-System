package tn.esprit.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import org.springframework.hateoas.RepresentationModel;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Membership extends RepresentationModel<Membership> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMem;
    private String nameMem;
    private String DescriptionMem;
    private Date StartDateMem;
    private String DurationMem;
    private String QRCodeMem ;
    private byte[] base64QRCode;

    @JsonIgnore
    @OneToOne
    private User user;

}
