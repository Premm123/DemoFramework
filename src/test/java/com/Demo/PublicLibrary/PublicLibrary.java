
package com.Demo.PublicLibrary;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.Demo.Utills.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;


public class PublicLibrary
{

	private WebDriver  driver;
	private static final Logger LOGGER = LogManager.getLogger(PublicLibrary.class.getName());
	public HashMap<String, Object> chromePrefs= new HashMap<String, Object>();
	ChromeOptions chromeOptions = new ChromeOptions();
	FirefoxProfile profile = new FirefoxProfile();
	FirefoxOptions firefoxOption = new FirefoxOptions();
	
	
	public WebDriver  getDriver() {
		PageFactory.initElements(driver, this);
		return this.driver;
	}

	public void setDriver(WebDriver  driver1) {
		
		this.driver = driver1;
		PageFactory.initElements(driver1, this);
	}
//	/**
//	 * Method will launch browser with specified driver and URL
//	 * 
//	 * @param browserType
//	 *            : browser on which the script is going to be run
//	 * @param sUrl
//	 *            : url of the web applications
//	 */ 
//	public WebDriver SetBrowserAndNavigateToUrl(String browserType,String sUrl)
//	{
//		driver = invokeBrowser(browserType);
//		driver.get(sUrl);
//		driver.manage().window().maximize();
//		waitForPageLoad();
//		return driver;
//	}
	/**
	 * Method will close all tabs in a browser window
	 */ 
	
	public void closeBrowser()
	{
		driver.quit();
		LOGGER.info("Close all Tabs");
	}
	
	
	/**
	 * Method will launch browser with specified driver
	 * 
	 * @param browserType
	 *            : browser on which the script is going to be run
	 */ 
	public WebDriver invokeBrowser (String browserType)
	{
	try 
	{	
		if(Constants.Chrome.equals(browserType))
		{
		 
		  //System.setProperty("webdriver.chrome.driver",Constants.ChromeDriverPath);
			LOGGER.info("Initilize Chrome drive");
		  WebDriverManager.chromedriver().setup();
		  chromePrefs.put("download.default_directory",Constants.DownloadFolderPath);
		  chromeOptions.setExperimentalOption("prefs", chromePrefs);
		  driver = new ChromeDriver(chromeOptions);
		 // PageFactory.initElements(driver, this);
		   return driver;
		}
		else if(Constants.Firefox.equals(browserType))
		{
			LOGGER.info("Initilize Firefox drive");
			//System.setProperty("webdriver.gecko.driver",Constants.FirefoxDriverPath);
			WebDriverManager.firefoxdriver().setup();
			profile.setPreference("browser.download.folderList", 2);
			profile.setPreference("browser.download.dir",Constants.DownloadFolderPath);
			//profile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/csv,application/java-archive, application/x-msexcel,application/excel,application/vnd.openxmlformats-officedocument.wordprocessingml.document,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/vnd.microsoft.portable-executable");
			//profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/x-gzip");
			firefoxOption.setProfile(profile); 
			driver = new FirefoxDriver(firefoxOption);
			return driver;
			
		}
		else if(Constants.IE.equals(browserType))
		{
			LOGGER.info("Initilize IE drive");
			//System.setProperty("webdriver.ie.driver",Constants.IEDriverPath);
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			return driver;
			
		}
		else
			LOGGER.error("Invalid Browser type");
		
		
	}
	catch(Exception e) {System.out.println("Exception in invokeBrowser() "+ e);}
	return driver;
	}
	
	
	/**
	 * Method will get the current page of url
	 * 
	 */ 
	public String getCurrentPageURL()
	{
		String Cur_Url = driver.getCurrentUrl();
		return Cur_Url;
	}
	
