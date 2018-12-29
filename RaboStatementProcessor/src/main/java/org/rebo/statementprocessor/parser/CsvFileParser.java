/**
 * Author : Arumuga sankar Ramakrishnan
 * Date :29/12/2018
 * Description : This  class created for the purpose to parse the CSV file and get the individual Records.
 */


package org.rebo.statementprocessor.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.rebo.statementprocessor.model.TransactionStatement;
import org.rebo.statementprocessor.reportgenerator.ReportGenerator;
import org.rebo.statementprocessor.validator.RecordValidator;



public class CsvFileParser implements FileParser{
	
	private String filePath;

	 private static final String DEFAULT_DELEMITER=",";  

    public CsvFileParser(String filePath)

    {

           this.filePath=filePath;

    }

    
    
    @Override
	public boolean mapToRecord() {
		 
		

         

         try ( BufferedReader file = new BufferedReader(new FileReader(this.filePath))){
        	 
        	 String lineContent;
        	 RecordValidator validator=new RecordValidator();
        	 int i=0;
        	 while((lineContent=file.readLine())!=null)
        	 {
        		 
        		 if(i==0) {
        			 i++;
        			 continue;
        		 }
        		 String[] fieldData=lineContent.split(DEFAULT_DELEMITER);
        		 TransactionStatement statement=new TransactionStatement();
        		 statement.setTranactionReference(Long.parseLong(fieldData[0]));
        		 statement.setAccountNumber(fieldData[1]);
        		 statement.setDescription(fieldData[2]);
        		 statement.setStartBalance(Float.parseFloat(fieldData[3]));
        		 statement.setMutuation(fieldData[4]);
        		 statement.setEndBalance(Float.parseFloat(fieldData[5]));
        		 
        		 validator.validateAndReport(statement);
        	 }

             
        	 ReportGenerator reportGenerator=new ReportGenerator(validator);
             reportGenerator.generateReport();
                

    //System.out.println("ValidationContent"+validator.reportBuilder.toString());
return true;

} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (NumberFormatException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
         
        
		return false;
    }
}