package Projekt.Start.Training;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import Projekt.Start.Athlete.Athlete;

public interface TrainingRepository extends CrudRepository<Training, String>  {

	public List<Training> findByDescriptionOrderByTnr(String description);
	
	public Optional<Training> findByTnr(long tnr);	
	
}