package Create_Generic_BackUp_Ads;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.TestUtil;
import Base.Page;
import Campaigns.Create_Generic_Ad;

public class Create_BackUpAd extends Page 
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Create_BackUpAd"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"bvt","regression", "test"})
	public void verify_Backup_Ad(String textline1, String textline2, String textline3, String textline4) throws IOException, InterruptedException 
	{
		Create_Generic_Ad create_Gen_Ad = new Create_Generic_Ad();
		
		create_Gen_Ad.create_Back_Up(textline1, textline2, textline3, textline4);
		
		TestUtil.CaptureScreenshot();
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Create_BackUpAd");
		
	}
}
