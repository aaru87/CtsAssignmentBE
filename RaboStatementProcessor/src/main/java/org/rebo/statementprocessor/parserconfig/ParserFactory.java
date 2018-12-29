package org.rebo.statementprocessor.parserconfig;

import org.rebo.statementprocessor.parser.CsvFileParser;
import org.rebo.statementprocessor.parser.FileParser;
import org.rebo.statementprocessor.parser.XmlFileParser;

public class ParserFactory {

	
	private static FileParser statementFileParser;

    public static FileParser getReaderFactory(String fileName)

    {

           if(fileName.endsWith(".csv"))

                  return new CsvFileParser(fileName);

           else if(fileName.endsWith(".xml"))

                  return new XmlFileParser(fileName);

           return statementFileParser;

    }
}
