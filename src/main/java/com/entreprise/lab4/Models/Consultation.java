package com.entreprise.lab4.Models;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@Table(name="Consultation")
public class Consultation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="facture")
	private String facture; // ici on va stocker le num de ref correspondant à la facture
	
	@Column(name="ordonance")
	private String ordonance;//pareil que la facture
	
	@OneToOne (cascade = CascadeType.MERGE)
	@JoinColumn(name="id_rdv")
	private Rdv rdv;

	
}
