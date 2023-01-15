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

import com.entreprise.lab4.Models.Medecin;
import com.entreprise.lab4.Services.MedecinService;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class MedecinControllerTest {
	
	@InjectMocks
	private MedecinController medecincontroller;
	
	@Mock
	private MedecinService medecinservice;

	@Test
	public void getMedecins_withoutException() throws Exception{
		//Given 
		List<Medecin> list = new ArrayList<>();
		Medecin medecin1 = new Medecin();
		Medecin medecin2 = new Medecin();
		list.add(medecin1);
		list.add(medecin2);
		//When
		Mockito.when(medecinservice.getMedecins()).thenReturn(list) ;
		ResponseEntity<List<Medecin>> resultat= medecincontroller.getMedecins();
		//Then
		assertEquals(2, resultat.getBody().size()); 
		assertEquals(HttpStatus.OK, resultat.getStatusCode());
	}
	@Test
	public void getMedecins_withException() throws Exception{
		when(medecinservice.getMedecins()).thenThrow(new NullPointerException("error occured"));
		//then 
		assertTrue(medecincontroller.getMedecins().getStatusCode()==HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
