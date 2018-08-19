package practice.web.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

	@RequestMapping(value="/get", method = RequestMethod.GET, produces = "application/html")
	public String sayHello() {
		return "Hello World!";
	}

	@RequestMapping(value="{randomWord}",method=RequestMethod.POST)
	public String pathEntry(@PathVariable("randomWord") String someWord) {
		System.out.println(someWord);
		return someWord;
	}
}
