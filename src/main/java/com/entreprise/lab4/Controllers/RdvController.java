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

import com.entreprise.lab4.Models.Rdv;
import com.entreprise.lab4.Services.RdvService;

@RestController
@RequestMapping("/hopital/rdvs")
public class RdvController {

	@Autowired
	private RdvService rdvservice;
	
	@GetMapping("/")
	public ResponseEntity<List<Rdv>> getRdvs(){
		try {
			List<Rdv> rdvs = rdvservice.getRdvs();
			return new ResponseEntity<>(rdvs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<Rdv> saveRdv(@RequestBody Rdv rdv){
		try {
			Rdv _rdv=rdvservice.saveRdv(rdv);
			return new ResponseEntity<>(_rdv, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(path="/{id}")
	public ResponseEntity<Rdv> getRdvById(@PathVariable Long id) {
		try {
			if(rdvservice.getRdvById(id)!=null) {
				return new ResponseEntity<Rdv>(rdvservice.getRdvById(id), HttpStatus.OK);
			} 
			return new ResponseEntity<Rdv>(HttpStatus.NOT_FOUND);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	

	@PutMapping("/{id}")
	public Rdv updateRdv(@PathVariable Long id,@RequestBody Rdv rdv) {
		return rdvservice.updateRdv(id, rdv);
	}
	
	
	@DeleteMapping("/{id}")
	 public void deleteById(@PathVariable Long id) {
		rdvservice.deleteById(id);
	 }
	

}
