package Campaigns;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.TestUtil;
import Base.Page;

public class Verify_Campaign_Pagination extends Page
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Campaign_Pagination"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(groups={"bvt", "regression"})
	public void verify_Campaign_Pagination()
	{
		Campaigns camp = new Campaigns();
		camp.campaign_Pagination();
	}
	
	
	
}
