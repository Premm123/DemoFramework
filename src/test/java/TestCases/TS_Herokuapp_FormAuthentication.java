package TestCases;

import org.testng.annotations.Test;

import com.Demo.ApplicationLibrary.ApplicationLibraryTest;
import com.Demo.Pages.Herokuapp;
import com.Demo.Utills.Constants;

public class TS_Herokuapp_FormAuthentication extends ApplicationLibraryTest
{

	Herokuapp  he;
  @Test(groups="FormAuthentication")
  public void testcase5() 
  {

		     he = new  Herokuapp(driver);
		     clickElement(he.lnkFormAuth);
			 setValue(he.txtUsernane, he.username);
			 setValue(he.txtPassword, he.password);
			 clickElement(he.btnLogin);
			 validateElementText(he.successFlashMsg, "You logged into a secure area!");
			 String successBackbroundColor =  GetColor(he.successFlashMsg,"background-color");
			if (successBackbroundColor.equals(he.successMsgBackGroundColor))
				System.out.println("Background color matched successfully"); 
			else
				System.err.println("Background color of an element should be\""+ he.successMsgBackGroundColor+ "\" not \""+successBackbroundColor+"\"");
				
			 clickElement(he.btnLogout);
			 validateElementText(he.successFlashMsg, "You logged out of the secure area!");
			String successBorderColor =  GetColor(he.successFlashMsg,"border-color");
			if (successBorderColor.equals(he.successMsgborderColor))
				System.out.println("Border color matched successfully"); 
			else
				System.err.println("Border color of an element should be\""+ he.successMsgborderColor+ "\" not \""+successBorderColor+"\"");

		  
  }

}
