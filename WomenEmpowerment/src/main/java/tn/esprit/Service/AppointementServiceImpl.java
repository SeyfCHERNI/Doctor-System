package tn.esprit.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Entity.Appointement;
import tn.esprit.Repository.AppointementRepository;

import java.util.List;
@Service
public class AppointementServiceImpl implements AppointementService{

	@Autowired
	AppointementRepository AppointementRepository;
	
	@Override
	public Appointement addAppointement(Appointement A) {
		return AppointementRepository.save(A);

	}

	@Override
	public void deleteAppointement(int id) {
		AppointementRepository.deleteById(id);
		
	}

	@Override
	public Appointement updateAppointement(Appointement A) {
		return AppointementRepository.save(A);
	}

	@Override
	public Appointement retrieveAppointement(int id) {
		return AppointementRepository.findById(id).orElse(null);
	}

	@Override
	public List<Appointement> retrieveAllAppointements() {
		return (List<Appointement>) AppointementRepository.findAll();
	}

	@Override
	public void affectationAppointementByUser(int idApp, int idUser) {
		// TODO Auto-generated method stub
		
	}

}
