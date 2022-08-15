package tn.esprit.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Id
	 
	
	private int IdApp;
	
	@Temporal(TemporalType.DATE)
	private Date DateApp ;
	
	private int UserNumApp;
	
	private String DescriptionApp ;
	@JsonIgnore
	@ManyToOne
	User user;
	
}
