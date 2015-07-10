package Uteis;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {	
	public static EntityManager em;
	private static EntityManagerFactory entityManagerFactory; 
	
	static{		
		entityManagerFactory = 
				Persistence.createEntityManagerFactory("treinamento");
		em = new JPAUtil().getEntityManager();	
		em.getTransaction().begin();
	}
		
	public EntityManager getEntityManager(){
		return entityManagerFactory.createEntityManager();
	}			
	
	public static void desconecta(){
		em.getTransaction().commit();
		em.close();
	}
	
	public static void commit(){
		em.getTransaction().commit();
		em.getTransaction().begin();
	}
	
}