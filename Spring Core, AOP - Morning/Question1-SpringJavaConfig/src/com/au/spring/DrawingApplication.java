package com.au.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DrawingApplication {

	public static void main(String[] args) {
		ApplicationContext configuration = new AnnotationConfigApplicationContext(Config.class);
		Rectangle rectangle = (Rectangle) configuration.getBean("rectangle");
		rectangle.draw();
	}
}
