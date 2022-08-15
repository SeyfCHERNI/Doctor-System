package tn.esprit.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.Entity.Role;
import tn.esprit.Entity.SexeType;
import tn.esprit.Entity.User;

import java.util.Date;
import java.util.List;


@Repository
public interface IUserRepository extends CrudRepository<User, Integer>{
	
	List<User> findByPointnumber(int pointNumber);
	
	User findByUsername(String username);
	
	List<User> findByStateUser(boolean stateUser);
	
	List<User> findByAdressUser(String adressUser);
	
	List<User> findByBirthDateUser(Date birthDateUser);
	
	List<User> findBySexeUser(SexeType sexeUser);
	
	List<User> findBySalaireGreaterThan (float salaire);
	
	List<User> findBySalaireLessThan (float salaire);
	
	long  count();
	
    public User findByResetPasswordToken(String token);
	
	//User findUserByresettoken(String login);
	
	User findByEmailUser(String emailUser);

	List<User> findByRole(Role role);
	Boolean existsByEmailUser(String emailUser);
	
	@Query("SELECT AVG(u.salaire) from User u")
	float retrievemoysalaire();

	@Query("SELECT COUNT(u.salaire)*AVG(u.salaire) from User u")
	float retrievesommesalaire();
	
	@Query("SELECT MAX(u.salaire) from User u")
	float retrievemaxsalaire();
	
	@Query("SELECT u.role FROM User u where  u.idUser =:id")
	public String getUserRole(@Param("id")int id);
	
	@Query("SELECT CONCAT(u.username,CONCAT(' ',u.lastNameUser)) FROM User u where  u.stateUser =TRUE")
	public List<String> getUsersFromActivated();
	
	@Query("SELECT CONCAT(u.username,CONCAT(' ',u.lastNameUser)) FROM User u where  u.stateUser =FALSE")
	public List<String> getUsersFromDisabled();
	
	@Query("Select u FROM User u where u.role= :role")
	List<User> findAllByRole(@Param("role") User user);

	@Query("SELECT e.username,e.emailUser FROM User e")
	List<String> getAllClientNames();
	
	@Query("SELECT e.phoneNumberUser,e.adressUser FROM User e GROUP BY e.adressUser")
	List<String> getphonegroupbyadress();
	
	@Query("SELECT MAX(e.birthDateUser) FROM User e ")
	Date getminage(); 
     

}
