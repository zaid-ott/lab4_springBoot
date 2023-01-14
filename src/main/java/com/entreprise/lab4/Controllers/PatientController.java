package com.entreprise.lab4.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entreprise.lab4.Models.Patient;
import com.entreprise.lab4.Services.PatientService;


@RestController
@RequestMapping(path ="/hopital/patients")
public class PatientController {

	@Autowired
	private PatientService patientservice;
	
	@GetMapping(path="/welcome")
	public String hello(){
		return "helloworld";
	}
	
	@GetMapping(path ="/")
	public ResponseEntity<List<Patient>> getPatients(){
		try {
			List<Patient> patients = patientservice.getPatients();
			return new ResponseEntity<>(patients, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path="/")
	public ResponseEntity<Patient> savePatient(@RequestBody Patient patient){
		try {
			Patient _patient=patientservice.savePatient(patient);
			return new ResponseEntity<>(_patient, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(path="/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
		try {
			if(patientservice.getPatientById(id)!=null) {
				return new ResponseEntity<Patient>(patientservice.getPatientById(id), HttpStatus.OK);
			} 
			return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping(path="/{id}")
	public Patient updatePatient(@PathVariable Long id,@RequestBody Patient patient) {
		return patientservice.updatePatient(id, patient);
	}
	
	
	@DeleteMapping(path="/{id}")
	 public void deleteById(@PathVariable Long id) {
		patientservice.deleteById(id);
	 }
	
}
