 package com.vtiger.generic;

import java.sql.Date;
import java.util.Random;

public class JavaUtility {
	
	
	/**
	 * @author usha
	 * @generate a random number
	 * @return random number till 10000
	 */
	
     public int createRandomNumber()
		{
			Random r =new Random();
			int randomnumber=r.nextInt(10000);
			return randomnumber;		
		}
     
     
   /**
    * @author usha
    * Provide Current System Date
    * @return
    */
     
     public String getCurrentSystemDate()
     {
    	 Date dateobj=new Date();
    	 String currentSysDate=dateobj.toString();
    	 return currentSysDate;
     }
     
     
     
     
     /**
      * @author usha
      * Provide Current Month
      * @return current month
      */
     
      public int getCurrentMont()
      {
    	 
    	  Date dateobj=new Date();
    	  return dateobj.getMonth(); 
    	  
   	  }
     
     
     
     
     /**
      * @author usha
      * Gives Current Date
      * @return date
      */
     
     public String getDate()
     { 
    	 
    	 Date dateobj=new Date();
    	 String currentSysDate=dateobj.toString();
    	 String arr[]=currentSysDate.split("");
    	 return arr[2];
    	 
     }
     
}
