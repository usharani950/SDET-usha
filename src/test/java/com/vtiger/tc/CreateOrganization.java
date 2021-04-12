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

import com.vtiger.generic.JavaUtility;

public class CreateOrganization {

	JavaUtility ju=new JavaUtility();
	
	
	@Test
	public void CreateOrg() throws IOException{
		
	    int randomnumber=ju.createRandomNumber();
		System.out.println(randomnumber);
		
		String orgname="TATASONS"+randomnumber;
		
		FileInputStream fis= new FileInputStream("../ushaautomation/commondata.properties");
		Properties prop =new Properties();
		prop.load(fis);
		
		String un=prop.getProperty("username");
		String password= prop.getProperty("password");
		String url=prop.getProperty("url");
		String browser=prop.getProperty("browser");
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(url);
		WebDriverWait wait=new WebDriverWait(driver,10);
		
   //  login to vtiger
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
//		driver.navigate().refresh();
//		
//	// clicking organization
//		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
//		
//	// clicking create new organization
//		WebElement createOrg=driver.findElement(By.xpath("//img[@title='Create Organization...']"));
//		wait.until(ExpectedConditions.elementToBeClickable(createOrg)).click();;
//		
//    //  Entering into the create new organization
//		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
//		driver.findElement(By.id("phone")).sendKeys("8675422345");
//		
//		Select industry= new Select(driver.findElement(By.xpath("//select[@name='industry']")));
//		industry.selectByValue("Banking");
//		
//		Select type=new Select(driver.findElement(By.xpath("//select[@name='accounttype']")));
//		type.selectByValue("Analyst");
//		
//		Select rating=new Select(driver.findElement(By.xpath("//select[@name='rating']")));
//		rating.selectByValue("Active");
//		
//	// click on save
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//		
//		driver.navigate().back();
//		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys("TATASONS");
//		
//		Select OrgName=new Select(driver.findElement(By.id("bas_searchfield")));
//		OrgName.selectByVisibleText("Organization Name");
//		
//		WebDriverWait wait1=new WebDriverWait(driver,10);
//		WebElement searchNow=driver.findElement(By.xpath("//input[@name='submit']"));
//		wait1.until(ExpectedConditions.elementToBeClickable(searchNow)).click();
	}
		
		
}		

		
		
	



	


