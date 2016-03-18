package Create_Dynamic_Campaigns;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.TestUtil;
import Base.Page;
import Campaigns.Dynamic_Customize_Template;

public class Verify_Banner_300250 extends Page 
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Banner_300250"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"bvt","regression"})
	public void verify_300250_Banner(String background, String logo, String header, String button1, String button2) throws IOException, InterruptedException
	{
		Dynamic_Customize_Template cust_Template = new Dynamic_Customize_Template();
		
		cust_Template.Banner_300250(background, logo, header, button1, button2);
		TestUtil.CaptureScreenshot();
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Verify_Banner_300250");
		
		
	}
}
