package fr.istic.tpjpa.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Equipements {

	private Long Id;
	private String type;

	@Id
	@GeneratedValue
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Equipements(String type) {
		super();
		this.type = type;
	}

}
