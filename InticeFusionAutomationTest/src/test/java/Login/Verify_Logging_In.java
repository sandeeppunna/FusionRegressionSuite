package Login;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import FusionLogin.FusionHomePage;
import FusionLogin.Login;
import Utilities.TestUtil;

public class Verify_Logging_In extends Page 
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Logging_In"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"regression", "users","reg"})
	public void logingIn(String username,String password) throws IOException
	{
		Login login = new Login();
		
		login.logging_In(username, password);
	}
	
	@DataProvider
	public static Object[][] getData(){
		
		
		return TestUtil.getData("Verify_Logging_In");
		
		
	}
}
