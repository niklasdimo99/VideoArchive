  
package Projekt.Start.Training;

import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Projekt.Start.Athlete.Athlete;
import Projekt.Start.Zuweisung.Zuweisung;

@Entity
public class Training {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "tnr",unique=true)
	private long tnr;
	
	private String description;	
	
	@OneToMany(mappedBy="training")
	Set<Zuweisung> zuweisung;
	
	//@ManyToMany(mappedBy="solvedTraining")
	//@JsonIgnore
	//private List <Athlete> solvedTraining;
	
	public Training() {
		super();
	}
	

	public Training(long tnr, String description) {
		super();
		this.tnr = tnr;
		this.description = description;
	}

	public long getTnr() {
		return tnr;
	}

	public void setTnr(long tnr) {
		this.tnr = tnr;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*public List<Athlete> getSolvedTraining() {
		return solvedTraining;
	}

	public void setSolvedTraining(List<Athlete> solvedTraining) {
		this.solvedTraining = solvedTraining;
	}*/
	
	
}