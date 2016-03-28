package Edit_Campaign;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import Campaigns.Edit_Campaign;
import Utilities.TestUtil;

public class Verify_Edit_Camp_Select_A_List extends Page 
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Edit_Camp_Select_A_List"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"regression","createdynamic"})
	public void verify_select_A_List_InEdit(String dealerName)
	{
		Edit_Campaign edit_Camp=new Edit_Campaign();
		
		edit_Camp.select_A_List(dealerName);
		
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Verify_Edit_Camp_Select_A_List");
	}
}
