package Campaigns;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.TestUtil;
import Base.Page;
import Campaigns.Campaigns;

public class Verify_Campaign_Table extends Page
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Campaign_Table"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"bvt", "regression"})
	public void verify_Campaign_Table(String inProgressTab, String liveTab, String completedTab )
	{
		Campaigns camp_Tab = new Campaigns();
		camp_Tab.campaign_Table(inProgressTab, liveTab, completedTab);
		
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Verify_Campaign_Table");
	}
}
