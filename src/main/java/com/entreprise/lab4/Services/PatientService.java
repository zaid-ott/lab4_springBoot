package com.entreprise.lab4.Services;

import java.util.List;

import com.entreprise.lab4.Models.Patient;


public interface PatientService {
	
	List <Patient> getPatients();
	
	Patient savePatient( Patient patient);
	
	Patient getPatientById(Long id);
	
	Patient updatePatient(Long id, Patient patient);
	
	void deleteById(Long id);
	
}
