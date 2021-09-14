package TestCases;

import org.testng.annotations.Test;

import com.Demo.ApplicationLibrary.ApplicationLibraryTest;
import com.Demo.Pages.Herokuapp;
import com.Demo.Utills.Constants;

public class TS_Herokuapp_JSAlerts extends ApplicationLibraryTest{


	Herokuapp  he;
  @Test
  public void testcase6()
  {
	     he = new  Herokuapp(driver);
	     clickElement(he.lnkJSAlerts);
		 clickElement(he.btnJSAlert);
		 acceptAlert();
		 clickElement(he.btnJSConfirm);
		 String textFromAlert =  getTextFromAlert();
		 System.out.println("Text in the alert::"+textFromAlert);
		 dismissAlert();
		 clickElement(he.btnJSConfirm);
		 acceptAlert();
	  
  }
}
