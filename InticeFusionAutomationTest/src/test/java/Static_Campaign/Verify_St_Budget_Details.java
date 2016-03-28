package Static_Campaign;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import Static_Campaigns.Create_Static_Campaign;
import Utilities.TestUtil;

public class Verify_St_Budget_Details extends Page 
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_St_Budget_Details"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"bvt","regression", "test"})
	public void verify_Static_Budget_Details(String sheetName, String budgetcostperrecord) throws IOException
	{
		Create_Static_Campaign create_Static_Camp = new Create_Static_Campaign();
		
		create_Static_Camp.campaign_Budget_Details(sheetName, budgetcostperrecord);
		TestUtil.CaptureScreenshot();
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Verify_St_Budget_Details");
		
		
	}
}
