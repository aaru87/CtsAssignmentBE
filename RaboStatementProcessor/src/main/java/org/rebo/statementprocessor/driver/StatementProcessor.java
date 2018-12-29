/**
 * Author : Arumuga sankar Ramakrishnan
 * Date :29/12/2018
 * Description : This class acts a driver for validating the XMl or CSV file.
 */

package org.rebo.statementprocessor.driver;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.rebo.statementprocessor.parser.FileParser;
import org.rebo.statementprocessor.parserconfig.ParserFactory;

public class StatementProcessor {
	/**
	 * logger instnace to log the events
	 */
	private final static Logger logger = Logger.getLogger(StatementProcessor.class);

	public static void main(String[] args) {

		try {
			if (!(args.length < 1)) {
				// logger.info("Process exited with insufficient arguments");

				logger.log(Level.INFO, "Provide sufficient parameters");
				System.out.println(" Usage : Specify the path of the file to generate the valdation");
				System.exit(0);
			}
			{
				logger.log(Level.INFO, "Process started");
				FileParser parser = ParserFactory.getReaderFactory(args[0]);
				parser.mapToRecord();
				logger.log(Level.INFO, "Process Ended");

			}

		} catch (Exception e) {
			logger.log(Level.ERROR, e.getMessage());
		}
	}
}