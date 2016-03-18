package Create_Dynamic_Campaigns;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.TestUtil;
import Base.Page;
import Campaigns.Create_Dynamic_Campaign;

public class Verify_Select_Template extends Page 
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Select_Template"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(groups={"bvt","regression","test"})
	public void verify_Select_Template() throws IOException
	{
		Create_Dynamic_Campaign create_Dynamic_Camp = new Create_Dynamic_Campaign();
		
		create_Dynamic_Camp.select_Template();
		TestUtil.CaptureScreenshot();
	}
}
