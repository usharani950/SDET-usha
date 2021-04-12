package com.vtiger.tc;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Integration_CreateContact {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		WebDriverWait wait=new WebDriverWait(driver,10);
		
    //  login to vtiger
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
	//  clicking contacts
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	
	// clicking CreateContact
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
	//  Entering into the CreateContact Details
		Select firstName=new Select(driver.findElement(By.xpath("//select[@name='salutationtype']")));
		firstName.selectByVisibleText("Ms.");
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Usha");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Rani");
		
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		
		String mainId=driver.getWindowHandle();
		Set<String>allId=driver.getWindowHandles();
		
		for(String id:allId)
		{
			if(!mainId.equals(id))
					{
				         driver.switchTo().window(id);
				         driver.findElement(By.id("search_txt")).sendKeys("TATASONS");
				         driver.findElement(By.xpath("//input[@name='search']")).click();
				         driver.findElement(By.xpath("//a[text()='TATASONS']")).click();
					}
		}
		
		driver.switchTo().window(mainId);
	
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		



	}

}
