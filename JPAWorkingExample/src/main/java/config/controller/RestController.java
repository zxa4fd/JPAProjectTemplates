package config.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import config.root.services.interfaces.ServiceLayer;
import config.transfer.objects.Book;
import config.transfer.objects.Person;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

	@Autowired
	ServiceLayer restControllerService;

	@RequestMapping(value="/get", method = RequestMethod.GET, produces = "application/html")
	public String sayHello() {
		return "Functioning";
	}
	
	@RequestMapping(value="/getsamples", method = RequestMethod.GET, produces = {"application/json", "applicatioh/xml"})
	public ResponseEntity<Object> getSampleBook() {
		Book sampleBookOne = new Book();
		sampleBookOne.setAuthor("Immanuel Kant");
		sampleBookOne.setTitle("Critique of Practical Reason");
		Book sampleBookTwo = new Book();
		sampleBookTwo.setAuthor("David Hume");
		sampleBookTwo.setTitle("Enquiry Concerning Human Understanding");
		List<Book> returnedList = new ArrayList<>();
		returnedList.add(sampleBookOne);
		returnedList.add(sampleBookTwo);
		Map<String, List<?>> bookMap = new HashMap<>();	
		bookMap.put("booklist", returnedList);
		return new ResponseEntity<>(sampleBookOne ,HttpStatus.OK);
		
	}

	@RequestMapping(value="/getperson/{personID}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<Object> retrieveResponsePerson(@PathVariable("personID") int personID) {
		Person returnedPerson = restControllerService.retrievePersonFromDatabase(personID);
		Optional<Person> optionalPerson = Optional.ofNullable(returnedPerson);
		HttpStatus returnedStatus = optionalPerson.isPresent() ? HttpStatus.OK : HttpStatus.NO_CONTENT;
		return new ResponseEntity<>(returnedPerson , returnedStatus);
	}
	@RequestMapping(value="/deleteperson/{personID}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deletePerson(@PathVariable("personID") int personID) {
		restControllerService.deleteFromDatabase(personID);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value="/saveperson", method=RequestMethod.POST, consumes = {"application/json"})
	public ResponseEntity<Object> acceptPerson(@RequestBody Person personToPersist) {
		restControllerService.savePersonToDatabase(personToPersist);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/updateperson", method=RequestMethod.POST, consumes = {"application/json"})
	public ResponseEntity<Object> updatePerson(@RequestBody Person personToPersist) {
		restControllerService.updatePersonInDatabase(personToPersist);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
