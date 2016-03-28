package DealerGroups;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import Dealer_Groups.Dealer_Groups_Page;
import Utilities.TestUtil;

public class Verify_DG_Search extends Page 
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_DG_Search"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"regression", "dgroup","reg"})
	public void verify_Dealer_Group_Search(String dealergroupname) throws InterruptedException
	{
		Dealer_Groups_Page dg_Page = new Dealer_Groups_Page();
		
		dg_Page.search_Dealer_Group(dealergroupname);
		
	}
	
	@DataProvider
	public static Object[][] getData(){
		
		
		return TestUtil.getData("Verify_DG_Search");
		
		
	}
}
