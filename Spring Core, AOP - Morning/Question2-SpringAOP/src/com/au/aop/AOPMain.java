package com.au.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.au.aop.model.Rectangle;
import com.au.aop.service.ShapeService;

public class AOPMain {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("spring.xml");
		ShapeService shapeService = ctx.getBean("shapeservice", ShapeService.class);
		System.out.println(shapeService.getPoint().getX());
		System.out.println(shapeService.getRectangle().getHeight());
		
	}
}
