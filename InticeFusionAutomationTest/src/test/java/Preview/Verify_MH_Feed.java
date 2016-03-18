package Preview;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import Campaigns.Preview;
import Utilities.TestUtil;

public class Verify_MH_Feed extends Page
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_MH_Feed"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"bvt","regression", "test"})
	public void verify_MHFeed(String campaignName, String csvfile1, String file1, String file2) throws IOException, InterruptedException
	{
		Preview prev = new Preview();
		prev.verify_MightyHiveFeed(campaignName, csvfile1, file1, file2);
		
		TestUtil.CaptureScreenshot();
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Verify_MH_Feed");
		
		
	}

}
