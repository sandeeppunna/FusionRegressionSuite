package Static_Campaign;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import Static_Campaigns.Create_Static_Campaign;
import Utilities.TestUtil;

public class Verify_Create_Static_Campaign extends Page
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Create_Static_Campaign"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"bvt","regression", "test", "createstatic","reg"})
	public void verify_Create_Static_Campaign(String headername) throws IOException
	{
		Create_Static_Campaign create_Static_Camp = new Create_Static_Campaign();
		
		create_Static_Camp.create_Static_Campaign(headername);
		TestUtil.CaptureScreenshot();
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Verify_Create_Static_Campaign");
		
		
	}
}
