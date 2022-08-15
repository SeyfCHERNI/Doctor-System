package tn.esprit.Service;

import tn.esprit.Entity.Subject;

import java.util.List;
import java.util.Optional;


public interface ISubjectService {
	
	String addSubject(Subject s);

	Subject updateSubject(Subject s);

	boolean deleteSubject(int id);

	Optional<Subject> retrieveSubjectById(int id);
	
	List<Subject> retrieveAllSubject();

	List<Subject> retrieveSubjectByTitle(String titleSubject);

	List<Subject> retrieveSubjectByStars(float starsNumberSubject);

	List<Subject> retrieveSubjectByStarsless(float starsNumberSubject);

}
