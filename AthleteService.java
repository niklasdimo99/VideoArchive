package Projekt.Start.Athlete;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Projekt.Start.Athlete.Athlete;
import Projekt.Start.Athlete.AthleteRepository;

@Service
public class AthleteService {
	
	@Autowired
	AthleteRepository athleteRepository;
	
	public List<Athlete> getAthleteList() {
		ArrayList<Athlete> mylist = new ArrayList<>();
		Iterator<Athlete> it = athleteRepository.findAll().iterator();
		while(it.hasNext()) {
			mylist.add(it.next());
		}
		return mylist;
	}
	
	public Athlete getAthlete(long id) {
		return athleteRepository.findById(id).orElse(null);
	}

	public void addAthlete(Athlete athlete) {
		athleteRepository.save(athlete);
	}
	
	public void updateAthlete(long id, Athlete athlete) {
		athleteRepository.save(athlete);
	}
	
	public void deleteAthlete(long id, Athlete athlete) {	
		athleteRepository.delete(athlete);
	}
	
	public List<Athlete> getAllAthleteOfName(String name){
		return athleteRepository.findByNameOrderById(name);
	}

	public List<Athlete> getAllAthleteOfGender(String gender){
		return athleteRepository.findByGenderOrderById(gender);
	}
	
	public List<Athlete> getAllAthleteOfHeight(String height){
		return athleteRepository.findByHeightOrderById(height);
	}
	
}