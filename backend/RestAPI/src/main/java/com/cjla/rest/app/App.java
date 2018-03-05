package com.cjla.rest.app;

import java.net.InetSocketAddress;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.glassfish.jersey.servlet.ServletContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cjla.rest.di.BackendBinder;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class App {
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
	private final static Config config = ConfigFactory.load("app");
	private final static String JETTY_IP = config.getString("app.jetty.ip");
	private final static int JETTY_PORT = config.getInt("app.jetty.port");

	public static void main(String[] args) {
		ResourceConfig config = new ResourceConfig().packages("com.cjla.rest").register(JacksonFeature.class)
				.register(new BackendBinder()).register(RolesAllowedDynamicFeature.class);

		ServletHolder servlet = new ServletHolder(new ServletContainer(config));
		InetSocketAddress addr = new InetSocketAddress(JETTY_IP, JETTY_PORT);

		Server server = new Server(addr);
		ServletContextHandler context = new ServletContextHandler(server, "/*");
		context.addServlet(servlet, "/*");

		try {
			try {
				server.start();
			} catch (Exception e) {
				LOGGER.error(e.getLocalizedMessage(), e);
			}
			try {
				server.join();
			} catch (InterruptedException e) {
				LOGGER.error(e.getLocalizedMessage(), e);
			}
		} finally {
			server.destroy();
			
		}
	}
}
