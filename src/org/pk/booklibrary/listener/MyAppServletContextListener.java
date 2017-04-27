package org.pk.booklibrary.listener;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Listener to initialize Log4J library immediately after Loading project in web
 * container.
 * 
 * @author PKCORP
 * @since 26/04/2017
 */
public class MyAppServletContextListener implements ServletContextListener {

	Logger logger = Logger.getLogger(MyAppServletContextListener.class);

	/**
	 * Method calls when project is undeploying from web container.
	 * 
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 * 
	 */
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		logger.debug("ServletContextListener destroyed");
	}

	/**
	 * Run this before web application is just started
	 * 
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		System.setProperty("rootPath", servletContextEvent.getServletContext().getRealPath("/"));
		String log4jPath = servletContextEvent.getServletContext().getRealPath("") + File.separator + "WEB-INF"
				+ File.separator + "log4j.properties";

		logger.debug("ServletContextListener started " + log4jPath);
		PropertyConfigurator.configure(log4jPath);

	}
}