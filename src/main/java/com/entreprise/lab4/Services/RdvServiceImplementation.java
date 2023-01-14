package com.entreprise.lab4.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entreprise.lab4.DAO.MedecinDAO;
import com.entreprise.lab4.DAO.PatientDAO;
import com.entreprise.lab4.DAO.RdvDAO;
import com.entreprise.lab4.Models.Medecin;
import com.entreprise.lab4.Models.Patient;
import com.entreprise.lab4.Models.Rdv;

@Service
public class RdvServiceImplementation implements RdvService {

	@Autowired
	private RdvDAO rdvdao;
	
//	private PatientDAO patientdao;
//	private MedecinDAO medecindao;
	
	@Override
	public List<Rdv> getRdvs() {
		List<Rdv> RDVS = (List<Rdv>) rdvdao.findAll();
		if(!RDVS.isEmpty()) {
			return RDVS;
		}else {
			return null;
		}
	}

	@Override
	public Rdv saveRdv(Rdv rdv) {
	
//		Optional<Patient> _patient= patientdao.findById(rdv.getPatient().getId());
//		Optional<Medecin> _medecin= medecindao.findById(rdv.getMedecin().getId());
//		if(_patient.isPresent() && (_medecin.isPresent())) {
//			Rdv _rdv = new Rdv();
//			_rdv.setId(rdv.getId());
//			_rdv.setDate(rdv.getDate());
//			_rdv.setAddress(rdv.getAddress());
//			_rdv.setPatient(_patient.get());
//			_rdv.setMedecin(_medecin.get());
//			
//		return rdvdao.save(_rdv);
//		}else {return null;
//		}
		return rdvdao.save(rdv);
	}

	@Override
	public Rdv getRdvById(Long id) {
		Optional<Rdv> retrievedRdv=rdvdao.findById(id);
		if (retrievedRdv.isPresent()) {
			return retrievedRdv.get();
		}else {
		return null;
		}
	}

	@Override
	public Rdv updateRdv(Long id, Rdv rdv) {
		Optional<Rdv> retrievedRdv=rdvdao.findById(id);
		
		Rdv _rdv= retrievedRdv.get();
		_rdv.setDate(rdv.getDate());

		rdvdao.save(_rdv);
		return _rdv;
	}

	@Override
	public void deleteById(Long id) {
		rdvdao.deleteById(id);
		
	}

}
