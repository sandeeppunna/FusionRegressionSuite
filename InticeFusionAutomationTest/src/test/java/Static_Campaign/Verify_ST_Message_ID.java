package Static_Campaign;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import Static_Campaigns.Static_MH_Feed;
import Utilities.TestUtil;

public class Verify_ST_Message_ID extends Page
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_ST_Message_ID"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"bvt","regression", "test","createdynamic","reg"})
	public void verify_st_MessageID_In_MHF_and_CBF(String campaignName) throws IOException, InterruptedException
	{
		Static_MH_Feed st_msg_Id = new Static_MH_Feed();
		st_msg_Id.verify_MHFeedMessageID_With_CBFeed(campaignName);
			
		TestUtil.CaptureScreenshot();
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Verify_ST_Message_ID");
		
		
	}	
}
