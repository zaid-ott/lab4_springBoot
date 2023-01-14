package com.entreprise.lab4.Services;

import java.util.List;

import com.entreprise.lab4.Models.Medecin;



public interface MedecinService {

	List <Medecin> getMedecins();
		
	Medecin saveMedecin( Medecin medecin);
		
	Medecin getMedecinById(Long id);
		
	Medecin updateMedecin(Long id, Medecin medecin);
	
	void deleteById(Long id);
	
}
