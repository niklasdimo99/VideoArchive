package Projekt.Start.Zuweisung;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import Projekt.Start.Athlete.Athlete;

public interface ZuweisungRepository extends CrudRepository<Zuweisung, String>  {

	//public List<Zuweisung> findByDescriptionOrderByZnr(String description);
	
	public Optional<Zuweisung> findByZnr(long znr);	
	
}
