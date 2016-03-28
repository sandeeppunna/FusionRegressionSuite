package DealerGroups;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import Dealer_Groups.Edit_Dealer_Group;
import Utilities.TestUtil;

public class Verify_Edit_DG extends Page
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Edit_DG"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"regression", "dgroup","reg"})
	public void verify_Edit_Dealer_Group(String firstName, String lastName, String email) throws InterruptedException
	{
		Edit_Dealer_Group edit_DG= new Edit_Dealer_Group();
		
		edit_DG.edit_Dealer_Group(firstName, lastName, email);
		
	}
	
	@DataProvider
	public static Object[][] getData(){
		
		
		return TestUtil.getData("Verify_Edit_DG");
		
		
	}
}
