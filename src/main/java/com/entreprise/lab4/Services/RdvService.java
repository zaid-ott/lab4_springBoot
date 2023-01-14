package com.entreprise.lab4.Services;

import java.util.List;

import com.entreprise.lab4.Models.Rdv;

public interface RdvService {

	List <Rdv> getRdvs();
	
	Rdv saveRdv( Rdv rdv);
	
	Rdv getRdvById(Long id);
	
	Rdv updateRdv(Long id, Rdv rdv);
	
	void deleteById(Long id);
}
