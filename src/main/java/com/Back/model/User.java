package com.Back.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private String lastName ;
	private String firstName ;
	private String emails ;
	private String matrecule ;
	private String company ;
	private String password ;
	private String username ;
	
	
	public User() {
		
	}
	


	public User(int id, String lastName, String firstName, String emails, String matrecule, String company,
			String password) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.emails = emails;
		this.matrecule = matrecule;
		this.company = company;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmails() {
		return emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	public String getMatrecule() {
		return matrecule;
	}

	public void setMatrecule(String matrecule) {
		this.matrecule = matrecule;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}

	
	
}
