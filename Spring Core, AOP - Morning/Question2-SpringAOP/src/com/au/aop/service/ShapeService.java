package com.au.aop.service;

import com.au.aop.model.Point;
import com.au.aop.model.Rectangle;


public class ShapeService {
	
	private Point point;
	private Rectangle rectangle;
	
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
	public Rectangle getRectangle() {
		return rectangle;
	}
	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
	public ShapeService(Point point, Rectangle rectangle) {
		super();
		this.point = point;
		this.rectangle = rectangle;
	}
	
	

}
