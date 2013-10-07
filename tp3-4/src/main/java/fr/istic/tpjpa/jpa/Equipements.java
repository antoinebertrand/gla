package fr.istic.tpjpa.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Equipements {

	public Equipements(int id, String type, Home maison) {
		super();
		Id = id;
		this.type = type;
		this.maison = maison;
	}

	public Equipements() {
		super();
	}

	private int Id;
	private String type;
	private Home maison;

	@Id
	@GeneratedValue
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
	
	@ManyToOne
	public Home getMaison() {
		return maison;
	}

	public void setMaison(Home maison) {
		this.maison = maison;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
