package TestCases;

import org.testng.annotations.Test;

import com.Demo.ApplicationLibrary.ApplicationLibraryTest;
import com.Demo.Pages.Herokuapp;
import com.Demo.Utills.Constants;

public class TS_Herokuapp_Dropdown extends ApplicationLibraryTest
{

	Herokuapp  he;
  @Test(groups="Dropdown")
  public void testCase3()
  {
	    he = new  Herokuapp(driver);
		clickElement(he.lnkDropdown);
		selectOptionDropdown(he.dropdown, "1", Constants.value);
		selectOptionDropdown(he.dropdown, 2, Constants.index);
		selectOptionDropdown(he.dropdown, "Option 1", Constants.visibleText);
	  
  }
}
