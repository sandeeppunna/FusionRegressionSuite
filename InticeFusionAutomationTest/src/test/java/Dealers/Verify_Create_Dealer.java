package Dealers;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import Utilities.TestUtil;

public class Verify_Create_Dealer extends Page
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Create_Dealer"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"regression"})
	public void verify_Create_Dealer(String firstname, String lastname, String contactnumber, String contactemail, String dgroup, String dealername, String dealername1)
	{
		Create_Dealer create_dealer= new Create_Dealer();
		
		create_dealer.create_Dealer(firstname, lastname, contactnumber, contactemail, dgroup, dealername, dealername1);
		
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Verify_Create_Dealer");
	}
}
