package Projekt.Start.Athlete;

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

import Projekt.Start.Training.Training;
import Projekt.Start.Zuweisung.Zuweisung;

@Entity
public class Athlete {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id",unique=true)
	private long id;
	
	@OneToMany(mappedBy="athlete")
	Set<Zuweisung> zuweisung;
	
	public Athlete() {
		super();
	}
	
	private String height;
	private String gender;
	private String name;

	public Athlete(long id, String name, String height, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.height = height;
		this.gender = gender;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getheight() {
		return height;
	}

	public void setheight(String height) {
		this.height = height;
	}

	public String getgender() {
		return gender;
	}

	public void setgender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}