package DealerGroups;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import Dealer_Groups.Create_Dealer_Group;
import Utilities.TestUtil;

public class Verify_Create_DG extends Page 
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Create_DG"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"regression","reg"})
	public void verify_Create_Dealer_Group(String firstName, String lastName, String contactNum, String email, String dealergroupname, String state) throws InterruptedException
	{
		Create_Dealer_Group create_DG= new Create_Dealer_Group();
		
		create_DG.create_DealerGroup(firstName, lastName, contactNum, email, dealergroupname, state);
		
	}
	
	@DataProvider
	public static Object[][] getData(){
		
		
		return TestUtil.getData("Verify_Create_DG");
		
		
	}
}
