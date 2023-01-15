package com.entreprise.lab4.Controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.entreprise.lab4.Models.Patient;
import com.entreprise.lab4.Services.PatientService;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class PatientControllerTest {

	@InjectMocks
	private PatientController patientcontroller;
	
	@Mock
	private PatientService patientservice;
	
	@Test
	public void getPatients_withoutException() throws Exception{
		//Given 
		List<Patient> list = new ArrayList<>();
		Patient patient1 = new Patient();
		Patient patient2 = new Patient();
		list.add(patient1);
		list.add(patient2);
		//When
		Mockito.when(patientservice.getPatients()).thenReturn(list) ;
		ResponseEntity<List<Patient>> resultat= patientcontroller.getPatients();
		//Then
		assertEquals(2, resultat.getBody().size()); 
		assertEquals(HttpStatus.OK, resultat.getStatusCode());
	}
	
	@Test
	public void getPatients_withException() throws Exception{
		when(patientservice.getPatients()).thenThrow(new NullPointerException("error occured"));
		//then 
		assertTrue(patientcontroller.getPatients().getStatusCode()==HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
