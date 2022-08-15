package tn.esprit.Entity;



import javax.persistence.*;
import java.io.Serializable;

@Entity

public class Cagnotte implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int IdCagnotte;
	
	private String NameCagnotte;
	
	private float Amount;

	
	@OneToOne(mappedBy="cagnotte")
	private CharityEvent charityEvent;


	public int getIdCagnotte() {
		return IdCagnotte;
	}


	public void setIdCagnotte(int idCagnotte) {
		IdCagnotte = idCagnotte;
	}


	public String getNameCagnotte() {
		return NameCagnotte;
	}


	public void setNameCagnotte(String nameCagnotte) {
		NameCagnotte = nameCagnotte;
	}


	public float getAmount() {
		return Amount;
	}


	public void setAmount(float amount) {
		Amount = amount;
	}


	public CharityEvent getCharityEvent() {
		return charityEvent;
	}


	public void setCharityEvent(CharityEvent charityEvent) {
		this.charityEvent = charityEvent;
	}


	public Cagnotte(int idCagnotte, String nameCagnotte, float amount, CharityEvent charityEvent) {
		super();
		IdCagnotte = idCagnotte;
		NameCagnotte = nameCagnotte;
		Amount = amount;
		this.charityEvent = charityEvent;
	}


	public Cagnotte() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
