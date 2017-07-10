package no.simpleprogram;

import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Session;

import no.domain.User;
import no.domain.UserHistory;

public class Program {

	public static void main(String[] args) {
		
		System.out.println("Hello Hibernate");
		
		Session session = HibernateUtilities.getSessionFactory().openSession();

		//Add user
		session.beginTransaction();
		
		User user = new User();
		user.setName("Pedro");
		//SET and LIST
		//user.getHistory().add(new UserHistory(new Date(), "Set name to Pedro"));
		//MAP
		user.getHistory().put("guid1", new UserHistory(new Date(), "Set name to Pedro"));
		user.getProteinData().setGoal(256);
		//SET and LIST
		//user.getHistory().add(new UserHistory(new Date(), "Set the goal to 280"));
		//MAP
		user.getHistory().put("guid2", new UserHistory(new Date(), "Set the goal to 280"));
		session.save(user);
		
		
		session.getTransaction().commit();
		
		//Extract
		session.beginTransaction();

		//User loadedUser = (User) session.load(User.class, 1);
		User loadedUser = (User) session.get(User.class, 1);
	
		System.out.println(loadedUser.getName());
		System.out.println(loadedUser.getProteinData().getGoal());
		
		//SET and LIST
		/*
		for(UserHistory history: loadedUser.getHistory()) {
			System.out.println(history.getEntryTime().toString() + " - " + history.getEntry());
		}
		*/
		//MAP
		for(Entry<String, UserHistory> history: loadedUser.getHistory().entrySet()) {
			System.out.println("Key: " + history.getKey());
			System.out.println(history.getValue().getEntryTime().toString() + " - " + history.getValue().getEntry());
		}
		
		// and Update
		loadedUser.getProteinData().setTotal(loadedUser.getProteinData().getTotal() + 58);
		//SET and LIST
		//loadedUser.getHistory().add(new UserHistory(new Date(), "Added 58 to protein"));
		//MAP
		loadedUser.getHistory().put("GUID3", new UserHistory(new Date(), "Added 58 to protein"));
		
		session.getTransaction().commit();
		
		
		session.close();
		HibernateUtilities.getSessionFactory().close();
	}

}