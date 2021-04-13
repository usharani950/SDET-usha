package com.vtiger.tc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.vtiger.generic.ExcelUtility;
import com.vtiger.generic.FileUtility;
import com.vtiger.generic.IConstants;
import com.vtiger.generic.JavaUtility;
import com.vtiger.generic.WebDriverUtility;

public class CreateOrganization {
	
    FileUtility fu=new FileUtility();
    ExcelUtility eu=new ExcelUtility();
	JavaUtility ju=new JavaUtility();
	WebDriverUtility wdu= new WebDriverUtility();
	
	
	@Test
	public void CreateOrg() throws IOException{
		
	    int randomnumber=ju.createRandomNumber();
		
		// Read Data from Property File
		
		String un=fu.readDataFromPropFile(IConstants.propfilepath, "username");
		String pwd=fu.readDataFromPropFile(IConstants.propfilepath, "password");
		String url=fu.readDataFromPropFile(IConstants.propfilepath, "url");
		
       // Read Test Script Data from Excel
		String name=eu.readDatafromExcel("Sheet1", 0, 0);
		String orgname=name+randomnumber;
		String phonenumber=eu.readDatafromExcel("Sheet1", 1, 0);
		String indDD=eu.readDatafromExcel("Sheet1", 2, 0);
        String typeDD= eu.readDatafromExcel("Sheet1",3, 0);
		String ratingDD= eu.readDatafromExcel("Sheet1", 4, 0);
		
		// All the Data of Org
		System.out.println(name+" "+orgname+" "+phonenumber+" "+indDD+" "+ratingDD+" "+typeDD);
		
		
		WebDriver driver=new ChromeDriver();
		wdu.maximizewindow(driver);
		wdu.implicitwait(driver);
		driver.get(url);
		
		
   //  login to vtiger
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
		
		wdu.refresh(driver);
		
	// clicking organization
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		
		
		wdu.refresh(driver);
		
	// clicking create new organization
	//	WebElement createOrg=
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();;
		//wdu.elementisclickable(driver, createOrg);
		
    //  Entering into the create new organization
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
		driver.findElement(By.id("phone")).sendKeys(phonenumber);
	
		WebElement industry= driver.findElement(By.xpath("//select[@name='industry']"));
		wdu.selectdropdownbyvalue(industry, indDD);
		
		WebElement type=driver.findElement(By.xpath("//select[@name='accounttype']"));
	    wdu.selectdropdownbyvalue(type, typeDD);
		
		WebElement rating=driver.findElement(By.xpath("//select[@name='rating']"));
		wdu.selectdropdownbyvalue(rating,  ratingDD);
		
	// click on save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
//		driver.navigate().back();
//		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys("TATASONS");
//	
//		Select OrgName=new Select(driver.findElement(By.id("bas_searchfield")));
//		OrgName.selectByVisibleText("Organization Name");
//		
//		WebDriverWait wait1=new WebDriverWait(driver,10);
//		WebElement searchNow=driver.findElement(By.xpath("//input[@name='submit']"));
//	wait1.until(ExpectedConditions.elementToBeClickable(searchNow)).click();
	}
		
		
}		

		
		
	



	


