package com.Demo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.Demo.ApplicationLibrary.ApplicationLibraryTest;
import com.Demo.Utills.Constants;



public class Herokuapp extends	ApplicationLibraryTest
{

	public Herokuapp(WebDriver	driver)
	{
		setDriver(driver);
	}
	public By lnkDropdown = By.xpath("//li//a[normalize-space(text())='Dropdown']");
	public By dropdown = By.xpath("//select[@id='dropdown']");
	public By lnkDynamicControls = By.xpath("//li//a[normalize-space(text())='Dynamic Controls']");
	
	public By btnRemove = By.xpath("//form[@id='checkbox-example']//button[normalize-space(text())='Remove']");
	public By chkAChkBox = By.xpath("//form[@id='checkbox-example']//input[@type='checkbox']");
	public By txtChkMsg = By.xpath("//form[@id='checkbox-example']//p[@id='message']");
	public By btnAdd = By.xpath("//form[@id='checkbox-example']//button[normalize-space(text())='Add']");
	public By btnEnable = By.xpath("//form[@id='input-example']//button[normalize-space(text())='Enable']");
	public By btnDisable = By.xpath("//form[@id='input-example']//button[normalize-space(text())='Disable']");
	public By txtInputMsg = By.xpath("//form[@id='input-example']//p[@id='message']");
	//Form Authentication
	public By lnkFormAuth = By.xpath("//li//a[normalize-space(text())='Form Authentication']");
	public By txtUsernane = By.id("username");
	public By txtPassword = By.id("password");
	public By btnLogin = By.xpath("//button[@type='submit']");
	public By successFlashMsg = By.xpath("//div[@id='flash'][not(self::a)]");
	public By btnLogout  = By.xpath("//a[i[normalize-space(text())='Logout']]");
	public String username = "tomsmith";
	public String password = "SuperSecretPassword!";
	public String successMsgBackGroundColor = "#5da423";
	public String successMsgborderColor = "#457a1a";
	//JS alerts
	public By lnkJSAlerts = By.xpath("//li//a[normalize-space(text())='JavaScript Alerts']");
	public By btnJSAlert = By.xpath("//div[@class='example']//button[text()='Click for JS Alert']");
	public By btnJSConfirm = By.xpath("//div[@class='example']//button[text()='Click for JS Confirm']");
	//Hovers
	public By lnkEntryAd = By.xpath("//li//a[normalize-space(text())='Entry Ad']");
	public By btnCloseModel = By.xpath("//div[@class='modal-footer']/p[.='Close']");
	public By clickHere = By.xpath("//a[.='click here']");
	public By unAvailablePopupWindow = By.xpath("//div[@id='modal' and contains(@style,'display: none')]");
	public By availablePopupWindow = By.xpath("//div[@id='modal' and contains(@style,'display: block')]");
	//ENtry Ad
	public By lnkHover = By.xpath("//li//a[normalize-space(text())='Hovers']");
	public String user1 = "user1";
	public String user2 = "user2";
	public String user3 = "user3";
	
	//File Upload and Download
	public By lnkfileUpload = By.xpath("//li//a[normalize-space(text())='File Upload']");
	public By lnkfileDownload = By.xpath("//li//a[normalize-space(text())='File Download']");
	public By lnkNestedFrames = By.xpath("//li//a[normalize-space(text())='Nested Frames']");
	public By lnkFrames = By.xpath("//li//a[normalize-space(text())='Frames']");
	public By lnkIFrames = By.xpath("//li//a[normalize-space(text())='iFrame']");
	
	public By chooseFile = By.id("file-upload");
	public By bthUpload = By.id("file-submit");
	public String fileName = "fileUpload.jpg";
	public By fileUploaded= By.xpath("//div[@class='example']/h3");
	public By uploadedFileName = By.id("uploaded-files");
	public String downloadFileName = "//div[@class='example']//a[text()='";
	
	//Frames and IFrames
	
