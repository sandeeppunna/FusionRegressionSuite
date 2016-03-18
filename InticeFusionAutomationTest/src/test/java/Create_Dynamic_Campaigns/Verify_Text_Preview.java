package Create_Dynamic_Campaigns;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.TestUtil;
import Base.Page;
import Campaigns.Dynamic_Customize_Template;

public class Verify_Text_Preview extends Page 
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Text_Preview"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"bvt","regression","test"})
	public void verify_Text_Preview(String textline1, String textline2, String textline3, String textline4, String textline5, 
			String textline6, String textline7, String textline8, String textline9, String textline10) throws IOException
	{
		Dynamic_Customize_Template cust_Template = new Dynamic_Customize_Template();
		
		cust_Template.text_Preview(textline1, textline2, textline3, textline4, textline5, textline6, textline7, textline8, textline9, textline10);
		TestUtil.CaptureScreenshot();
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Verify_Text_Preview");
		
		
	}
}
