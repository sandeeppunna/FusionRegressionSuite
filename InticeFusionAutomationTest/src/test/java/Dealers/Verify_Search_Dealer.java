package Dealers;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import Utilities.TestUtil;

public class Verify_Search_Dealer extends Page 
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Search_Dealer"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"regression","dealer","reg"})
	public void verify_Search_Dealer(String dealername, String inactive) throws InterruptedException
	{
		Search_Dealer search_dealer= new Search_Dealer();
		
		search_dealer.search_Dealer(dealername, inactive);
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Verify_Search_Dealer");
	}
}
