package Create_Static_Campaign;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import Static_Campaigns.Create_Static_Campaign;
import Utilities.TestUtil;

public class Verify_St_Landing_Page_Details extends Page
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_St_Landing_Page_Details"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"bvt","regression", "test", "static","reg"})
	public void verify_Create_Dynamic_Campaign(String landingurl,String landingurl1, String campaigncontent, String campaigncontent1, String campaignsource, String campaignsource1, String campaignmedium, 
			String campaignmedium1, String campaignterm, String campaignterm1, String campaignname, String campaignname1) throws IOException, InterruptedException
	{
		Create_Static_Campaign create_Static_Camp = new Create_Static_Campaign();
		
		create_Static_Camp.campaign_Landing_Page_Details(landingurl, landingurl1, campaigncontent, campaigncontent1, campaignsource, campaignsource1, campaignmedium, campaignmedium1, campaignterm, campaignterm1, campaignname, campaignname1);
		TestUtil.CaptureScreenshot();
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Verify_St_Landing_Page_Details");
		
		
	}

}
