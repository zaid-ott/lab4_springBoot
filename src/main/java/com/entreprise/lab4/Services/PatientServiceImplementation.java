package com.entreprise.lab4.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entreprise.lab4.DAO.PatientDAO;
import com.entreprise.lab4.Models.Patient;

@Service
public class PatientServiceImplementation implements PatientService{

	@Autowired
	private PatientDAO patientdao;
	
	@Override
	public List<Patient> getPatients() {
		List<Patient> PATIENTS = (List<Patient>) patientdao.findAll();
		if(!PATIENTS.isEmpty()) {
			return PATIENTS;
		}else {
			return null;
		}
	}

	@Override
	public Patient savePatient(Patient patient) {
		return patientdao.save(patient);
	}

	@Override
	public Patient getPatientById(Long id ) {
		Optional<Patient> retrievedPatient=patientdao.findById(id);
		
		if (retrievedPatient.isPresent()) {
			return retrievedPatient.get();
		}else {
		return null;
		}
	}

	@Override
	public Patient updatePatient(Long id, Patient patient) {
		Optional<Patient> retrievedPatient=patientdao.findById(id);
		
		Patient _patient= retrievedPatient.get();
		_patient.setAddress(patient.getAddress());
		_patient.setBirthday(patient.getBirthday());
		_patient.setEmail(patient.getEmail());
		_patient.setFirstName(patient.getFirstName());
		_patient.setLastName(patient.getLastName());
		_patient.setPhone(patient.getPhone());

		patientdao.save(_patient);
		return _patient;
	}

	@Override
	public void deleteById(Long id) {
		patientdao.deleteById(id);
		
	}
}
