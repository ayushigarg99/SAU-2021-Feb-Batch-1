package com.example.au.couchbasedemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.au.couchbasedemo.model.Movie;
import com.example.au.couchbasedemo.repository.MovieRepository;

@RestController
public class MovieController {
    
    @Autowired
    MovieRepository MovieRepository;
    
    @PostMapping("/movie")
    public Movie addMovie(@RequestBody Movie newMovie) {
        return MovieRepository.save(newMovie);
    }
   /* 
    
    @GetMapping("/employee/{id}")
    public Optional<Employee> getEmployee(@PathVariable String empId) {
        if (EmployeeRepository.existsById(empId)) {
            return EmployeeRepository.findById(empId);
        } else
            return Optional.empty();
    }
    
    */
    
    @GetMapping("/movie/movieCityName/{movieCityName}")
    public Movie getMovieByMovieCityName(@PathVariable String movieCityName) {
        return MovieRepository.findByCityName(movieCityName);
    }
    
    
    @GetMapping("/movie/movieName/{movieName}")
    public Movie getMovieByMovieName(@PathVariable String movieName) {
        return MovieRepository.findByMovieName(movieName);
    }
    
    @DeleteMapping("/movie/{movieId}")
    public void deleteById(@PathVariable String id) {
        MovieRepository.deleteById(id);
    }
}