package com.example.au.couchbasedemo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.au.couchbasedemo.model.Movie;

public interface MovieRepository extends CrudRepository<Movie, String> {
	
	Movie findByMovieName(String moviename);
	
	Movie findByCityName(String cityname);
	
	//Movie findByPincode(String pincode);
	   
}