package config.root.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import config.root.dao.interfaces.ServiceDAO;
import config.root.services.interfaces.ServiceLayer;
import config.transfer.objects.Person;

@Service
public class ServiceLayerImplementation implements ServiceLayer  {

	@Autowired
	ServiceDAO serviceDAO;
	
	@Override
	public Person retrievePersonFromDatabase(int personID) {
		System.out.println("Retrieving person with ID: " + personID);
		return serviceDAO.retrieveStuffFromDatabase(personID);
	}

	@Override
	public void savePersonToDatabase(Person personToPersist) {
		System.out.println("Saving " + personToPersist.getName() + " to database");
		serviceDAO.savePersonToDatabase(personToPersist);
	}

	@Override
	public void deleteFromDatabase(int personID) {
		System.out.println("Deleting person with ID: " + personID);
 		serviceDAO.deleteFromDatabase(personID);
	}

	@Override
	public void updatePersonInDatabase(Person personToUpdate) {
		System.out.println("Updating person with ID: " + personToUpdate.getId() + " name: " + personToUpdate.getName());
		serviceDAO.updatePersonInDatabase(personToUpdate);
	}

}
