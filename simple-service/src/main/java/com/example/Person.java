package com.example;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Entity
@Path("/Person")
public class Person{
	
	public Person() {
		super();
	}

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

	@OneToMany(mappedBy = "p")
	@GET@Path("maisons")
	@Produces(MediaType.TEXT_PLAIN)
	public List<Home> getMaisons() {
		return maisons;
	}
	
	@PUT@Path("maisons/{liste}")
	public void setMaisons(@PathParam("liste")List<Home> maisons) {
		this.maisons = maisons;
	}

	@ManyToMany
	@Column(nullable=true)
	@GET@Path("amis")
	@Produces(MediaType.TEXT_PLAIN)
	public List<Person> getAmis() {
		return amis;
	}
	@PUT@Path("amis/{liste}")
	public void setAmis(@PathParam("liste")List<Person> amis) {
		this.amis = amis;
	}

	@Id
	@GeneratedValue
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public int getID() {
		return ID;
	}
	@PUT@Path("id/{id}")
	public void setID(@PathParam("id")int iD) {
		ID = iD;
	}
	@GET@Path("name")
	@Produces(MediaType.TEXT_PLAIN)
	public String getName() {
		return name;
	}
	@PUT
	public void setName(String name) {
		this.name = name;
	}
	@GET@Path("firstname")
	@Produces(MediaType.TEXT_PLAIN)
	public String getFirstName() {
		return firstName;
	}
	@PUT@Path("firtname/{fname}")
	public void setFirstName(@PathParam("fname")String firstName) {
		this.firstName = firstName;
	}
	@GET@Path("mail")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMail() {
		return mail;
	}
	@PUT@Path("mail/{mail}")
	public void setMail(@PathParam("mail")String mail) {
		this.mail = mail;
	}
	@GET@Path("dob")
	@Produces(MediaType.TEXT_PLAIN)
	public String getDob() {
		return dob;
	}
	@PUT@Path("setdob/{dob}")
	public void setDob(@PathParam("dob")String dob) {
		this.dob = dob;
	}
	@GET@Path("facebook")
	@Produces(MediaType.TEXT_PLAIN)
	public String getFacebook() {
		return facebook;
	}
	@PUT@Path("setfb/{dob}")
	public void setFacebook(@PathParam("fb")String facebook) {
		this.facebook = facebook;
	}

}
