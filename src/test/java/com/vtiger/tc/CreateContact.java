package com.vtiger.tc;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.vtiger.generic.ExcelUtility;
import com.vtiger.generic.FileUtility;
import com.vtiger.generic.IConstants;
import com.vtiger.generic.JavaUtility;
import com.vtiger.generic.WebDriverUtility;

public class CreateContact {

	
	    FileUtility fu=new FileUtility();
	    ExcelUtility eu=new ExcelUtility();
		JavaUtility ju=new JavaUtility();
		WebDriverUtility wdu= new WebDriverUtility();
	
	
       
       @Test
       
       public void CreateContact() throws IOException {
    	   
    	   
    	   int randomnumber=ju.createRandomNumber();
   		
   		// Read Data from Property File
   		
   		String un=fu.readDataFromPropFile(IConstants.propfilepath, "username");
   		String pwd=fu.readDataFromPropFile(IConstants.propfilepath, "password");
   		String url=fu.readDataFromPropFile(IConstants.propfilepath, "url");
   		
          // Read Test Script Data from Excel
   		String firstnameDD=eu.readDatafromExcel("Sheet1", 0, 1);
   	    String name=eu.readDatafromExcel("Sheet1", 1, 1);
   		String firstname2=name+randomnumber;
   		String lastname=eu.readDatafromExcel("Sheet1", 2, 1);
   		
   		// All the Data of CreateContact
   		System.out.println(firstnameDD+" "+firstname2+" "+lastname);
    	      
    	   
		WebDriver driver=new ChromeDriver();
		wdu.maximizewindow(driver);
	    wdu.implicitwait(driver);
		driver.get(url);
		
		
    //  login to vtiger
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
		
	//  clicking contacts
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	
	// clicking CreateContact
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
	//  Entering into the CreateContact Details
		WebElement representing=driver.findElement(By.xpath("//select[@name='salutationtype']"));
		wdu.selectdropdown(representing ,firstnameDD);
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstname2);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	}

}


