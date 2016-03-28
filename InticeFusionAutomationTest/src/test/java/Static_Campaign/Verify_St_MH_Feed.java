package Static_Campaign;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import Campaigns.Preview;
import Static_Campaigns.Static_MH_Feed;
import Utilities.TestUtil;

public class Verify_St_MH_Feed extends Page 
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_St_MH_Feed"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"bvt","regression", "test", "createstatic","reg"})
	public void verify_St_MH_Feed(String campaignName, String file1) throws IOException, InterruptedException
	{
		Static_MH_Feed st_MHF = new Static_MH_Feed();
		st_MHF.verify_MH_Feed(campaignName, file1);
		
		TestUtil.CaptureScreenshot();
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Verify_St_MH_Feed");
		
		
	}
}
