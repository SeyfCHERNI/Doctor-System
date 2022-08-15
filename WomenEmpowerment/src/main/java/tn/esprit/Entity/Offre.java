package tn.esprit.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Offre implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "offre_id", nullable = false)
	private Integer offreId;
	private String titleOffre ;
	private Float salary ;
	private String offreDescription ;

	@JsonIgnore
	@OneToMany( mappedBy= "offre")
	private List <Candidat> candidats;

}
