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


import com.entreprise.lab4.Models.Rdv;
import com.entreprise.lab4.Services.RdvService;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class RdvControllerTest {
	@InjectMocks
	private RdvController rdvcontroller;
	
	@Mock
	private RdvService rdvservice;
	
	@Test
	public void getRdvs_withoutException() throws Exception{
		//Given 
		List<Rdv> list = new ArrayList<>();
		Rdv rdv1 = new Rdv();
		Rdv rdv2 = new Rdv();
		list.add(rdv1);
		list.add(rdv2);
		//When
		Mockito.when(rdvservice.getRdvs()).thenReturn(list) ;
		ResponseEntity<List<Rdv>> resultat= rdvcontroller.getRdvs();
		//Then
		assertEquals(2, resultat.getBody().size()); 
		assertEquals(HttpStatus.OK, resultat.getStatusCode());
	}
	
	@Test
	public void getPatients_withException() throws Exception{
		when(rdvservice.getRdvs()).thenThrow(new NullPointerException("error occured"));
		//then 
		assertTrue(rdvcontroller.getRdvs().getStatusCode()==HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
