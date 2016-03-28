package Logoff;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Page;
import Logout.Log_Out;
import Utilities.TestUtil;

public class Verify_User_Logoff extends Page 
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_User_Logoff"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(groups={"regression", "users","reg"})
	public void log_Off() throws IOException
	{
		Log_Out logOff = new Log_Out();
		
		logOff.logout();
	}
	
}
