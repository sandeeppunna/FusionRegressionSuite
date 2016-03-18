package Create_Generic_BackUp_Ads;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import Campaigns.Create_Generic_Ad;
import Utilities.TestUtil;

public class Verify_Landing_Page_URL extends Page 
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Landing_Page_URL"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"bvt","regression", "test"})
	public void verify_Landing_Page_url(String landingpageurl) throws IOException 
	{
		Create_Generic_Ad create_Gen_Ad = new Create_Generic_Ad();
		
		create_Gen_Ad.landing_Page_URL(landingpageurl);
		TestUtil.CaptureScreenshot();
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Verify_Landing_Page_URL");
		
		
	}
}
