package com.au.spring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	
	@Bean(name = "rectangle")
	public Rectangle rectangle() {
		return new Rectangle("10","10");
	}

	@Bean(name = "PointA")
	public Point pointAObj() {
		return new Point(0, 0);
	}

	@Bean(name = "PointB")
	public Point pointBObj() {
		return new Point(0, 20);
	}

	@Bean(name = "PointC")
	public Point pointCObj() {
		return new Point(20, 20);
	}

	@Bean(name = "PointD")
	public Point pointDObj() {
		return new Point(0, 20);
	}
	
	@Bean(name="List")
    public List<String> pointList() {
        return Arrays.asList("PointA-List", "PointB-List", "PointC-List","PointD-List");
    }
	
	@Bean(name="pointSet")
	public Set<String> getpointSet() {
	    return new HashSet<>(Arrays.asList("PointA-Set", "PointB-Set", "PointC-Set","PointD-Set"));
	}
	
	@Bean(name="pointMap")
	public Map<Integer, String> pointMap(){
	    Map<Integer, String>  nameMap = new HashMap<>();
	    nameMap.put(1, "PointA-Map");
	    nameMap.put(2, "PointB-Map");
	    nameMap.put(3, "PointC-Map");
	    nameMap.put(4, "PointD-Map");
	    return nameMap;
	}
}
