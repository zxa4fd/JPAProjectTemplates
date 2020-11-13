package config.root.dao.implementations;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import config.root.dao.interfaces.ServiceDAO;
import config.transfer.objects.Person;

@Repository
@Transactional
public class ServiceDAOImplementation implements ServiceDAO {

	@PersistenceContext
	EntityManager serviceEntityManager;
	
	public Person retrieveStuffFromDatabase(int personID) {
		return serviceEntityManager.find(Person.class, personID);
	}

	@Override
	public void savePersonToDatabase(Person personToPersist) {
		serviceEntityManager.persist(personToPersist);
	}

	@Override
	public void deleteFromDatabase(int personID) {
		serviceEntityManager.remove(retrieveStuffFromDatabase(personID));
	}

	@Override
	public void updatePersonInDatabase(Person personToUpdate) {
		Person referencedPerson = serviceEntityManager.merge(personToUpdate);
		referencedPerson.setName(personToUpdate.getName());
		
	}
}
