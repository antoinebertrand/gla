package com.example;

import java.util.ArrayList;
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
		
		/*
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		// assuming a is an Integer  
		// if returning multiple fields, look into using a Tuple 
		// or specifying the return type as an Object or Object[]
		
		CriteriaQuery<Integer.class> query = criteriaBuilder.createQuery(Integer.class);
		Root<B.class> from = query.from(Bean.class);
		query.select(from.get("a")).where(from.get("a").in(1, 2, 3, 4));

		// create query and execute...
		*/
		
		// TODO create entity
		
		List<Equipements> megaDomotique = new ArrayList<Equipements>();
		Person Bertrand = new Person("adgfdsf", "berberber","fgfdg@plout", "02/02/02", "faceb",null ,null);
		Person Antoine = new Person("ant", "laturb","antu@plout", "02/03/03", "facebANTOIN", null , null);
		
		megaDomotique.add(new Equipements (22, "Truc Trop Bien", null));
		Home maison = new Home("kjnlkh","12k carrés","mega domotique", megaDomotique, Bertrand);
		
		megaDomotique.get(0).setMaison(maison);
		
		System.out.println(megaDomotique.get(0).getMaison());
		
		// TODO persist entity
		manager.persist(Bertrand);
		manager.persist(Antoine);
		manager.persist(maison);
		manager.persist(megaDomotique.get(0));		

		// TODO run request
		tx.commit();
		
		System.out.println(".. done");

		manager.close();
	}
	
	private void createPerson() {

        int numOfPerson = manager.createQuery("Select a From Preson a", Person.class).getResultList().size();

        if (numOfPerson== 0) {

            Home maison = new Home("3 rue", "9m²", "192.0.0.0", null, null);

            manager.persist(maison);

            manager.persist(new Person("adgfdsf", "berberber","fgfdg@plout", "02/02/02", "faceb",null ,null));

            manager.persist(new Person("ant", "laturb","antu@plout", "02/03/03", "facebANTOIN", null, null));
        }
    }

    private void listPerson() {

        List<Person> resultList = manager.createQuery("Select a From Person a", Person.class).getResultList();

        System.out.println("num of persons:" + resultList.size());

        for (Person next : resultList) {

            System.out.println("next person: " + next);

        }
    }
}
