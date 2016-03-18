package Create_Dynamic_Campaigns;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.TestUtil;
import Base.Page;
import Campaigns.Create_Dynamic_Campaign;

public class Verify_Landing_Page_Details extends Page
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Landing_Page_Details"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"bvt","regression","test"})
	public void verify_Landing_Page(String landingurl, String landingurl1, String campaigncontent, String campaigncontent1, 
									String campaignsource, String campaignsource1, String campaignmedium, String campaignmedium1,
									String campaignterm, String campaignterm1, String campaignname, String campaignname1) throws IOException, InterruptedException
	{
		Create_Dynamic_Campaign create_Dynamic_Camp = new Create_Dynamic_Campaign();
		
		create_Dynamic_Camp.campaign_Landing_Page_Details(landingurl, landingurl1, campaigncontent,campaigncontent1, campaignsource,campaignsource1, campaignmedium, campaignmedium1, campaignterm, campaignterm1, campaignname, campaignname1);
		TestUtil.CaptureScreenshot();
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Verify_Landing_Page_Details");
		
		
	}
}
