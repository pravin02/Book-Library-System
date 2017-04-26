package org.pk.booklibrary.listener;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.PropertyConfigurator;

public class MyAppServletContextListener implements ServletContextListener {
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		System.out.println("ServletContextListener destroyed");
	}

	// Run this before web application is started
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		System.setProperty("rootPath", servletContextEvent.getServletContext()
				.getRealPath("/"));
		String log4jPath = servletContextEvent.getServletContext().getRealPath(
				"")
				+ File.separator
				+ "WEB-INF"
				+ File.separator
				+ "log4j.properties";

		System.out.println("ServletContextListener started " + log4jPath);
		PropertyConfigurator.configure(log4jPath);

	}
}
