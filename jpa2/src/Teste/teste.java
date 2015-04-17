package Teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entidades.Conta;

public class teste {

	public static void main(String[] args){
			
		
		EntityManagerFactory factory  = Persistence.createEntityManagerFactory("controlefinancas");
		EntityManager entityManager = factory.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Lucas");
		conta.setAgencia("12345");
		conta.setNumero("00000");
		
		//mede tempo de execução
		long inicio = System.currentTimeMillis();
		
		entityManager.getTransaction().begin();
		entityManager.persist(conta);
		entityManager.getTransaction().commit();
		
		long fim = System.currentTimeMillis();
		System.out.println("Executado em: " + (fim-inicio));
		
		System.out.println("Conta gravada com Sucesso");		
	}
}
