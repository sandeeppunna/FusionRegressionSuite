package Static_Campaign;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import Base.Page;

import Static_Campaigns.Static_Ready_To_Launch;
import Utilities.TestUtil;

public class Verify_Static_Ready_To_Launch extends Page
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Static_Ready_To_Launch"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(groups={"bvt","regression", "test", "createstatic","reg"})
	public void verify_Static_Ready_To_Launch() throws IOException, InterruptedException
	{
		Static_Ready_To_Launch st_Ready_Launch= new Static_Ready_To_Launch();
		st_Ready_Launch.ready_To_Launch();
	}
	
}
