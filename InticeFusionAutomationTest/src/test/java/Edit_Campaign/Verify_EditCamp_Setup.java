package Edit_Campaign;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import Campaigns.Edit_Campaign;
import Utilities.TestUtil;

public class Verify_EditCamp_Setup extends Page 
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_EditCamp_Setup"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"regression","createdynamic"})
	public void verify_Camp_Setup_InEdit(String campaignname,String listname, String startdate, String enddate, String landingpageurl, String campaigncontent, 
			String campaignsource, String campaignmedium, String campaignterm, String landingcampaignname)
	{
		Edit_Campaign edit_Camp=new Edit_Campaign();
		
		edit_Camp.campaign_Setup(campaignname, listname, startdate, enddate, landingpageurl, campaigncontent, campaignsource, campaignmedium, campaignterm, landingcampaignname);
		
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Verify_EditCamp_Setup");
	}
}
