package Projekt.Start.Training;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Projekt.Start.Athlete.Athlete;



@RestController
public class TrainingController {

	@Autowired
	TrainingService trainingService;
	
	@RequestMapping("/training")
	public List<Training> getTrainingList (){
		return trainingService.getTrainingList();
	}
	
	
	@RequestMapping("/training/{tnr}")
	public Training getTraining (@PathVariable long tnr) {
		return trainingService.getTraining(tnr);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/training")
	public void addTraining (@RequestBody Training training) {
		trainingService.addTraining(training);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/training/{tnr}")
	public void updateTraining (@PathVariable long tnr,@RequestBody Training training) {
		trainingService.updateTraining(tnr, training);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/training/{tnr}")
	public void deleteTraining(@PathVariable long tnr, @RequestBody Training training) {
		trainingService.deleteTraining(tnr, training);
	}
	
	
	
}