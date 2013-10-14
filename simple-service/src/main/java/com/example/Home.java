package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.ws.rs.Path;

@Entity
@Path("/Home")
public class Home {

	public Home() {
		super();
	}

	public Home(String adress, String superficy, String iP, List<Equipements> equip, Person p) {
		super();
		this.adress = adress;
		this.superficy = superficy;
		this.equip = equip;
		IP = iP;
		this.p = p;
	}

	private int ID;
	private String adress, superficy, IP;
	private List<Equipements> equip = new ArrayList<Equipements>();
	private Person p  =new Person(IP, IP, IP, IP, IP, null, null);

	@ManyToOne
	public Person getP() {
		return p;
	}

	public void setP(Person p) {
		this.p = p;
	}
	
	@OneToMany(mappedBy="maison")
	public List<Equipements> getEquip() {
		return equip;
	}

	public void setEquip(List<Equipements> equip) {
		this.equip = equip;
	}

	@Id
	@GeneratedValue
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getSuperficy() {
		return superficy;
	}

	public void setSuperficy(String superficy) {
		this.superficy = superficy;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

}
