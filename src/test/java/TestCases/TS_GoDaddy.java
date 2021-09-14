package TestCases;

import com.Demo.ApplicationLibrary.ApplicationLibraryTest;
import com.Demo.Pages.GoDaddySite;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;

public class TS_GoDaddy extends ApplicationLibraryTest
{

  @Test(groups="GoDaddy")
  public void testCase1() 
  {
    
    GoDaddySite  go = new  GoDaddySite(driver);
    Dimension dm = new Dimension(450,630);
    //Setting the current window to that dimension
    getDriver().manage().window().setSize(dm);
    System.out.println(go.getPageTitle());
    System.out.println(go.getCurrentPageURL());
   // assertEquals(false, true);
  }
  
}
