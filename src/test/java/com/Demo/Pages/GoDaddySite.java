package com.Demo.Pages;
import com.Demo.Utills.Constants;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import com.Demo.ApplicationLibrary.ApplicationLibraryTest;




public class GoDaddySite extends  ApplicationLibraryTest
{
	//private WebDriver  driver;
	//private ApplicationLibraryTest appLib;
	//public static final String TC_1_Url = "https://www.godaddy.com/";
	
	public GoDaddySite(WebDriver   driver)
	{
		setDriver(driver);
	}
	
	public String getPageTitle()
	{
		String title = getDriver().getTitle();
		return title;
	}
	public void printTitleAndUrlofCurrentPage()
	{
	  System.out.println("PageTitle::"+getPageTitle());
	  System.out.println("Current Page URL::"+getCurrentPageURL());
	  
	}
	
	
//	public void TC01()
//	{
	
//	driver=appLib.invokeBrowser("chrome");
//	driver.manage().window().maximize();
	  //Dimension dm = new Dimension(450,630);
    //Setting the current window to that dimension
	//driver =appLib.getDriver();
	  //appLib.getDriver().manage().window().setSize(dm);
	//driver.get(TC_1_Url);
	//System.out.println(appLib.getPageTitle());
		
	//System.out.println(getCurrentPageURL());
	//getDriver().close();
	
	
//	public void TC01()
//	{
//	
////	driver=invokeBrowser("chrome");
////	driver.manage().window().maximize();
////	driver.get(TC_1_Url);
//	Dimension dm = new Dimension(450,630);
//    //Setting the current window to that dimension
//    getDriver().manage().window().setSize(dm);
//	System.out.println(getDriver().getTitle());
//	System.out.println(getCurrentPageURL());
//	getDriver().quit();
//	}
	

}
