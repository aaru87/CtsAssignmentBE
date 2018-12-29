package org.rebo.statementprocessor.model;

import java.util.List;



import javax.xml.bind.annotation.XmlAttribute;

import javax.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlRootElement;




                @XmlRootElement(name="records")

               

                public class TransactionStatements{

                               

                                @XmlElement(name = "record")

 

                    private List<TransactionStatement> transactionStatments = null;

 

               

 

                    public List<TransactionStatement> getTransactionStatement() {

 

                        return transactionStatments;

 

                    }

 

               

 

                    public void setTransactionStatement(List<TransactionStatement> transactionStatments) {

 

                        this.transactionStatments = transactionStatments;

 

                    }

                               

                }

