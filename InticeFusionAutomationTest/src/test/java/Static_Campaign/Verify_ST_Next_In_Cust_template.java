package Static_Campaign;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import Static_Campaigns.Create_Static_Campaign;
import Static_Campaigns.Static_Customize_Template;
import Utilities.TestUtil;

public class Verify_ST_Next_In_Cust_template extends Page 
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_ST_Next_In_Cust_template"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"bvt","regression", "test", "createstatic","reg"})
	public void verify_Static_Next_IN_Customize_Template(String background160600, String background72890, String background300250, String background32050) throws IOException, InterruptedException
	{
		Static_Customize_Template st_Cust= new Static_Customize_Template();
		
		st_Cust.verify_Next_Button(background160600, background72890, background300250, background32050);
		TestUtil.CaptureScreenshot();
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Verify_ST_Next_In_Cust_template");
		
		
	}
}
