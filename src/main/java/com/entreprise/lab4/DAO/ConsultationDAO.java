package com.entreprise.lab4.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entreprise.lab4.Models.Consultation;

@Repository
public interface ConsultationDAO extends CrudRepository<Consultation, Long> {

}
