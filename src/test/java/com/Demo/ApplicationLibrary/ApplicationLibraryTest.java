package com.Demo.ApplicationLibrary;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Demo.PublicLibrary.PublicLibrary;

public class ApplicationLibraryTest extends PublicLibrary
{
	private static final Logger LOGGER = LogManager.getLogger(ApplicationLibraryTest.class.getName());
	 public WebDriver  driver;
	 //Herokuapp	he = new  Herokuapp(getDriver());
	
	 /**
		 * Method will launch browser with specified driver and URL
		 * 
		 * @param browserType
		 *            : browser on which the script is going to be run
		 * @param sUrl
		 *            : url of the web applications
	  **/ 
	@Parameters ({"browserType","sUrl"})
    @BeforeClass
	public WebDriver SetBrowserAndNavigateToUrl1(String browserType,String sUrl)
	{
		driver=invokeBrowser(browserType);
		getDriver().get(sUrl);
		getDriver().manage().window().maximize();
		waitForPageLoad();
		setDriver(driver);
		return getDriver();
	}
	
	
	/**
	 * Method will close all tabs in a browser window
	 */ 
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
	
	
	  
	
	public void printTitleAndUrlofCurrentPage()
	{
	  System.out.println("Current Page URL::"+getCurrentPageURL());
	}
	
	
}