	/**
	 * Method to verify element present on Page and verify whether duplicate elements exists or not
	 * 
	 * @param byVal
	 *            : Element locator
	 */
	public WebElement verifyElementExist(By byVal) {
		WebElement element = null;
		try {
			int size = driver.findElements(byVal).size();
			if (size != 0) {
				if (size == 1) {
					element = driver.findElement(byVal);
				} else {
					LOGGER.info("Duplicate elements");
				}
			}
		} catch (Exception e) {
			LOGGER.warn("Exception in verifyElementExist() "+ e);
		}
		return element;
	}
	
	/**
	 * Perform click on web element
	 * 
	 * @param byVal
	 *            : Element locator
	 */
	public WebElement clickElement (By byVal)
    {
		WebElement element = null;
       try {
              
    	   WebDriverWait wait = new WebDriverWait(driver,15);
    	   WebElement element1 =  wait.until(ExpectedConditions.visibilityOfElementLocated(byVal));
           Actions action = new Actions(driver);
           action.moveToElement(element1).click().perform();
           return element; 
          } 
       catch(Exception e) {LOGGER.warn("Exception in clickElement() "+ e);}
	return element;
    }
	
	/**
	 * Method will get the web element by locator
	 * 
	 * @param byVal
	 *            : Element locator
	 */
	public WebElement getWebElement(By byVal)
	{
		WebElement ele = driver.findElement(byVal);
		return ele;
		
	}
	/**
	 * Perform double click on web element
	 * 
	 * @param byVal
	 *            : Element locator to recognize the element
	 */
	public WebElement doubleClickElement (By byVal)
    {
		WebElement element = null;
       try {
              
    	   WebDriverWait wait = new WebDriverWait(driver,15);
    	   WebElement element1 =  wait.until(ExpectedConditions.visibilityOfElementLocated(byVal));
           Actions action = new Actions(driver);
           action.moveToElement(element1).doubleClick().perform();
           return element; 
          } 
       catch(Exception e) {System.out.println("Exception in doubleClickElement() "+ e);}
	return element;
    }
	
	/**
	 * Perform mouse hover on web element
	 * 
	 * @param byVal
	 *            : Element locator to recognize the element
	 */
	public void hoverMouseonElement(By byVal)
	{
		try {
	    	   WebDriverWait wait = new WebDriverWait(driver,15);
	    	   WebElement element =  wait.until(ExpectedConditions.visibilityOfElementLocated(byVal));
	           Actions action = new Actions(driver);
	           action.moveToElement(element).perform();
	               
	          } 
	       catch(Exception e) {System.out.println("Exception in hoverMouseonElement() "+ e);}
		
	}
	
	/**
	 * Waits the web driver until DOM loads
	 * 
	 * @param byVal
	 *            : Element locator to recognize the element
	 */
	public void waitForPageLoad()
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(webDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete"));
	}
	
	/**
	 * Methods sets value for drop down by index,value or visibleText,
	 * 
	 * @param byVal
	 *            : Element locator to recognize the element
	 * @param value
	 *            : by value of drop down or select box 
	 * @param selectType
	 *            : type of the select option either by index,vale or visibleText
	 *            : Use constants index,value or visibleText
	 **/
	public WebElement selectOptionDropdown(By byVal,Object value,String selectType) {
		WebElement element = null;
		try {
			
			element = verifyElementExist(byVal);
			Select select = new Select(element);
			if(selectType.equals(Constants.value))
			   select.selectByValue((String) value);
			else if(selectType.equals(Constants.index))
			     select.selectByIndex( (Integer) value);
			else if(selectType.equals(Constants.visibleText))
				select.selectByVisibleText((String) value);
			else
				System.out.println("Invalid select type");
			return element;
			
		} catch (Exception e) {
			System.out.println("Exception in selectValue()" + e);
			
		}
		return element;
	}
	/**
	 * Method sets value to text box after clicking and clearing
	 * 
	 * @param byVal
	 *            : Element locator to recognize the element
	 * @param sValue
	 *            : Value to be be entered in the element
	 */
	
