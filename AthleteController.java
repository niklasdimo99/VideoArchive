package Projekt.Start.Athlete;

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
public class AthleteController {
	
	@Autowired
	AthleteService athleteService;
	
	
	@RequestMapping("/athlete")
	public List<Athlete> getAthleteList (){
		return athleteService.getAthleteList();
	}
	
	
	@RequestMapping("/athlete/{id}")
	public Athlete getAthlete (@PathVariable long id) {
		return athleteService.getAthlete(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/athlete")
	public void addAthlete (@RequestBody Athlete s) {
		athleteService.addAthlete(s);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/athlete/{id}")
	public void updateAthlete (@PathVariable long id,@RequestBody Athlete athlete) {
		athleteService.updateAthlete(id, athlete);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/athlete/{id}")
	public void delete(@PathVariable long id, @RequestBody Athlete athlete) {
		athleteService.deleteAthlete(id, athlete);
	}
	
}