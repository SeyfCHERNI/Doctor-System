package tn.esprit.Entity;

import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Candidat implements Serializable   {
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long idCondidat ;
	private  String username ;
	private String lastName ;
	private Integer phoneNumber ;
	private String email ;
	private String password ;
	private String gender ;
	private String image ;
	@Temporal(TemporalType.DATE)
	private Date birthDate ;

	private String adress ;
	private String status = Status.Waiting.toString();
	@ManyToOne (fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name="idOffre",
			insertable = false,
			updatable = false,nullable = true
	)
	private Offre offre;

}
