package Login;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import FusionLogin.FusionHomePage;
import Utilities.TestUtil;

public class LoginTest extends Page
{
	public static String GlobalUsername;
	
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("LoginTest"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"bvt","regression", "test"})
	public void logIn(String username,String password) throws IOException
	{
		FusionHomePage home = new FusionHomePage();
		
		home.login(username, password);
		
		GlobalUsername = username;
	}
	
	@DataProvider
	public static Object[][] getData(){
		
		
		return TestUtil.getData("LoginTest");
		
		
	}
}
