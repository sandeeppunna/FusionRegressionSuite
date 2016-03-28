package Edit_Campaign;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import Campaigns.Edit_Campaign;
import Utilities.TestUtil;

public class Verify_Customize_Template_In_Edit extends Page 
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Customize_Template_In_Edit"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"regression","createdynamic"})
	public void verify_Customize_Template_In_Edit(String textline1, String textline2, String textline3, String textline4, String textline5,
			String textline6, String textline7, String textline8, String textline9, String textline10) throws InterruptedException
	{
		Edit_Campaign edit_Camp=new Edit_Campaign();
		
		edit_Camp.customize_Template(textline1, textline2, textline3, textline4, textline5, textline6, textline7, textline8, textline9, textline10);
		
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Verify_Customize_Template_In_Edit");
	}
}
