package com.example.au.couchbasedemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.au.couchbasedemo.model.Football;
import com.example.au.couchbasedemo.repository.FootballRepository;

@RestController
public class FootballController {

	  @Autowired
	  FootballRepository footballRepository;
	  
	  
	  @PostMapping("/football")
	    public Football addFootball(@RequestBody Football football) {
	        return footballRepository.save(football);
	    }
	    
	  
	  @GetMapping("/football/goals/{goals}")
	    public List<String> findBygoals(@PathVariable int goals) {
		 
	       
	        List<Football> players = (List<Football>) footballRepository.findAll();
	        
	        
	        List<String> result = new ArrayList<String>();
	        
	        for(int i = 0;i<players.size();i++) 
	        {	
	            if(players.get(i).getgoals() > goals)
	            {
	            	result.add(players.get(i).getPlayerName());
	            }
	            System.out.println("Name : "+ players.get(i).getPlayerName());
	        }
	        return result;
	    }
}