package Dealers;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import Utilities.TestUtil;

public class Verify_Edit_Dealer extends Page
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Edit_Dealer"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"regression"})
	public void verify_Create_Dealer(String firstname, String lastname, String contactemail, String dealername)
	{
		Edit_Dealer edit_dealer= new Edit_Dealer();
		
		edit_dealer.edit_Dealer(dealername, firstname, lastname, contactemail);
		
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Verify_Edit_Dealer");
	}
}
