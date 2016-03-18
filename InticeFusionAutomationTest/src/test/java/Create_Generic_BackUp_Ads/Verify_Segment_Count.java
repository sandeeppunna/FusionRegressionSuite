package Create_Generic_BackUp_Ads;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import Utilities.TestUtil;
import Base.Page;
import Campaigns.Create_Generic_Ad;

public class Verify_Segment_Count extends Page
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Segment_Count"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getRowCount", groups={"bvt","regression", "test"})
	public void verify_Segment_Count_In_Create_Generic_Ad(String sheetName) throws IOException 
	{
		Create_Generic_Ad create_Gen_Ad = new Create_Generic_Ad();
		
		create_Gen_Ad.segment_Count(sheetName);
		TestUtil.CaptureScreenshot();
	}
	
	@DataProvider
	public static int getRowCount()
	{
		return TestUtil.getRowCount("Verify_Segment_Count");
		
		
	}
}
