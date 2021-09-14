package TestCases;

import org.testng.annotations.Test;

import com.Demo.ApplicationLibrary.ApplicationLibraryTest;
import com.Demo.Pages.Herokuapp;
import com.Demo.Utills.Constants;

public class TS_Herokuapp_FileUplaodDownlaodAndFrames extends ApplicationLibraryTest {


	Herokuapp  he;
  @Test(priority = -1,groups="FileUplaodDownlaodAndFrames")
  public void testCase9()
  {
	  he = new  Herokuapp(driver);
	  he.uploadAndDownloadFiles();
	    
	  
  }
  @Test(priority = 2,dependsOnMethods = "herokuappNestedFrames",groups="FileUplaodDownlaodAndFrames")
  public void iframes()
  {
	  he = new  Herokuapp(getDriver());
	  he.iFrames();
  }
  
  @Test(groups="FileUplaodDownlaodAndFrames")
  public void herokuappNestedFrames()
  {
       he = new  Herokuapp(getDriver());
	  he.nestedFrames();
  }

}
