package config.root.services.interfaces;

import config.transfer.objects.Person;

public interface ServiceLayer {
	Person retrievePersonFromDatabase(int personID);
	void savePersonToDatabase(Person personToPersist);
	void deleteFromDatabase(int personID);
	void updatePersonInDatabase(Person personToUpdate);
}
