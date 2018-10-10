package co.algaworks.erp.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//Instancia criada dura todo o ciclo de vida da aplicação
@ApplicationScoped
public class EntityManagerProducer {
	
private EntityManagerFactory factory;
	
	public EntityManagerProducer() {
		this.factory = Persistence.createEntityManagerFactory("AlgaWorksPU");
	}
	
	
	//Metodo produtor - cria as instancias
	//Cada requisição uma nova instancia - CDI gerencia
	@Produces
	@RequestScoped
	public EntityManager createEntityManager() {
		return this.factory.createEntityManager();
	}
	
	public void closeEntityManager(@Disposes EntityManager manager) {
		manager.close();
}

}
