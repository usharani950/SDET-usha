package com.vtiger.generic;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	

	WebDriver driver;
	
	
	
	/**
	 * @author usha
	 * Maximize the browser window
	 */
   
	public void maximizewindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	
	/**
	 * @author usha
	 * Wait until page is loaded
	 * @param driver
	 */
	
	public void implicitwait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(IConstants.implicitwaittime, TimeUnit.SECONDS);
	}
	
	
	
	/**
	 * @author usha
	 * Wait until Given element is clickable
	 * @param driver
	 * @param element
	 */
	
	public void elementisclickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,IConstants.explixitwaittime);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	/**
	 * @author usha
	 * Select element from dropdown by visible text
	 * @param element
	 * @param visibletext
	 */
	
	public void selectdropdown(WebElement element,String visibletext)
	{
		
		Select select=new Select(element);
		select.selectByVisibleText(visibletext);
	}
	
	
	
	/**
	 * @author usha
	 * Select element from dropdown by index
	 * @param element
	 * @param index
	 */
	
	public void selectdropdown(WebElement element,int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
		
	}
	
	
	
	
	/**
	 * @author usha
	 * Select element from dropdown by value
	 * @param element
	 * @param value
	 */
	
	public void selectdropdownbyvalue(WebElement element,String value)
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}
	
	
	
	/**
	 * @author usha
	 * Refresh the given page
	 * @param driver
	 */
	
	public void refresh(WebDriver driver)
	{
		driver.navigate().refresh();
	}
	
	
	
	/**
	 * @author usha
	 * Switch frame by index
	 * @param driver
	 * @param index
	 */
	
	
	public void switchframe(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	
	
	
	/**
	 * @author usha
	 * Switch frame by webelement
	 * @param driver
	 * @param frameElement
	 */
	
	public void switchframe(WebDriver driver,WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	
	
	
	
	/**
	 * @author usha
	 * Switch frame by name or id
	 * @param driver
	 * @param nameorId
	 */
	
	public void switchframe(WebDriver driver,String nameorId)
	{
		driver.switchTo().frame(nameorId);
	}
	
	
	
	/**
	 * @author usha
	 * Move to expected element
	 * @param driver
	 * @param element
	 */
	
	public void movetoelement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	
	
	/**
	 * @author usha
	 * Drag and Drop
	 * @param driver
	 * @param src
	 * @param dest
	 */
	
	public void draganddrop(WebDriver driver,WebElement src,WebElement dest)
	{
		Actions action=new Actions(driver);
		action.dragAndDrop(src, dest).perform();
	}
	
	
	
	
	/**
	 * @author usha
	 * Switch to Desired Windows
	 * @param driver
	 * @param windowtitleexp
	 */
	
    public void switchwindow(WebDriver driver,String windowtitleexp)
	{
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it= set.iterator();
		
		while(it.hasNext())
		{
			String winid=it.next();
			driver.switchTo().window(winid);
			String acttitle=driver.getTitle();
			if(acttitle.contains(windowtitleexp))
			{
				break;
			}
		}
	}
	
	
	
	
	/**
	 * @author usha
	 * Wait for element until it is displayed 
	 * @param element
	 * @throws InterruptedException
	 */
	


    public void waitforElement(WebElement element) throws InterruptedException
    {
    	int count=0;
    	
    	while(count<40)
    	
            try {
            	 
            	   element.isDisplayed();
            	   break;
            	   
                }
    	    catch(Exception e)
    	    {
    		       Thread.sleep(500);
    	           count++;
    	    }
     }
    
    
    /**
     * @author usha
     * Wait for element and available click on it
     * @param driver
     * @param xpath
     * @throws InterruptedException
     */
    

    public void waitandclick(WebDriver driver,String xpath) throws InterruptedException
    {
    	int count=0;
    	while(count<40)
    		try {
    			     driver.findElement(By.xpath(xpath)).click();
    		}
    	catch(Exception e) {
    		Thread.sleep(500);
    	}
      }
    }









