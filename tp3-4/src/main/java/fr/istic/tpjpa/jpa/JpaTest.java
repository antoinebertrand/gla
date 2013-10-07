package fr.istic.tpjpa.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		// TODO create entity
		Person Bertrand = new Person("adgfdsf", "berberber","fgfdg@plout", "02/02/02", "faceb",null ,null);
		Person Antoine = new Person("ant", "laturb","antu@plout", "02/03/03", "facebANTOIN", null , null);
		
		// TODO persist entity
		manager.persist(Bertrand);
		manager.persist(Antoine);

		// TODO run request

		System.out.println(".. done");

		manager.close();
	}

}
