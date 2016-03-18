package Create_Dynamic_Campaigns;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.TestUtil;
import Base.Page;
import Campaigns.Create_Dynamic_Campaign;

public class Verify_Campaign_Setup extends Page
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Campaign_Setup"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"bvt","regression"})
	public void verify_Create_Dynamic_Campaign(String setupheader) throws IOException
	{
		Create_Dynamic_Campaign create_Dynamic_Camp = new Create_Dynamic_Campaign();
		
		create_Dynamic_Camp.campaign_Setup(setupheader);
		TestUtil.CaptureScreenshot();
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Verify_Campaign_Setup");
		
		
	}
}
