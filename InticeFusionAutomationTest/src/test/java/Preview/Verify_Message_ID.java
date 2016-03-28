package Preview;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import Campaigns.Preview;
import Utilities.TestUtil;

public class Verify_Message_ID extends Page
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Message_ID"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"bvt","regression", "test","createdynamic","reg"})
	public void verify_MessageID_In_MHF_and_CBF(String campaignName) throws IOException, InterruptedException
	{
		Preview prev = new Preview();
		prev.verify_MHFeedMessageID_With_CBFeed(campaignName);
		
		TestUtil.CaptureScreenshot();
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Verify_Message_ID");
		
		
	}	
}