	public By topFrame = By.xpath("//frame[@name='frame-top']");
	public By bottomFrame = By.xpath("//frame[@name='frame-bottom']");
	public By leftFrame = By.xpath("//frame[@name='frame-left']");
	public By rightFrame = By.xpath("//frame[@name='frame-right']");
	public By middleFrame = By.xpath("//frame[@name='frame-middle']");
	public By body = By.xpath("//body");
	public By middleFrameContent  = By.xpath("//div[@id='content']");
	
	public By iFrameContent  = By.xpath("//body[@id='tinymce']//p");
	public By eleIFrame  = By.xpath("//iframe[@id='mce_0_ifr']");
	
	public void verifyNameandProfileOfaUser(String user)
	{
		String username= getText(userNameLocator(user));
		System.out.println(username);
		WebElement element = verifyElementExist(userProfileLocator(user));
		String userProfileLink = element.getAttribute("href");
		System.out.println("User Profile Link::"+userProfileLink);
		
	}
	
	
	public By imageUserLocator(String user)
	{
		By imgUser = By.xpath("//div[div[h5[text()='name: "+user+"']]]/img[@alt='User Avatar']");
		return imgUser;
		
	}
	public By userNameLocator(String user)
	{
		By nameOfUser = By.xpath("//div[@class='figcaption']//h5[text()='name: "+user+"']");
		return nameOfUser;
		
	}
	public By userProfileLocator(String user)
	{
		By userProfile = By.xpath("//div[@class='figcaption']//h5[text()='name: "+user+"']/following-sibling::a");
		return userProfile;
		
	}
	
	public void uploadAndDownloadFiles()
	{
		
		clickElement(lnkfileUpload);
		fileUpload(chooseFile, fileName);
		clickElement(bthUpload);
		validateElementText(fileUploaded, "File Uploaded!");
		validateElementText(uploadedFileName, fileName);
		
		getDriver().get(Constants.herokuapp_Url);
		clickElement(lnkfileDownload);
		doubleClickElement(By.xpath(downloadFileName+fileName+Constants.LocEnd));
		cleanDirectory(Constants.DownloadFolderPath);
		boolean isDownloaded = isFileDownloaded(fileName);
		if(isDownloaded)
			System.out.println("Downloaded Sucessfully..");
		else
			System.err.println("There is a problem in downloading a file..");
		getDriver().navigate().back();
	}
	public void nestedFrames()
	{
		
		getDriver().get(Constants.herokuapp_Url);
		clickElement(lnkNestedFrames);
		switchToFrame(topFrame);
		switchToFrame(leftFrame);
		System.out.println("Currently in "+getText(body)+ " frame");
		String ParentpageSource = getDriver().switchTo().parentFrame().getPageSource();
		System.out.println("ParentpageSource:: "+ParentpageSource);
		switchToFrame(rightFrame);
		System.out.println("Currently in "+getText(body)+ " frame");
		String DefaultpageSource = getDriver().switchTo().defaultContent().getPageSource();
		System.out.println("DefaultpageSource:: "+DefaultpageSource);
		switchToFrame(topFrame);
		switchToFrame(middleFrame);
		System.out.println("Currently in "+getText(middleFrameContent)+ " frame");
		ParentpageSource= getDriver().switchTo().defaultContent().getPageSource();
		System.out.println("DefaultpageSource:: "+DefaultpageSource);
		switchToFrame(bottomFrame);
		System.out.println("Currently in "+getText(body)+ "Frame");
		getDriver().navigate().back();
		
	}
	
	public void iFrames()
	{
		
		clickElement(lnkFrames);
		clickElement(lnkIFrames);
		switchToFrame(eleIFrame);
		System.out.println("Text inside Iframe is "+getText(iFrameContent));
		WebElement ele= setValue(iFrameContent,"abc");
		ele.sendKeys(Keys.BACK_SPACE);
		getDriver().navigate().back();
		
		
	}


}
