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

import com.entreprise.lab4.Models.Medecin;
import com.entreprise.lab4.Services.MedecinService;


@RestController
@RequestMapping(path="/hopital/medecins")
public class MedecinController {

	@Autowired
	private MedecinService medecinservice;
	
	@GetMapping(path="/")
	public ResponseEntity<List<Medecin>>getMedecins(){
		try {
			List<Medecin> medecins = medecinservice.getMedecins();
			return new ResponseEntity<>(medecins, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path="/")
	public ResponseEntity<Medecin> saveMedecin(@RequestBody Medecin medecin){
		try {
			Medecin _medecin=medecinservice.saveMedecin(medecin);
			return new ResponseEntity<>(_medecin, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Medecin> getMedecinById(@PathVariable Long id) {
		try {
			if(medecinservice.getMedecinById(id)!=null) {
				return new ResponseEntity<Medecin>(medecinservice.getMedecinById(id), HttpStatus.OK);
			} 
			return new ResponseEntity<Medecin>(HttpStatus.NOT_FOUND);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping(path="/{id}")
	public Medecin updateMedecin(@PathVariable Long id,@RequestBody Medecin medecin) {
		return medecinservice.updateMedecin(id, medecin);
	}
	
	
	@DeleteMapping("/{id}")
	 public void deleteById(@PathVariable Long id) {
		medecinservice.deleteById(id);
	 }
}
