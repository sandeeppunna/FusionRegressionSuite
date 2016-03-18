package Create_Dynamic_Campaigns;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.TestUtil;
import Base.Page;
import Campaigns.Create_Dynamic_Campaign;

public class Verify_General_Info extends Page
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_General_Info"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"bvt","regression","test"})
	public void verify_General_Information(String campaignname, String campaignname1, String startdate, String startdate1, String enddate,
													String enddate1 ) throws IOException, InterruptedException
	{
		Create_Dynamic_Campaign create_Dynamic_Camp = new Create_Dynamic_Campaign();
		
		create_Dynamic_Camp.campaign_General_Info(campaignname, campaignname1, startdate, startdate1, enddate, enddate1);
		TestUtil.CaptureScreenshot();
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Verify_General_Info");
		
		
	}
}
