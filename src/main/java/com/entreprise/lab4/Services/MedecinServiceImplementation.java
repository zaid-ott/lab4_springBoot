package com.entreprise.lab4.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entreprise.lab4.DAO.MedecinDAO;
import com.entreprise.lab4.Models.Medecin;


@Service
public class MedecinServiceImplementation implements MedecinService {

	
	@Autowired
	private MedecinDAO medecindao;
	
	@Override
	public List<Medecin> getMedecins() {
		List<Medecin> MEDECINS = (List<Medecin>) medecindao.findAll();
		if(!MEDECINS.isEmpty()) {
			return MEDECINS;
		}else {
			return null;
		}
	}

	@Override
	public Medecin saveMedecin(Medecin medecin) {
		return medecindao.save(medecin);
	}

	@Override
	public Medecin getMedecinById(Long id) {
Optional<Medecin> retrievedMedecin=medecindao.findById(id);
		
		if (retrievedMedecin.isPresent()) {
			return retrievedMedecin.get();
		}else {
		return null;
		}
	}

	@Override
	public Medecin updateMedecin(Long id, Medecin medecin) {
		Optional<Medecin> retrievedMedecin=medecindao.findById(id);
		
		Medecin _medecin= retrievedMedecin.get();
		_medecin.setAddress(medecin.getAddress());
		_medecin.setBirthday(medecin.getBirthday());
		_medecin.setEmail(medecin.getEmail());
		_medecin.setFirstName(medecin.getFirstName());
		_medecin.setLastName(medecin.getLastName());
		_medecin.setPhone(medecin.getPhone());

		medecindao.save(_medecin);
		return _medecin;
	}

	@Override
	public void deleteById(Long id) {
		medecindao.deleteById(id);
		
	}

	
	
}
