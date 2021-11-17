package ca.sheridancollege.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ca.sheridancollege.beans.Restaurant;

//Adhrika Pai - 991451940
public class DAO {
	
	SessionFactory sessionFactory = new Configuration().configure("ca/sheridancollege/config/hibernate.cfg.xml")
			.buildSessionFactory();
	
	public void populate() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Restaurant rest1 = new Restaurant("Adhrika's Pizza Place", "Italian", "One of the delicious pizza place ever!", "$$", "*****");;
		session.save(rest1);
		Restaurant rest2 = new Restaurant("Burrito Simon", "Mexican", "Best chicken nachos", "$$$", "****");;
		session.save(rest2);
		Restaurant rest3 = new Restaurant("House by Sneh", "Indian", "Good vegetarian options", "$$$", "***");;
		session.save(rest3);
		Restaurant rest4 = new Restaurant("Mika's Sushi", "Japaneese", "Salmon sushi is their speciality", "$$", "**");;
		session.save(rest4);
		Restaurant rest5 = new Restaurant("Dine in with Samir", "American", "Drool over the pancakes!", "$", "*****");;
		session.save(rest5);
				
		session.getTransaction().commit();
		session.close();
	}
	public List<Restaurant> getAllRest(){
		Session session= sessionFactory.openSession();
		session.beginTransaction();			
		Query query = session.getNamedQuery("Restaurant.byAll");		
		List<Restaurant> inventoryList = query.getResultList();
		session.getTransaction().commit();
		session.close();		
		return inventoryList;
	}
	public List<Restaurant> getAllRate(){
		Session session= sessionFactory.openSession();
		session.beginTransaction();			
		Query query = session.getNamedQuery("Restaurant.byRestRate");		
		List<Restaurant> inventoryList = query.getResultList();
		session.getTransaction().commit();
		session.close();		
		return inventoryList;
	}
	public List<Restaurant> getRestPrice(String restPrice){
		Session session= sessionFactory.openSession();
		session.beginTransaction();			
		Query query = session.getNamedQuery("Restaurant.byRestPrice");	
		query.setParameter("restPrice", restPrice);
		List<Restaurant> inventoryList = query.getResultList();
		session.getTransaction().commit();
		session.close();		
		return inventoryList;
	}
	public List<Restaurant> getRestNote(String restNote){
		Session session= sessionFactory.openSession();
		session.beginTransaction();			
		Query query = session.getNamedQuery("Restaurant.byRestNote");	
		query.setParameter("restNote", restNote);
		List<Restaurant> inventoryList = query.getResultList();
		session.getTransaction().commit();
		session.close();		
		return inventoryList;
	}
	public List<Restaurant> getByName(String restName){
		Session session= sessionFactory.openSession();
		session.beginTransaction();			
		Query query = session.getNamedQuery("Restaurant.byRestName");	
		query.setParameter("restName", restName);
		List<Restaurant> inventoryList = query.getResultList();
		session.getTransaction().commit();
		session.close();		
		return inventoryList;
	}
	
	
	public void saveInventory(Restaurant rest) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(rest);
		session.getTransaction().commit();
		session.close();

	}

}
