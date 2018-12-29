package org.rebo.statementprocessor.validator;

import java.util.HashSet;
import java.util.Set;

import org.rebo.statementprocessor.model.TransactionStatement;
import org.rebo.statementprocessor.util.Configuration;

public class RecordValidator {
	
	
	//public static String htmlContent="<html><body></body></html>";

    private  Set<Long>  personSet=new HashSet<Long>();

    public StringBuilder reportBuilder=new StringBuilder();
    
    private float MIN_BALANCE=Float.parseFloat(Configuration.getInstance().getPropertyByKey("MinimumBalance"));
    
    private static final String TABLE_DATA_START_TAG="<td>\n";
    private static final String TABLE_DATA_END_TAG="</td>\n";
    private static final String TABLE_ROW_START_TAG="<tr>\n";
    private static final String TABLE_ROW_END_TAG="</tr>\n";
    
    
    public void validateAndReport(TransactionStatement transacStatement)

    {

           boolean status=personSet.add(transacStatement.getTranactionReference());

          

           if(!status)

           {

           reportBuilder.append(TABLE_ROW_START_TAG+TABLE_DATA_START_TAG+transacStatement.getTranactionReference()+TABLE_DATA_END_TAG+TABLE_DATA_START_TAG+transacStatement.getDescription()+TABLE_DATA_END_TAG+TABLE_ROW_END_TAG);

           return;

           }

          

           if(transacStatement.getEndBalance()<=MIN_BALANCE)

           {
            
        	   reportBuilder.append(TABLE_ROW_START_TAG+TABLE_DATA_START_TAG+transacStatement.getTranactionReference()+TABLE_DATA_END_TAG+TABLE_DATA_START_TAG+transacStatement.getDescription()+TABLE_DATA_END_TAG+TABLE_ROW_END_TAG);
           

                  return;

           }

    }

}
