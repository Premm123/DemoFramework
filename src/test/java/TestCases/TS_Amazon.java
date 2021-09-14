package TestCases;

import org.testng.annotations.Test;

import com.Demo.ApplicationLibrary.ApplicationLibraryTest;
import com.Demo.Pages.AmazonSite;

 public class TS_Amazon extends ApplicationLibraryTest
 {

	 AmazonSite  as; 
	 
	 
  @Test(groups="Amazon")
  public void testcase2() 
  {
	  
	    as = new  AmazonSite(driver);
	    printTitleAndUrlofCurrentPage();
		as.SelectModule(as.amazonpay);
		as.SelectModule(as.bestSellers);
		as.SelectModule(as.mobiles);
		as.SelectModule(as.prime);
    
  }


}
