package com.guide.city.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartApplication {
	
	public static String JETTY_CONF_PATH = "/spring/JettyConfiguration.xml";
	
	public static void main(String args[]) throws Exception {

		// use xml file.
		@SuppressWarnings({ "resource", "unused" })
		ApplicationContext context = new ClassPathXmlApplicationContext(JETTY_CONF_PATH);
		
	}
}