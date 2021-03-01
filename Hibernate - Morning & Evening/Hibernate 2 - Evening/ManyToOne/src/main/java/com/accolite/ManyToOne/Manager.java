package com.accolite.ManyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Manager {

public static void main(String[] args)
{
SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory(); //create the session factory object
Session session = sessionFactory.openSession(); 
UserDetails user = new UserDetails(); //create an user entity

Vehicle vehicle = new Vehicle(); //create a vehicle entity
Vehicle vehicle2 = new Vehicle(); //create second vehicle entity

vehicle.setVehicleName("BMW Car"); //set BMW car
vehicle.setUser(user); //set user for that car

vehicle2.setVehicleName("AUDI Car"); //set second car Audi
vehicle2.setUser(user);//set user for that car

user.setUserName("John Doe"); //set user property

session.beginTransaction(); //create the transaction object
session.save(vehicle);
session.save(vehicle2);
session.save(user);
session.getTransaction().commit();
session.close();
}
}