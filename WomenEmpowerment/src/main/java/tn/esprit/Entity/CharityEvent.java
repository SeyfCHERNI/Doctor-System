package tn.esprit.Entity;


import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity

public class CharityEvent {
	

	//private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int IdEvent;
	
	@Temporal(TemporalType.DATE)
	private Date StartDateEvent  ;
	
	@Temporal(TemporalType.DATE)
	private Date EndDateEvent  ;
	
	private String Location;
	private int Participants;
	private String TitleEvent;
	private Boolean Publicity;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<User> users;
	

	@OneToOne
	private Cagnotte cagnotte;

	public int getIdEvent() {
		return IdEvent;
	}

	public void setIdEvent(int idEvent) {
		IdEvent = idEvent;
	}

	public Date getStartDateEvent() {
		return StartDateEvent;
	}

	public void setStartDateEvent(Date startDateEvent) {
		StartDateEvent = startDateEvent;
	}

	public Date getEndDateEvent() {
		return EndDateEvent;
	}

	public void setEndDateEvent(Date endDateEvent) {
		EndDateEvent = endDateEvent;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public int getParticipants() {
		return Participants;
	}

	public void setParticipants(int participants) {
		Participants = participants;
	}

	public String getTitleEvent() {
		return TitleEvent;
	}

	public void setTitleEvent(String titleEvent) {
		TitleEvent = titleEvent;
	}

	public Boolean getPublicity() {
		return Publicity;
	}

	public void setPublicity(Boolean publicity) {
		Publicity = publicity;
	}

	
	public Cagnotte getCagnotte() {
		return cagnotte;
	}

	public void setCagnotte(Cagnotte cagnotte) {
		this.cagnotte = cagnotte;
	}

	public CharityEvent(int idEvent, Date startDateEvent, Date endDateEvent, String location, int participants,
			String titleEvent, Boolean publicity, Cagnotte cagnotte) {
		super();
		IdEvent = idEvent;
		StartDateEvent = startDateEvent;
		EndDateEvent = endDateEvent;
		Location = location;
		Participants = participants;
		TitleEvent = titleEvent;
		Publicity = publicity;
		this.cagnotte = cagnotte;
	}

	public CharityEvent() {
		super();
		// TODO Auto-generated constructor stub
	}


}
