package Projekt.Start.Athlete;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface AthleteRepository extends CrudRepository<Athlete, String> {

	public List<Athlete> findByIdOrderById(long id);
		
	public List<Athlete> findByNameOrderById(String name);
	
	public List<Athlete> findByGenderOrderById(String gender);
	
	public List<Athlete> findByHeightOrderById(String height);

	public Optional<Athlete> findById(long id);	
}