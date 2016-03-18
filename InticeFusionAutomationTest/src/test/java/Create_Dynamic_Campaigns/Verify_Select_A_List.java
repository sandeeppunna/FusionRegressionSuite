package Create_Dynamic_Campaigns;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.TestUtil;
import Base.Page;
import Campaigns.Create_Dynamic_Campaign;

public class Verify_Select_A_List extends Page
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Select_A_List"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"bvt","regression","test"})
	public void verify_Select_List(String dealername) throws IOException, InterruptedException
	{
		Create_Dynamic_Campaign create_Dynamic_Camp = new Create_Dynamic_Campaign();
		
		create_Dynamic_Camp.select_A_List(dealername);
		TestUtil.CaptureScreenshot();
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Verify_Select_A_List");
		
		
	}
}
