package TestCases;

import org.testng.annotations.Test;

import com.Demo.ApplicationLibrary.ApplicationLibraryTest;
import com.Demo.Pages.Herokuapp;
import com.Demo.Utills.Constants;

public class TS_Herokuapp_DynamicControls extends	ApplicationLibraryTest {

	Herokuapp he;
  @Test(groups="DynamicControls")
  public void testcase4() 
  {
	    he = new  Herokuapp(driver);
		clickElement(he.lnkDynamicControls);
		waitForElement(he.chkAChkBox);
		clickElement(he.btnRemove);
		boolean IsChkAvailable=	 waitForElementIsInvisible(he.chkAChkBox);
		if(IsChkAvailable)
			System.out.println("Chcek box is disappeared after clicking on Remove button");
		else
			System.err.println("Chcek box should be disappeared after clicking on Remove button");
		 validateElementText(he.txtChkMsg, "It's gone!");
		 clickElement(he.btnAdd);
		boolean IsChkAvailableAgain=	 waitForElement(he.chkAChkBox);
		if(IsChkAvailableAgain)
			System.out.println("Chcek box is appeared again after clicking on Add button");
		else
			System.err.println("Chcek box should be appeared after clicking on Add button");
		 validateElementText(he.txtChkMsg, "It's back!");
		 clickElement(he.btnEnable);
		 validateElementText(he.txtInputMsg,"It's enabled!");
		 clickElement(he.btnDisable);
		 validateElementText(he.txtInputMsg,"It's disabled!");
	  
	  
	 
  }
}
