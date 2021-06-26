package Projekt.Start.Training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingService {

	
	@Autowired
	private TrainingRepository trainingRepository;
	
	public List<Training> getTrainingList() {
		ArrayList<Training> mylist = new ArrayList<>();
		Iterator<Training> it =trainingRepository.findAll().iterator();
		while(it.hasNext()) {
			mylist.add(it.next());
		}
		return mylist;
	}
	
	 
	public Training getTraining(long tnr) {
		return trainingRepository.findByTnr(tnr).orElse(null);
	}
	
	
	public void addTraining(Training training) {
		trainingRepository.save(training);
	}
	
	
	
	public void updateTraining(long tnr, Training training) {
		trainingRepository.save(training);
	}
	
	
	public void deleteTraining(long tnr, Training training) {
		trainingRepository.delete(training);
	}
	
	/*public List<Training> getAllTrainingOfDescription(String description){
		return trainingRepository.findByDescriptionOrderByTnr(description);
	}*/

}