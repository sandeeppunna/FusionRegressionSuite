package Static_Campaign;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Page;
import Static_Campaigns.Static_Create_Generic_Ads;
import Utilities.TestUtil;

public class Verify_With_Out_Creating_Gereric_ClickON_Next extends Page 
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_With_Out_Creating_Gereric_ClickON_Next"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(groups={"bvt","regression", "test", "createstatic","reg"})
	public void verify_with_Out_Creating_Gereric_ClickON_Next() throws IOException, InterruptedException
	{
		Static_Create_Generic_Ads st_Generic_Ads= new Static_Create_Generic_Ads();
		
		st_Generic_Ads.with_Out_Creating_Gereric_ClickON_Next();
		
		TestUtil.CaptureScreenshot();
	}
	
}	
