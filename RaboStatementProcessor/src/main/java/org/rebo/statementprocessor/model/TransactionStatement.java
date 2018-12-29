/**
 * Author : Arumuga sankar Ramakrishnan
 * Date :29/12/2018
 * Description : This model class has been created to store the individual transactions.
 */

package org.rebo.statementprocessor.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="transactionStatement")
public class TransactionStatement {

	/*
	 *  variable to hold record reference
	 */
	 private long tranactionReference;
     
	 /**
	  * variable to hold user account number
	  */
     private String accountNumber;
     /**
      * Variable to hold transaction description
      */
     private   String description;
     /**
      * variable to hold mutuation   
      */
     private  String mutuation;
        /**
         * Variable to hold start balance
         */
     private float startBalance;
        
     /**
      * Variabe to hold end balance
      */
     private    float endBalance;
     

	public String getAccountNumber() {
		return accountNumber;
	}
    @XmlElement
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getDescription() {
		return description;
	}
	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}

	public String getMutuation() {
		return mutuation;
	}
	@XmlElement
	public void setMutuation(String mutuation) {
		this.mutuation = mutuation;
	}

	public float getStartBalance() {
		return startBalance;
	}
	@XmlElement
	public void setStartBalance(float startBalance) {
		this.startBalance = startBalance;
	}

	public float getEndBalance() {
		return endBalance;
	}
	@XmlElement
	public void setEndBalance(float endBalance) {
		this.endBalance = endBalance;
	}
	public long getTranactionReference() {
		return tranactionReference;
	}
	@XmlAttribute(name="reference")
	public void setTranactionReference(long tranactionReference) {
		this.tranactionReference = tranactionReference;
	}

        



}
