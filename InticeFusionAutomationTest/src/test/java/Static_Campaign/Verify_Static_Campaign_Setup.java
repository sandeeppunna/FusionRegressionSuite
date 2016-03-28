package Static_Campaign;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import Static_Campaigns.Create_Static_Campaign;
import Utilities.TestUtil;

public class Verify_Static_Campaign_Setup extends Page
{ 
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Static_Campaign_Setup"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"bvt","regression", "test", "createstatic","reg"})
	public void verify_Static_Campaign_Setup(String setupheader) throws IOException
	{
		Create_Static_Campaign create_Static_Camp = new Create_Static_Campaign();
		
		create_Static_Camp.campaign_Setup(setupheader);
		TestUtil.CaptureScreenshot();
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Verify_Static_Campaign_Setup");
		
		
	}
}
