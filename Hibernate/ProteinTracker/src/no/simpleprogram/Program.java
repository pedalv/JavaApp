package no.simpleprogram;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.hibernate.Session;
import org.ehcache.Cache;
import org.hibernate.Criteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import no.domain.GoalAlert;
import no.domain.ProteinData;
import no.domain.User;
import no.domain.UserHistory;
import no.domain.UserTotal;

public class Program {

	public static void main(String[] args) {
		
		System.out.println("Hello Hibernate");
		
		//mappingRelationshipsExamples();
		
		//PopulateSampleData();
		
		//getAllUsers();
		
		//getUserByName("Joe");
		
		//getPaging();
		
		//getAllPaging();
		
		//getDynamicInstantiation();

		//getAllUsersByCriterial();
		
		//getByProjections();

		//getCriteriaJoins(); 
		
		//getQueryByExample();
		
		 ehCacheExample();
		 		
		
		HibernateUtilities.getSessionFactory().close();
	}

	private static void ehCacheExample() {
		
		Cache<Long, String> mycache = EhCacheConfig.getMyCacheInstance();
		
		System.out.println("Value cached (null data): " + mycache.get(1L));
		mycache.put(1L, "It has data now!"); 
		System.out.println("Value cached (has data): " + mycache.get(1L));
	}

	private static void getQueryByExample() {
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		
		User user = new User();
		user.setName("joe");

		Example e = Example.create(user)
			.ignoreCase();
			
		Criteria criteria = session.createCriteria(User.class)
			.add(e);

		List<User> results = criteria.list();
		
		for(User result: results) {
			System.out.println(result);
		}
		
		session.getTransaction().commit();
		session.close();
	}

	private static void getCriteriaJoins() {
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(User.class)
				.createAlias("proteinData", "pd")
				.add(Restrictions.or(
						Restrictions.eq("name","Joe"),
						Restrictions.eq("name","Bob")
					)).setProjection(Projections.property("pd.total")); 
 				
		List<Integer> results = criteria.list();
		
		for(int result: results) {
			System.out.println(result);
		}
		
		session.getTransaction().commit();
		session.close();
	}

	private static void getByProjections() {
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(User.class)
				.add(Restrictions.or(
						Restrictions.eq("name","Joe"),
						Restrictions.eq("name","Bob")
					)).setProjection(Projections.projectionList()
						.add(Projections.property("name"))
						.add(Projections.property("id"))
					); 

				
		List<Object[]> results = criteria.list();
		
		for(Object[] result: results) {
			
			for(Object o: result) {
				System.out.println(o.toString());
			}
			
			//System.out.println(result.toString());
		}
		
		session.getTransaction().commit();
		session.close();
	}

	private static void getAllUsersByCriterial() {
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(User.class);
				
		List<User> users = criteria.list();
		
		for(User user: users) {
			System.out.println(user.getName());
		}
		
		session.getTransaction().commit();
		session.close();
	}

	private static void getDynamicInstantiation() {
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		
		//Query query = session.getNamedQuery("AllGoalAlerts");
		Query query = session.createQuery("select new no.domain.UserTotal(user.name, user.proteinData.total) " +
		"from User user");
				
		List<UserTotal> userTotals = query.list();
		
		for(UserTotal userTotal: userTotals) {
			System.out.println(userTotal.getName() + ": " + userTotal.getTotal());
		}
		
		session.getTransaction().commit();
		session.close();
	}

	private static void getAllPaging() {
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		
		Query query = session.getNamedQuery("AllGoalAlerts");
		//Query query = session.createQuery("from GoalAlert");
				
		List<GoalAlert> alerts = query.list();
		
		for(GoalAlert alert: alerts) {
			System.out.println(alert.getMessage());
		}
		
		session.getTransaction().commit();
		session.close();
	}
	
	private static void getPaging() {
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		
		Query query = session
				.createQuery("from GoalAlert")
				.setFirstResult(2)
				.setMaxResults(1);
		
		List<GoalAlert> alerts = query.list();
		
		for(GoalAlert alert: alerts) {
			System.out.println(alert.getMessage());
		}
		
		session.getTransaction().commit();
		session.close();
	}

