package fh.aalen.person;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
	@Autowired
	PersonService personService;

	
	@RequestMapping("/person")
	public List<Person> getPersonList (){
		return personService.getPersonList();
	}
	
	
	@RequestMapping("/person/{id}")
	public Person getPerson (@PathVariable String id) {
		return personService.getPerson(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/person")
	public void addPerson (@RequestBody Person p) {
		personService.addPerson(p);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/person/{id}")
	public void updatePerson (@PathVariable String id,@RequestBody Person person) {
		personService.updatePerson(id, person);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/person/{id}")
	public void deletePerson(@PathVariable String id) {
		personService.deletePerson(id);
	}
	
	@RequestMapping("/personbysurename/{surename}")
	public List<Person> 	getAllPersonsOfSurename(@PathVariable String surename){
		return personService.getAllPersonsOfSurename(surename);
	}
	
	@RequestMapping("/personbybirthdate/{birthdate}")
	public List<Person> 	getAllPersonsOfBirthdate(@PathVariable String birthdate){
		return personService.getAllPersonsOfBirthdate(birthdate);
	}

	
	
}