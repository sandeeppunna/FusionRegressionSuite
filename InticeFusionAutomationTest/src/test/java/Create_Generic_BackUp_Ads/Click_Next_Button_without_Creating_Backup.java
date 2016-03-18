package Create_Generic_BackUp_Ads;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.TestUtil;
import Base.Page;
import Campaigns.Create_Generic_Ad;

public class Click_Next_Button_without_Creating_Backup extends Page 
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Click_Next_Button_without_Creating_Backup"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(groups={"bvt","regression", "test"})
	public void verify_Next_Button_Without_Creating_Backup_Ad() throws IOException, InterruptedException 
	{
		Create_Generic_Ad create_Gen_Ad = new Create_Generic_Ad();
		
		create_Gen_Ad.click_On_Next_If_BackUp_Ad_Not_Created();
		TestUtil.CaptureScreenshot();
	}
}
