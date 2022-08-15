package tn.esprit.Entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

@Table (name = "USER")
public class User implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	protected int idUser ;
	protected String username ;
	protected String lastNameUser ;
	protected String cinUser ;
	protected String password ;
	protected String confirmPasswordUser ;
	protected boolean stateUser ;
	protected String phoneNumberUser ;
	protected String adressUser ;
	@Temporal (TemporalType.DATE)
	protected Date birthDateUser ;
	protected String emailUser ;
	@Enumerated (EnumType.STRING)
	protected SexeType sexeUser ;
	protected boolean accountNonLocked;
	@Column(name = "failedAttempt", columnDefinition = "int default 0")
	protected int failedAttempt;
	@Column(name = "lockTime")
	protected Date lockTime;
	@Column(name = "resettoken")
	protected String resetPasswordToken;
	protected boolean isBlocked;
	protected LocalDate blockDate;
	protected LocalDate unBlockDate;
	protected boolean isPrivate;
	protected float salaire;
	protected int pointnumber;
	protected boolean avilaibility;
	@Enumerated(EnumType.STRING)
	private ZoneMap zone;
	@Enumerated(EnumType.STRING)
	private Role role;
	private String fileName;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")

	private List<Claim> claims;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")

	private List<Appointement> Appointements;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user")

	private Membership membership;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Comment> comments;



	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Publicity> publicitys;
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "users")
	private List<CharityEvent> charityEvents;
	@OneToMany(cascade = CascadeType.ALL)
	private Set<ImageUser> ImageUser1;

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLastNameUser() {
		return lastNameUser;
	}

	public void setLastNameUser(String lastNameUser) {
		this.lastNameUser = lastNameUser;
	}

	public String getCinUser() {
		return cinUser;
	}

	public void setCinUser(String cinUser) {
		this.cinUser = cinUser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPasswordUser() {
		return confirmPasswordUser;
	}

	public void setConfirmPasswordUser(String confirmPasswordUser) {
		this.confirmPasswordUser = confirmPasswordUser;
	}

	public boolean isStateUser() {
		return stateUser;
	}

	public void setStateUser(boolean stateUser) {
		this.stateUser = stateUser;
	}

	public String getPhoneNumberUser() {
		return phoneNumberUser;
	}

	public void setPhoneNumberUser(String phoneNumberUser) {
		this.phoneNumberUser = phoneNumberUser;
	}

	public String getAdressUser() {
		return adressUser;
	}

	public void setAdressUser(String adressUser) {
		this.adressUser = adressUser;
	}

	public Date getBirthDateUser() {
		return birthDateUser;
	}

	public void setBirthDateUser(Date birthDateUser) {
		this.birthDateUser = birthDateUser;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public SexeType getSexeUser() {
		return sexeUser;
	}

	public void setSexeUser(SexeType sexeUser) {
		this.sexeUser = sexeUser;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public int getFailedAttempt() {
		return failedAttempt;
	}

	public void setFailedAttempt(int failedAttempt) {
		this.failedAttempt = failedAttempt;
	}

	public Date getLockTime() {
		return lockTime;
	}

	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}

	public String getResetPasswordToken() {
		return resetPasswordToken;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean blocked) {
		isBlocked = blocked;
	}

	public LocalDate getBlockDate() {
		return blockDate;
	}

	public void setBlockDate(LocalDate blockDate) {
		this.blockDate = blockDate;
	}

	public LocalDate getUnBlockDate() {
		return unBlockDate;
	}

	public void setUnBlockDate(LocalDate unBlockDate) {
		this.unBlockDate = unBlockDate;
	}

	public boolean isPrivate() {
		return isPrivate;
	}

	public void setPrivate(boolean aPrivate) {
		isPrivate = aPrivate;
	}

	public float getSalaire() {
		return salaire;
	}

	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}

	public int getPointnumber() {
		return pointnumber;
	}

	public void setPointnumber(int pointnumber) {
		this.pointnumber = pointnumber;
	}

	public boolean isAvilaibility() {
		return avilaibility;
	}

	public void setAvilaibility(boolean avilaibility) {
		this.avilaibility = avilaibility;
	}

	public ZoneMap getZone() {
		return zone;
	}

	public void setZone(ZoneMap zone) {
		this.zone = zone;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<Claim> getClaims() {
		return claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

	public List<Appointement> getAppointements() {
		return Appointements;
	}

	public void setAppointements(List<Appointement> appointements) {
		Appointements = appointements;
	}

	public Membership getMembership() {
		return membership;
	}

	public void setMembership(Membership membership) {
		this.membership = membership;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Publicity> getPublicitys() {
		return publicitys;
	}

	public void setPublicitys(List<Publicity> publicitys) {
		this.publicitys = publicitys;
	}

	public List<CharityEvent> getCharityEvents() {
		return charityEvents;
	}

	public void setCharityEvents(List<CharityEvent> charityEvents) {
		this.charityEvents = charityEvents;
	}

	public Set<ImageUser> getImageUser1() {
		return ImageUser1;
	}

	public void setImageUser1(Set<ImageUser> imageUser1) {
		ImageUser1 = imageUser1;
	}

	public User() {
	}

	public User(int idUser, String username, String lastNameUser, String cinUser, String password, String confirmPasswordUser, boolean stateUser, String phoneNumberUser, String adressUser, Date birthDateUser, String emailUser, SexeType sexeUser, boolean accountNonLocked, int failedAttempt, Date lockTime, String resetPasswordToken, boolean isBlocked, LocalDate blockDate, LocalDate unBlockDate, boolean isPrivate, float salaire, int pointnumber, boolean avilaibility, ZoneMap zone, Role role, String fileName, List<Claim> claims, List<Appointement> appointements, Membership membership, List<Comment> comments, List<Publicity> publicitys, List<CharityEvent> charityEvents, Set<ImageUser> imageUser1) {
		this.idUser = idUser;
		this.username = username;
		this.lastNameUser = lastNameUser;
		this.cinUser = cinUser;
		this.password = password;
		this.confirmPasswordUser = confirmPasswordUser;
		this.stateUser = stateUser;
		this.phoneNumberUser = phoneNumberUser;
		this.adressUser = adressUser;
		this.birthDateUser = birthDateUser;
		this.emailUser = emailUser;
		this.sexeUser = sexeUser;
		this.accountNonLocked = accountNonLocked;
		this.failedAttempt = failedAttempt;
		this.lockTime = lockTime;
		this.resetPasswordToken = resetPasswordToken;
		this.isBlocked = isBlocked;
		this.blockDate = blockDate;
		this.unBlockDate = unBlockDate;
		this.isPrivate = isPrivate;
		this.salaire = salaire;
		this.pointnumber = pointnumber;
		this.avilaibility = avilaibility;
		this.zone = zone;
		this.role = role;
		this.fileName = fileName;
		//this.claims = claims;
		//Appointements = appointements;
		//this.membership = membership;
		//this.comments = comments;
		//this.publicitys = publicitys;
		//this.charityEvents = charityEvents;
		//ImageUser1 = imageUser1;
	}

	public User(String username, String lastNameUser, String cinUser, String password, String confirmPasswordUser, boolean stateUser, String phoneNumberUser, String adressUser, String emailUser, SexeType sexeUser, boolean accountNonLocked, int failedAttempt, boolean isBlocked, boolean isPrivate, boolean avilaibility, ZoneMap zone, Role role) {
		this.username = username;
		this.lastNameUser = lastNameUser;
		this.cinUser = cinUser;
		this.password = password;
		this.confirmPasswordUser = confirmPasswordUser;
		this.stateUser = stateUser;
		this.phoneNumberUser = phoneNumberUser;
		this.adressUser = adressUser;
		this.emailUser = emailUser;
		this.sexeUser = sexeUser;
		this.accountNonLocked = accountNonLocked;
		this.failedAttempt = failedAttempt;
		this.isBlocked = isBlocked;
		this.isPrivate = isPrivate;
		this.avilaibility = avilaibility;
		this.zone = zone;
		this.role = role;
	}

	public User(String email, String password) {
		this.password = password;
		this.emailUser = email;
	}
}