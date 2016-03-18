package Create_Generic_BackUp_Ads;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.TestUtil;
import Base.Page;
import Campaigns.Create_Generic_Ad;

public class Verify_Text_Lines extends Page
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Text_Lines"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"bvt","regression", "test"})
	public void verify_Text_Lines_In_Create_Generic_Ad(String textline1, String textline2, String textline3, String textline4, String textline5,
						String textline6, String textline7, String textline8, String textline9, String textline10) throws IOException 
	{
		Create_Generic_Ad create_Gen_Ad = new Create_Generic_Ad();
		
		create_Gen_Ad.text_Template(textline1, textline2, textline3, textline4, textline5, textline6, textline7, textline8, textline9, textline10);
		TestUtil.CaptureScreenshot();
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Verify_Text_Lines");
		
		
	}
}
