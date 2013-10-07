package fr.istic.tpjpa.jpa;

import java.beans.Transient;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Person{
	
	public Person(String name, String firstName, String mail, String dob,
			String facebook, List<Person> amis, List<Home> maisons) {
		super();
		this.name = name;
		this.firstName = firstName;
		this.mail = mail;
		this.dob = dob;
		this.facebook = facebook;
		this.amis = amis;
		this.maisons = maisons;
	}
	
	
	private int ID;
	private String name, firstName, mail, dob, facebook;
	

	private List<Person> amis = new ArrayList<Person>();
	private List<Home> maisons = new ArrayList<Home>();
	

	@OneToMany(mappedBy = "maisons", cascade = CascadeType.PERSIST)
	public List<Home> getMaisons() {
		return maisons;
	}

	public void setMaisons(List<Home> maisons) {
		this.maisons = maisons;
	}

	@OneToMany(mappedBy = "amis", cascade = CascadeType.PERSIST)
	public List<Person> getAmis() {
		return amis;
	}

	public void setAmis(List<Person> amis) {
		this.amis = amis;
	}


	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

}
