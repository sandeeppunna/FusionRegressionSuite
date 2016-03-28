package Static_Campaign;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import Static_Campaigns.Static_Create_Generic_Ads;
import Utilities.TestUtil;

public class Verify_St_Generic_Ads extends Page
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_St_Generic_Ads"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"bvt","regression", "test", "createstatic","reg"})
	public void verify_Static_Generic_Ads(String background160600, String background72890, String background300250, String background32050) throws IOException, InterruptedException
	{
		Static_Create_Generic_Ads st_Generic_Ads= new Static_Create_Generic_Ads();
		
		st_Generic_Ads.create_Generic_Ad(background160600, background72890, background300250, background32050);
		TestUtil.CaptureScreenshot();
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Verify_St_Generic_Ads");
		
		
	}
}
