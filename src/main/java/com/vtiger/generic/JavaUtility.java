 package com.vtiger.generic;

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

}
