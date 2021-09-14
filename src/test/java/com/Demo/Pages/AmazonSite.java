package com.Demo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Demo.ApplicationLibrary.ApplicationLibraryTest;


public class AmazonSite extends ApplicationLibraryTest
{
	
	private ApplicationLibraryTest appLib;
	
	public AmazonSite(WebDriver   driver)
	{
		setDriver(driver);
		
	}
	
	//private String TC_2_Url = "http://www.amazon.in";
	public By amazonpay = By.xpath("//div[@id='nav-xshop-container']//a[normalize-space(text())='Amazon Pay']");
	public By	bestSellers = By.xpath("//div[@id='nav-xshop-container']//a[normalize-space(text())='Best Sellers']");
	public By	mobiles = By.xpath("//div[@id='nav-xshop-container']//a[normalize-space(text())='Mobiles']");
	public By	prime = By.xpath("//div[@id='nav-xshop-container']//a[span[normalize-space(text())='Prime']]");
	

	public void SelectModule(By ModuleName)
	{
		clickElement(ModuleName);
		waitForPageLoad();
		printTitleAndUrlofCurrentPage();
	}
	

}
