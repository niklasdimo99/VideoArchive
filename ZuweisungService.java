package Projekt.Start.Zuweisung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Projekt.Start.Athlete.Athlete;
import Projekt.Start.Athlete.AthleteRepository;
import Projekt.Start.Training.Training;
import Projekt.Start.Training.TrainingRepository;

@Service
public class ZuweisungService {

	
	@Autowired
	private ZuweisungRepository zuweisungRepository;
	private AthleteRepository athleteRepository;
	private TrainingRepository trainingRepository;

	
	
	public List<Zuweisung> getZuweisungList() {
		ArrayList<Zuweisung> mylist = new ArrayList<>();
		Iterator<Zuweisung> it =zuweisungRepository.findAll().iterator();
		while(it.hasNext()) {
			mylist.add(it.next());
		}
		return mylist;
	}
	
	 
	public Zuweisung getZuweisung(long znr) {
		return zuweisungRepository.findByZnr(znr).orElse(null);
	}
	
	
	public void addZuweisung(Zuweisung zuweisung) {
		Athlete a = athleteRepository.findById(zuweisung.getAthlete().getId()).orElse(null);
		Training t = trainingRepository.findByTnr(zuweisung.getTraining().getTnr()).orElse(null);
		zuweisung.setTraining(t);
		zuweisung.setAthlete(a);
		zuweisungRepository.save(zuweisung);
	}
	
	
	
	public void updateZuweisung(long znr, Zuweisung zuweisung) {
		zuweisungRepository.save(zuweisung);
	}
	
	
	public void deleteZuweisung(long znr, Zuweisung zuweisung) {
		zuweisungRepository.delete(zuweisung);
	}


}