	private static void getUserByName(String name) {
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		
		Query query = session
				.createQuery("Select user from User user where user.name = :name")
				.setString("name", name);
		
		List<User> users = query.list();
		
		for(User user: users) {
			System.out.println(user.getName());
		}
		
		session.getTransaction().commit();
		session.close();
	}

	private static void getAllUsers() {
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from User");
		List<User> users = query.list();
		
		for(User user: users) {
			System.out.println(user.getName());
		}
		
		session.getTransaction().commit();
		session.close();
	}
	
	private static void PopulateSampleData() {
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		
		User joe = CreateUser("Joe", 500, 50, "Good job", "You made it!");
		session.save(joe);
		
		User bob = CreateUser("Bob", 300, 20, "Taco time!");
		session.save(bob);
		
		User amy = CreateUser("Amy", 250, 200, "Yes!!!");
		session.save(amy);
		session.getTransaction().commit();
		session.close();
	}

	private static User CreateUser(String name, int goal, int total, String ... alerts){
		User user = new User();
		user.setName(name);
		user.getProteinData().setGoal(goal);
		user.addHistory(new UserHistory(new Date(), "Set goal to " + goal));
		user.getProteinData().setTotal(total);
		user.addHistory(new UserHistory(new Date(), "Set total to " + total));
		for(String alert : alerts) {
			user.getGoalAlerts().add(new GoalAlert(alert));
		}
		
		return user;
	}

	private static void mappingRelationshipsExamples() {
		Session session = HibernateUtilities.getSessionFactory().openSession();

		//Add user
		session.beginTransaction();
		
		User user = new User();
		user.setName("Pedro");
		//SET and LIST and BAG
		//user.getHistory().add(new UserHistory(new Date(), "Set name to Pedro"));
		user.addHistory(new UserHistory(new Date(), "Set name to Pedro"));
		//MAP
		//user.getHistory().put("guid1", new UserHistory(new Date(), "Set name to Pedro"));
		user.getProteinData().setGoal(256);
		//SET and LIST and BAG
		//user.getHistory().add(new UserHistory(new Date(), "Set the goal to 280"));
		user.addHistory(new UserHistory(new Date(), "Set the goal to 280"));
		//MAP
		//user.getHistory().put("guid2", new UserHistory(new Date(), "Set the goal to 280"));
		user.getGoalAlerts().add(new GoalAlert("Congratulations!"));
		user.getGoalAlerts().add(new GoalAlert("You did it!"));
		
		session.save(user);
		
		
		session.getTransaction().commit();
		
		//Extract
		session.beginTransaction();

		//User loadedUser = (User) session.load(User.class, 1);
		User loadedUser = (User) session.get(User.class, 1);
	
		System.out.println(loadedUser.getName());
		System.out.println(loadedUser.getProteinData().getGoal());
		
		//SET and LIST and BAG
		for(UserHistory history: loadedUser.getHistory()) {
			System.out.println(history.getEntryTime().toString() + " - " + history.getEntry());
		}
		
		/* MAP
		for(Entry<String, UserHistory> history: loadedUser.getHistory().entrySet()) {
			System.out.println("Key: " + history.getKey());
			System.out.println(history.getValue().getEntryTime().toString() + " - " + history.getValue().getEntry());
		}
		*/
		// and Update
		loadedUser.getProteinData().setTotal(loadedUser.getProteinData().getTotal() + 58);
		//SET and LIST and BAG
		//loadedUser.getHistory().add(new UserHistory(new Date(), "Added 58 to protein"));
		loadedUser.addHistory(new UserHistory(new Date(), "Added 58 to protein"));
		//MAP
		//	loadedUser.getHistory().put("GUID3", new UserHistory(new Date(), "Added 58 to protein"));
		
		user.setProteinData(new ProteinData() );
		
		session.getTransaction().commit();
		
		session.close();
	}

}