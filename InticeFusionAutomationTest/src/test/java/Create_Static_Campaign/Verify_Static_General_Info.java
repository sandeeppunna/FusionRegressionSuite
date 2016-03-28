package Create_Static_Campaign;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import Static_Campaigns.Create_Static_Campaign;
import Utilities.TestUtil;

public class Verify_Static_General_Info extends Page 
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Static_General_Info"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"bvt","regression", "test", "static","reg"})
	public void verify_Create_Dynamic_Campaign(String campaignname, String campaignname1, String startdate, 
			String startdate1, String enddate, String enddate1) throws IOException, InterruptedException
	{
		Create_Static_Campaign create_Static_Camp = new Create_Static_Campaign();
		
		create_Static_Camp.campaign_General_Info(campaignname, campaignname1, startdate, startdate1, enddate, enddate1);
		TestUtil.CaptureScreenshot();
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Verify_Static_General_Info");
		
		
	}
}
