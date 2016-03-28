package Users;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import Utilities.TestUtil;

public class Verify_Create_User extends Page
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Create_User"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"regression", "users","reg"})
	public void verify_Create_User(String userFor, String userEmail, String userRole, String userName, 
			String userPassword, String userConfirmPassword, String userConfirmPassword1)
	{
		Create_User create_User= new Create_User();
		
		create_User.create_User(userFor, userEmail, userRole, userName, userPassword, userConfirmPassword, userConfirmPassword1);;
		
	}
	
	@DataProvider
	public static Object[][] getData(){
		
		
		return TestUtil.getData("Verify_Create_User");
		
		
	}
}
