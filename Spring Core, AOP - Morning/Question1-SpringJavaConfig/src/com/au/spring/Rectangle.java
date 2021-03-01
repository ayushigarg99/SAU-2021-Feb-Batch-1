package com.au.spring;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class Rectangle {
	
	/* Object Java Configuration */
	
	@Autowired
	@Qualifier("PointA")
	private Point pointA;
	
	@Autowired
	@Qualifier("PointB")
	private Point pointB;
	
	@Autowired
	@Qualifier("PointC")
	private Point pointC;
	
	@Autowired
	@Qualifier("PointD")
	private Point pointD;
	
	/* LIST Collection Java Configuration */
	
	@Autowired
	@Qualifier("List")
	private List<String> points;
	  
	public List<String> getPoints(){ return points; }
	 
	public void setPoints(List<String> points){ this.points = points; }
	
	/* SET Collection Java Configuration */
	
	@Autowired
	@Qualifier("pointSet")
	private Set<String> pointSet;
	
	public Set<String> getPointSet() {
		return pointSet;
	}

	public void setPointSet(Set<String> pointSet) {
		this.pointSet = pointSet;
	}
	
	/* Map Collection Java Configuration */
	
	@Autowired
	@Qualifier("pointMap")
	private Map<Integer, String> pointMap;
	
	public Map<Integer, String> getPointMap() {
		return pointMap;
	}

	public void setPointMap(Map<Integer, String> pointMap) {
		this.pointMap = pointMap;
	}

	private String height;
	
	
	private String width;

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public Point getPointD() {
		return pointD;
	}

	public void setPointD(Point pointD) {
		this.pointD = pointD;
	}
	
	public Rectangle(String i, String j) {
		super();
		this.height = i;
		this.width = j;
	}

	
	public void draw() {
		
		System.out.println("Height = "+ height+ " Width = "+width);
		
		for(String point:points) 
		System.out.println(point);
		
		System.out.println("Point A  x " + getPointA().getX() + " y "+ getPointA().getY());
		System.out.println("Point B  x " + getPointB().getX() + " y "+ getPointB().getY());
		System.out.println("Point C  x " + getPointC().getX() + " y "+ getPointC().getY());
		System.out.println("Point D  x " + getPointD().getX() + " y "+ getPointD().getY());
		
		Iterator<String> itr = pointSet.iterator();
		while (itr.hasNext()) 
			System.out.println(itr.next());
		
		for(Entry<Integer, String> point : pointMap.entrySet()) 
		{ 
			System.out.println(point.getKey() + "  " + point.getValue()); 
		}
		
	}
}
