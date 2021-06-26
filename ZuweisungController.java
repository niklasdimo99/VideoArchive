package Projekt.Start.Zuweisung;

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
public class ZuweisungController {

	@Autowired
	ZuweisungService zuweisungService;
	
	@RequestMapping("/zuweisung")
	public List<Zuweisung> getZuweisungList (){
		return zuweisungService.getZuweisungList();
	}
	
	
	@RequestMapping("/zuweisung/{znr}")
	public Zuweisung getZuweisung (@PathVariable long znr) {
		return zuweisungService.getZuweisung(znr);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/zuweisung")
	public void addZuweisung (@RequestBody Zuweisung zuweisung) {
		zuweisungService.addZuweisung(zuweisung);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/zuweisung/{znr}")
	public void updateZuweisung (@PathVariable long znr,@RequestBody Zuweisung zuweisung) {
		zuweisungService.updateZuweisung(znr, zuweisung);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/zuweisung/{znr}")
	public void deleteZuweisung(@PathVariable long znr, @RequestBody Zuweisung zuweisung) {
		zuweisungService.deleteZuweisung(znr, zuweisung);
	}
	
}