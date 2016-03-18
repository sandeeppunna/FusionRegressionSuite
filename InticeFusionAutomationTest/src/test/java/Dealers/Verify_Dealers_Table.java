package Dealers;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.TestUtil;
import Base.Page;

public class Verify_Dealers_Table extends Page
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Dealers_Table"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"regression"})
	public void verify_Dealer_Table(String dealerheader)
	{
		Dealers_Page dealer_Page = new Dealers_Page();
		
		dealer_Page.dealers_Table(dealerheader);
		
	}
	
	@DataProvider
	public static Object[][] getData(){
		
		
		return TestUtil.getData("Verify_Dealers_Table");
		
		
	}
}
