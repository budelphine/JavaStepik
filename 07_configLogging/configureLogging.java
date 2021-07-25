// package org.stepic.java.logging;
import java.util.logging.*;

public class configureLogging {
	public static void configureLogging () {

			Logger LOGGER_A = Logger.getLogger("org.stepic.java.logging.ClassA");
			LOGGER_A.setLevel(Level.ALL);

			Logger LOGGER_B = Logger.getLogger("org.stepic.java.logging.ClassB");
			LOGGER_B.setLevel(Level.WARNING);

			Logger LOGGER_ALL = Logger.getLogger("org.stepic.java");
			LOGGER_ALL.setLevel(Level.ALL);
			LOGGER_ALL.setUseParentHandlers(false);

			Formatter xmlFormatter = new XMLFormatter();
			Handler consoleHandler = new ConsoleHandler();
			consoleHandler.setLevel(Level.ALL);
			consoleHandler.setFormatter(xmlFormatter);
			LOGGER_ALL.addHandler(consoleHandler);
		}
	
	public static void main (String[] args) {
		configureLogging();
	}
}
