package Static_Campaign;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import Static_Campaigns.Static_Preview;
import Utilities.TestUtil;

public class Verify_Static_CB_Feed extends Page
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Static_CB_Feed"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"bvt","regression", "test", "createstatic","reg"})
	public void verify_Static_CB_Feed(String campaignName) throws InterruptedException, IOException
	{
		Static_Preview st_Preview = new Static_Preview();
		
		st_Preview.verify_CBFeed(campaignName);
		TestUtil.CaptureScreenshot();
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Verify_Static_CB_Feed");
		
		
	}
}
