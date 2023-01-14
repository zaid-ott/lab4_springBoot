package com.entreprise.lab4.Models;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="rdv")
public class Rdv implements Serializable {
	
	private static final long  serialVersionUID=1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_rdv;
	
	@Column(name = "date")
	private LocalDate date;
	
	@Column(name = "address")
	private String address;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	//@JsonIgnore
	@JoinColumn(name="FK_id_patient", referencedColumnName = "id_patient")
	private Patient patient;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	//@JsonIgnore
	@JoinColumn(name="FK_id_medecin", referencedColumnName = "id_medecin")
	private Medecin medecin;
	
	@OneToOne(mappedBy = "rdv", fetch =FetchType.LAZY)
	private Consultation consultation;


	public Rdv(Long id, LocalDate date, String address, Patient patient, Medecin medecin, Consultation consultation) {
		super();
		this.id_rdv = id;
		this.date = date;
		this.address = address;
		this.patient = patient;
		this.medecin = medecin;
		this.consultation = consultation;
	}

	public Rdv() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id_rdv;
	}

	public void setId(Long id) {
		this.id_rdv = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
