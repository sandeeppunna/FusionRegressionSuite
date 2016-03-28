package Users;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Page;
import Utilities.TestUtil;

public class Verify_Edit_User extends Page
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Edit_User"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(groups={"regression", "users","reg"})
	public void verify_Edit_User()
	{
		Edit_User edit_User = new Edit_User();
		
		edit_User.edit_Users();
		
	}
}
