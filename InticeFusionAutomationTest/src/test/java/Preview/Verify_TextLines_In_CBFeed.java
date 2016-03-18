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

public class Verify_TextLines_In_CBFeed extends Page
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_TextLines_In_CBFeed"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"bvt","regression"})
	public void verify_Preview_TextLines(String campaignName) throws IOException, InterruptedException
	{
		Preview prev = new Preview();
		prev.verify_TextLines_With_CBFeed(campaignName);
		TestUtil.CaptureScreenshot();
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Verify_TextLines_In_CBFeed");
		
		
	}
}
