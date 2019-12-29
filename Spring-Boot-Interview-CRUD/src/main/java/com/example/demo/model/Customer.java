package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // bu datanın db de ıd oldugunu otomatik arttırıldıgını burada belirledik
	public long id;

	@Column(name = "firstname") // bu degiskenin db de firstname ismini almasını istedik
	public String firstName;

	@Column(name = "lastname")// bu degiskenin db de lastname ismini almasını istedik
	public String lastName;
	
	@Column(name = "aGe" ) // bu degiskenin db de aGe ismini almasını istedik
	private Integer age;
	 


	@Column(name = "eMail") // bu degiskenin db de eMail ismini almasını istedik
	private String email;
	   
	public Customer() {
	}
//constructor
	public Customer(long id, String firstName, String lastName,int age,String email ) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age=age;
		this.email=email;
	}

	public Customer(String firstName, String lastName,int age,String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age=age;
		this.email=email;
	}
//getter setter methodlarını olusturduk
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	public Integer getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return String.format("Customer[id=%d, firstName='%s', lastName='%s',age=%d, email='%s']", id, firstName, lastName,age,email);
	}
	
}
