package Dealers;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import Utilities.TestUtil;

public class Verify_Delete_Dealer extends Page
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Delete_Dealer"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"regression"})
	public void verify_Create_Dealer(String dealername)
	{
		Delete_Dealer delete_dealer= new Delete_Dealer();
		
		delete_dealer.delete_Dealer(dealername);
		
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Verify_Delete_Dealer");
	}
}
