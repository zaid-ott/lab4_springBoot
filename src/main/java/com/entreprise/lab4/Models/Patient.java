package com.entreprise.lab4.Models;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="patient")
public class Patient implements Serializable{

	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_patient;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="birthday")
	private Date birthday;
	
	@Column(name="address")
	private String address;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private String phone;
	
	@OneToMany(mappedBy="patient", fetch = FetchType.LAZY)
	private Collection<Rdv> rdvs;
	
	public Patient(Long id, String firstName, String lastName, Date birthday, String address, String email,
			String phone, Collection<Rdv> rdvs) {
		super();
		this.id_patient = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.rdvs = rdvs;
	}

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id_patient;
	}

	public void setId(Long id) {
		this.id_patient = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@JsonIgnore
	public Collection<Rdv> getRdvs() {
		return rdvs;
	}

	public void setRdvs(Collection<Rdv> rdvs) {
		this.rdvs = rdvs;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
