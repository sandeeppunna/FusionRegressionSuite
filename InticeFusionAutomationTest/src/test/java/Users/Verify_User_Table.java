package Users;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import Utilities.TestUtil;

public class Verify_User_Table extends Page 
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_User_Table"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"regression", "users","reg"})
	public void verify_User_Table(String header) throws InterruptedException
	{
		Users_Page user_Page = new Users_Page();
		
		user_Page.user_Table(header);
		
	}
	
	@DataProvider
	public static Object[][] getData(){
		
		
		return TestUtil.getData("Verify_User_Table");
		
		
	}
}
