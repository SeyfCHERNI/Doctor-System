package tn.esprit.Service;

import org.springframework.http.ResponseEntity;
import tn.esprit.Entity.Role;
import tn.esprit.Entity.SexeType;
import tn.esprit.Entity.User;
import tn.esprit.Exception.UserNotFoundException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IUserService {

	public boolean existsEmail(String emailUser);


	public User getByEmail(String emailUser);
	void save(User user);
	User saveUser(User user);
	ResponseEntity<?> addUser(User user);
	
	ResponseEntity<?> ajouterUser(User user);

	User updateUser(User user) throws Exception;

	boolean deleteUser(int idUser);

	User retrieveUserById(int idUser);
	
	List<User> retrieveAllUsers();
	
	List<User> retrieveUserByPoint(int pointNumber);

	User retrieveUserByUsername(String username);

	List<User> retrieveUserByState(boolean stateUser);

	List<User> retrieveUserByAdress(String adressUser);

	List<User> retrieveUserByDate(Date birthDateUser);

	List<User> retrieveUserBySexe(SexeType sexeUser);
	
	User findBymail(String emailUser);
	
	List<User> retrieveUserBysalary(float salaire);

	List<User> findByRole(Role role);
	
	public User activateUser (User user) throws Exception;
	
	public User desactivateUser (User user) throws Exception;

	long retrieveUserByCount();
	
	public List<String> findUsersActivated() throws Exception;	
	
	public List<String> getUsersFromDisabled();
	
	public void increaseFailedAttempts(User user);
	
	boolean unlockWhenTimeExpired(User user);
	
	void resetFailedAttempts(String emailUser);
	
	void lock(User user);
	
	//public User findUserByResetToken(String token);

	void updateResettoken(String token, String emailUser) throws UserNotFoundException;

	User get(String resettoken);

	//void updatePassword(User user, String newPassword);

	User getByResetPasswordToken(String token);

	void forgotpass(String emailuser);

	

	void updatePassword(String emailUser, String newPassword, String confirmPassword);


}
