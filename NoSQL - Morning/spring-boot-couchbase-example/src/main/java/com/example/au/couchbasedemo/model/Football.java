package com.example.au.couchbasedemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
public class Football {
	
	@Id
	private String playerId;
	private String playerName;
	private Float playerAvg;
	private Integer goals;
	
	
	public Football(String playerId, String playerName, Float playerAvg, Integer goals) {
		this.playerId = playerId;
		this.playerName = playerName;
		this.playerAvg = playerAvg;
		this.goals = goals;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPLayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Float getPlayerAvg() {
		return playerAvg;
	}

	public void setPlayerAvg(Float playerAvg) {
		this.playerAvg = playerAvg;
	}
	
	public Integer getgoals() {
		return goals;
	}

	public void setgoals(Integer goals) {
		this.goals = goals;
	}
	

}