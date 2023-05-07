package com.Employee.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;

@Entity
@Table(name="emp")
public class Employee implements Serializable{
	
		
		/*
		 * Employee ID ,FirstName LastName ,Email ,PhoneNumber(May have multiple phone
		 * numbers) DOJ Salary(per month)
		 */
		
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="number")
	 private int id;
	 @Column(name="first_name",nullable=false)
	 
	 private String firstname;
	 @Column(name="last_name",nullable=false)
	 private String lastname;
	 @Column(name="email")
	 private String emila;
		/*
		 * @Column(name="Phone_number") private List<String> phoneNumber;
		 */
	 @Column(name="salary",nullable = false)
	 private int salary;

		/*
		 * @OneToOne(cascade=CascadeType.ALL)
		 * 
		 * @JoinColumn(name = "employee_id", referencedColumnName = "address_id")
		 */
	 @OneToOne
	 @JoinColumn(name = "address_id")
		private Address address;
		/*
		 * public Employee(long id, String firstname, String lastname, String emila,
		 * List<String> phoneNumber, int salary) { super(); this.id = id; this.firstname
		 * = firstname; this.lastname = lastname; this.emila = emila; this.phoneNumber =
		 * phoneNumber; this.salary = salary; }
		 */
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	//Without Phone Number
	/*
	 * public Employee(int id, String firstname, String lastname, String emila, int
	 * salary) { super(); this.id = id; this.firstname = firstname; this.lastname =
	 * lastname; this.emila = emila; this.salary = salary; }
	 */
	
	//with join 
	public Employee(int id, String firstname, String lastname, String emila, int salary, Address address) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emila = emila;
		this.salary = salary;
		this.address = address;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmila() {
		return emila;
	}
	public void setEmila(String emila) {
		this.emila = emila;
	}

	/*
	 * public List<String> getPhoneNumber() { return phoneNumber; }
	 * 
	 * public void setPhoneNumber(List<String> phoneNumber) { this.phoneNumber =
	 * phoneNumber; }
	 */

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	 

}
