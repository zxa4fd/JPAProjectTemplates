package config.root.dao.interfaces;

import config.transfer.objects.Person;

public interface ServiceDAO {
	Person retrieveStuffFromDatabase(int personID);
	void savePersonToDatabase(Person personToPersist);
	void deleteFromDatabase(int personID);
	void updatePersonInDatabase(Person personTOUpdate);
}