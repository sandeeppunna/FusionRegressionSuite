package Create_Generic_BackUp_Ads;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.TestUtil;
import Base.Page;
import Campaigns.Create_Generic_Ad;

public class Verify_Backup_Checkbox extends Page 
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Backup_Checkbox"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(groups={"bvt","regression", "test"})
	public void verify_Backup_Checkbox() throws IOException, InterruptedException 
	{
		Create_Generic_Ad create_Gen_Ad = new Create_Generic_Ad();
		
		create_Gen_Ad.backup_Checkbox();
		
		TestUtil.CaptureScreenshot();
	}
	
}
