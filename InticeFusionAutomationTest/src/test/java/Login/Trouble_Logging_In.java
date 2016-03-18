package Login;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.TestUtil;
import Base.Page;

public class Trouble_Logging_In extends Page 
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Trouble_Logging_In"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"regression"})
	public void trouble_logging_In(String email)
	{
		Trouble_Logging_In trouble = new Trouble_Logging_In();
		trouble.trouble_logging_In(email);
	}
	
	@DataProvider
	public static Object[][] getData(){
		
		
		return TestUtil.getData("Trouble_Logging_In");
		
		
	}
}
