package Projekt.Start.Zuweisung;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Projekt.Start.Athlete.Athlete;
import Projekt.Start.Training.Training;

@Entity
public class Zuweisung {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "znr",unique=true)
	private long znr;
	
	@ManyToOne
	@MapsId("athleteId")
	@JoinColumn(name="athlete_id")
	Athlete athlete;
	
	@ManyToOne
	@MapsId("trainingId")
	@JoinColumn(name="training_id")
	Training training;
	
	private String date;
	

	private String startTime;
	private String endTime;
	private String weight;

	public Long getZnr() {
		return znr;
	}

	public void setZnr(Long znr) {
		this.znr = znr;
	}
	public Athlete getAthlete() {
		return athlete;
	}
	
	public void setAthlete(Athlete athlete) {
		this.athlete = athlete;
	}

	public Training getTraining() {
		return training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}

	public Zuweisung() {
		super();
	} 
	
	public Zuweisung(Long znr, String date, String startTime, String endTime, String weight, Athlete athlete,
			Training training) {
		super();
		this.znr = znr;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.weight = weight;
		this.athlete = athlete;
		this.training = training;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
	
		
}