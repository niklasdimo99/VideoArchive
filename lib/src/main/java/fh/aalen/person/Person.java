package fh.aalen.person;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import fh.aalen.video.Video;

@Entity
public class Person {
	
	@Id
	private String id;
	private String surename;
	private String birthdate;
	
	@ManyToMany
	private List <Video> favouriteVideos;
	
	public Person() {
		super();
	}

	public Person(String id, String surename, String birthdate) {
		super();
		this.id = id;
		this.surename = surename;
		this.birthdate = birthdate;
	}

	public String getId() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public String getSurename() {
		return surename;
	}

	public void setSurename(String surename) {
		this.surename = surename;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public List<Video> getFavouriteVideos() {
		return favouriteVideos;
	}

	public void setFavouriteVideos(List<Video> favouriteVideos) {
		this.favouriteVideos = favouriteVideos;
	}
	
	public void addVideoToFavourites(Video v) {
		this.favouriteVideos.add(v);
	}

	
}