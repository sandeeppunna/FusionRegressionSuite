package Preview;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import Campaigns.Create_Dynamic_Campaign;
import Campaigns.Preview;
import Utilities.TestUtil;

public class Verify_Preview_Page extends Page
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Preview_Page"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"bvt","regression", "test"})
	public void verify_Create_Dynamic_Campaign(String campaignName) throws IOException, InterruptedException
	{
		Preview prev = new Preview();
		prev.total_Segment_count(campaignName);
		
		TestUtil.CaptureScreenshot();
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Verify_Preview_Page");
		
		
	}
}
