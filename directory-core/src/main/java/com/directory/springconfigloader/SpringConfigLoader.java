package com.directory.springconfigloader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




public class SpringConfigLoader {
	
	
	
	private static ApplicationContext context;
	
	/**
	 * Acts as a dummy method. The config files are loaded when the class is loaded.
	 * This is to ensure that the configuration is loaded only once.
	 */
	static {
		try{
	   context = new ClassPathXmlApplicationContext(
		        new String[] {"application-config.xml"});
		}catch(Exception e){
		
			e.printStackTrace();
		}
	}
	  
	public static Object getBean(String beanName){
		return context.getBean(beanName);
	}
	
	public static ApplicationContext getContext(){
		return context;
	}
	
	public static void main(String[] args){
		SpringConfigLoader loader = new SpringConfigLoader();
		System.out.println("DONE");
	}
}
