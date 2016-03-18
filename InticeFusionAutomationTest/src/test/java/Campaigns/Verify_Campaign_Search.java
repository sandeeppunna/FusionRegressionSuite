package Campaigns;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.TestUtil;
import Base.Page;

public class Verify_Campaign_Search extends Page
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
	public void verify_Campaign_Search(String campaignname)
	{
		Campaigns camp = new Campaigns();
		camp.search_Campaign(campaignname);
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Verify_Campaign_Search");
	}
	
}