	public WebElement setValue(By byVal, String sValue) {

		WebElement element = null;
		try {
			waitForElement(byVal);
			element = verifyElementExist(byVal);
			element.click();
			element.clear();
			element.sendKeys(sValue);
			System.out.println( sValue + " is entered");

		} catch (Exception e) {
			System.out.println("Exception in waitForElement()"+ e);
		}
		return element;
	}
	
	/**
	 * Method waits until element becomes visible, if element is not visible in 10 seconds then throws exception
	 * 
	 * @param byVal
	 *            : Element locator to recognize the element
	 */
	
	public boolean waitForElement(By byVal) {
		try 
		{
			WebDriverWait wait = new WebDriverWait(driver,10);
			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(byVal));
			if (ele!= null)
				System.out.println("Element is available");
				return true;	
			
		} catch (Exception e) 
		{
			System.out.println("Exception in waitForElement()" + e);
			
		}
		return false;
	}
	/**
	 * Method waits until element becomes invisible, if element is visible in 10 seconds then throws exception
	 * 
	 * @param byVal
	 *            : Element locator to recognize the element
	 */
	public boolean waitForElementIsInvisible(By byVal) {
		try 
		{
			WebDriverWait wait = new WebDriverWait(driver,10);
			//Boolean ele = wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(by)));
			Boolean isBool = wait.until(ExpectedConditions.invisibilityOfElementLocated(byVal));
				return isBool;	
			
		} catch (Exception e) 
		{
			System.out.println("Exception in waitForElementIsInvisible()" + e);
			
		}
		return false;
	}
	
	/**
	 * Method to getText from WebElement
	 * 
	 * @param byVal
	 *            : Element locator to recognize the element
	 */

	public String getText(By byVal) 
      {
		String sVal = null;
		try 
		{
			boolean isAvailable = waitForElement(byVal);
			if(isAvailable)
			{
			 WebElement element = verifyElementExist(byVal);
			 sVal = element.getText().trim();
			}
			
		} catch (Exception e) {
			System.out.println("Exception in getText()" + e);
		}
		return sVal;
      }
	
	/**
	 * Method to validate element text and actual text
	 * 
	 * @param byVal
	 *            : Element locator to recognize the element
	 * @param sTxt
	 *            : Value actually present in web element           
	 *            
	 */
	public void validateElementText(By byVal,String sTxt)
	{
		String getTextFromElement = getText(byVal);
		if(getTextFromElement.contains(sTxt.trim()))
				System.out.println("Element text \""+sTxt+"\" is matched successfully");
		else
			System.out.println("Missmatch element text \""+ getTextFromElement+ "\" with given \""+sTxt+"\"");
	}
	
	/**
	 * Method to get the color of an element
	 * 
	 * @param byVal
	 *            : Element locator to recognize the element
	 * @param cssAttribute
	 *            : CSS attribute          
	 *            
	 */
	public String GetColor(By byVal,String cssAttribute)
	{

		String rgb[] = driver.findElement(byVal).getCssValue(cssAttribute).replaceAll("(rgba)|(rgb)|(\\()|(\\s)|(\\))","").split(",");
		String hex = String.format("#%s%s%s", toBrowserHexValue(Integer.parseInt(rgb[0])), toBrowserHexValue(Integer.parseInt(rgb[1])), toBrowserHexValue(Integer.parseInt(rgb[2])));
        return hex;
		
	}
	/**
	 * Method will parse the rgb integer value to hex value
	 * 
	 * @param number
	 *            : integer values of rgb       
	 *            
	 */
	public String toBrowserHexValue(int number) {
        StringBuilder builder = new StringBuilder(Integer.toHexString(number & 0xff));
        while (builder.length() < 2) {
            builder.append("0");
        }
        return builder.toString();
    }
	
	/**
	 * Method will accept the alert    
	 *            
	 */
	
	public void acceptAlert()
	{
		try 
		{
		   driver.switchTo().alert().accept();
		}
		catch (Exception e) 
		{
			System.out.println("Exception in acceptAlert()" + e);
		}
	}
	/**
	 * Method will dismiss the alert    
	 *            
	 */
	public void dismissAlert()
	{
		try 
		{
		   driver.switchTo().alert().dismiss();
		}
		catch (Exception e) 
		{
			System.out.println("Exception in dismissAlert()" + e);
		}
	}
	/**
	 * Method will get the text from alert    
	 *            
	 */
	public String getTextFromAlert()
	{
		String getTextFromAlert=null;
		try 
		{
			getTextFromAlert=driver.switchTo().alert().getText();
			return getTextFromAlert;
		}
		catch (Exception e) 
		{
			System.out.println("Exception in getTextFromAlert()" + e);
		}
		return getTextFromAlert;
	}
	/**
	 * Method to wait the web driver for given amount of time
	 * 
	 * @param waitInMilliSecs
	 *                   : Number of milli seconds to wait
	 */
	public void Delay(int waitInMilliSecs)
	{
		driver.manage().timeouts().implicitlyWait(waitInMilliSecs, TimeUnit.MILLISECONDS);
	}
	
	/**
	 * Method will upload a file 
	 * 
	  * @param byVal
	 *            : Element locator to recognize the element
	 * @param fileName
	 *            : name of a file which is present the suite (Under this folder Resources/Data)          
	 */
	public void fileUpload(By byVal,String fileName)
	{
		try 
		{
			 WebElement uploadElement = driver.findElement(byVal);
			 Path filePath = Paths.get(Constants.path, "src","Resources", "Data",fileName);
			 //WebElement element = clickElement(byVal);
			 System.out.println(filePath.toString());
			 uploadElement.sendKeys(filePath.toString());
		}
		catch (Exception e) 
		{
			System.out.println("Exception in fileUpload()" + e);
		}
		
	}
	/**
	 * Method will download a file and stored in a default directory (Under this folder Resources/Downloads)
	 * 
	 * @param fileName
	 *            : Name of a file which you want to download      
	 */
	public boolean isFileDownloaded(String fileName)
	{
		try {
			
	    final int SLEEP_TIME_MILLIS = 1000;
	    File file = new File(Constants.DownloadFolderPath+File.separator+fileName);
	    final int timeout = 60* SLEEP_TIME_MILLIS;
	    int timeElapsed = 0;
	    while (timeElapsed<timeout)
	    {
	    	
	        if (file.exists()) {
	            System.out.println(fileName + " is present");
	            return true;
	        } else {
	            timeElapsed +=SLEEP_TIME_MILLIS;
	            Thread.sleep(SLEEP_TIME_MILLIS);
	        }
	    }
		}
		catch (Exception e) 
		{
			System.err.println("Exception in isFileDownloaded()" + e);
		}
		
	    return false;
	}
	/**
	 * Method will remove all the files in the directory
	 * 
	 * @param directoryPath
	 *                   : path of the diretory    
	 */
	public void cleanDirectory(String directoryPath)
	{
		try {
		File directory = new File(directoryPath);
		File[] files = directory.listFiles();
		for (File file : files)
		{
		if (!file.delete())
		 {
			System.err.println("Failed to delete "+file);
		 }
		}
		}
		catch (Exception e) 
		{
			System.err.println("Exception in cleanDirectory()" + e);
		}
	}
	
	/**
	 * Method to switch to the specified frame in html DOM.
	 * 
	 *   @param byVal
	 *            : Element locator to recognize the element
	 */
	public void switchToFrame(By byVal)
	{
		try 
		{
			WebElement frame = driver.findElement(byVal);
			driver.switchTo().frame(frame);
			
		}
		catch(Exception e)
		{
			System.err.println("Exception in switchToFrame()" + e);
		}
	}
	
	public void failed()
	{
			
		File srcFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		try
		{
			FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+File.separator+"Screenshots/testfailure.jpg"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
	}

		
	
	
	
}
