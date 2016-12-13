package com.directory.mdb.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.context.support.GenericXmlApplicationContext;


import com.directory.user.User;

public class App {

	public static void main(String[] args) {

		// For XML
		@SuppressWarnings("resource")
		ApplicationContext ctx = new GenericXmlApplicationContext("SpringConfig.xml");

		// For Annotation
		//ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		User user = new User();
		user.setUserFirstName("Santhosh");
		user.setUserFirstName("Desikulkarni");
		// save
		mongoOperation.save(user);

		// now user object got the created id.
		//System.out.println("1. user : " + user);

		// query to search user
		//Query searchUserQuery = new Query(Criteria.where("username").is("mkyong"));

		// find the saved user again.
//		User savedUser = mongoOperation.findOne(searchUserQuery, User.class);
		//System.out.println("2. find - savedUser : " + savedUser);

		// delete
		//mongoOperation.remove(searchUserQuery, User.class);

		// List, it should be empty now.
		//List<User> listUser = mongoOperation.findAll(User.class);

	}

}