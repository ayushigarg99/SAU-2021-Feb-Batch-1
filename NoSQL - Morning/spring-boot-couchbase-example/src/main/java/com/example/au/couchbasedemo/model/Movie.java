package com.example.au.couchbasedemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
public class Movie {
	
	@Id
	private String movieId;
	private String movieName;
	private String movieCityName;
	//private Integer ;
	//private Integer wickets;
	
	public Movie(String movieId, String movieName, String movieCityName) {
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieCityName = movieCityName;
		//this.runs = runs;
		//this.wickets = wickets;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieCityName() {
		return movieCityName;
	}

	public void setMovieCityName(String movieCityName) {
		this.movieCityName = movieCityName;
	}
	/*
	public Integer getruns() {
		return runs;
	}

	public void setruns(Integer runs) {
		this.runs = runs;
	}
	
	public	Integer getwickets() {
		return wickets;
	}

	public void setwickets(Integer wickets) {
		this.wickets = wickets;
	}
	*/
}