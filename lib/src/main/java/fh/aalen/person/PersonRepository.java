package fh.aalen.person;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String> {

	public List<Person> findByIdOrderById(String id);
	
	public List<Person> findByBirthdateOrderById(String birthday);
	
	public List<Person> findBySurenameOrderById(String surename);
}
