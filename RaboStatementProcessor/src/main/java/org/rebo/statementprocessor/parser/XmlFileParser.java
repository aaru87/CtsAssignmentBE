/**
 * Author : Arumuga sankar Ramakrishnan
 * Date :29/12/2018
 * Description : This  class created for the purpose to parse the XMl file and get the individual Records.
 */

package org.rebo.statementprocessor.parser;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.rebo.statementprocessor.model.TransactionStatement;
import org.rebo.statementprocessor.model.TransactionStatements;
import org.rebo.statementprocessor.reportgenerator.ReportGenerator;
import org.rebo.statementprocessor.validator.RecordValidator;

public class XmlFileParser implements FileParser {


    private String filePath;

   

    public XmlFileParser(String filePath)

    {

           this.filePath=filePath;

    }
	
	@Override
	public boolean mapToRecord() {
		 File file = new File(this.filePath);

         JAXBContext jaxbContext;

         try {

               // StatementEntryValidator validator=new StatementEntryValidator();

                jaxbContext = JAXBContext.newInstance(TransactionStatements.class);

                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

                TransactionStatements customer = (TransactionStatements) jaxbUnmarshaller.unmarshal(file);
                List<TransactionStatement> sat=customer.getTransactionStatement();
                RecordValidator validator=new RecordValidator();
                sat.forEach(element->validator.validateAndReport(element));
                ReportGenerator reportGenerator=new ReportGenerator(validator);
                reportGenerator.generateReport();
                              // validator.generateReport();
                System.out.println("ValidationContent"+validator.reportBuilder.toString());
         } catch (JAXBException e) {

                // TODO Auto-generated catch block

                e.printStackTrace();

         }



        

        



         return true;

        

  

	}

}
