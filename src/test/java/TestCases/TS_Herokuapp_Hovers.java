package TestCases;

import org.testng.annotations.Test;

import com.Demo.ApplicationLibrary.ApplicationLibraryTest;
import com.Demo.Pages.Herokuapp;
import com.Demo.Utills.Constants;

public class TS_Herokuapp_Hovers extends ApplicationLibraryTest{


	Herokuapp  he;
  @Test(groups="Hovers")
  public void testCase7()
  {
	     he = new  Herokuapp(driver);
	     clickElement(he.lnkHover);
	     hoverMouseonElement(he.imageUserLocator(he.user1));
	     he.verifyNameandProfileOfaUser(he.user1);
	     hoverMouseonElement(he.imageUserLocator(he.user2));
	     he.verifyNameandProfileOfaUser(he.user2);
	     hoverMouseonElement(he.imageUserLocator(he.user3));
	     he.verifyNameandProfileOfaUser(he.user3);
	  
  }
}


