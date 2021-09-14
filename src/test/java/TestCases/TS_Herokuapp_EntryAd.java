package TestCases;

import org.testng.annotations.Test;

import com.Demo.ApplicationLibrary.ApplicationLibraryTest;
import com.Demo.Pages.Herokuapp;
import com.Demo.Utills.Constants;

public class TS_Herokuapp_EntryAd extends ApplicationLibraryTest {


	Herokuapp  he;
  @Test(groups="FormAuthentication")
  public void testCase8()
  {
	    he = new  Herokuapp(driver);
	    int flag=0;
		//SetBrowserAndNavigateToUrl(Constants.Chrome,Constants.herokuapp_Url);
		clickElement(he.lnkEntryAd);
		do
		{
		  if(verifyElementExist(he.unAvailablePopupWindow)!=null)
		  {
			  clickElement(he.clickHere);
			  waitForPageLoad();
			  Delay(500);
		  }
		if (verifyElementExist(he.availablePopupWindow)!=null)
		{
			clickElement(he.btnCloseModel);
			waitForPageLoad();
			Delay(500);
		    flag++;
		    System.out.println("Count::"+flag);
		}
		else 
			clickElement(he.clickHere);
		    waitForPageLoad();
		    Delay(500);
		  
		}while(flag<30);
		
		
		System.out.println("End..");
	  
  }
}
