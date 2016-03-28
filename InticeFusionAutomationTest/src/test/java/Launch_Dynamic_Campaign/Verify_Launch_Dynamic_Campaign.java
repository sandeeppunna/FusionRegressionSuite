package Launch_Dynamic_Campaign;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Page;
import Campaigns.Launch_Dynamic_Campaign;
import Utilities.TestUtil;

public class Verify_Launch_Dynamic_Campaign extends Page 
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Launch_Dynamic_Campaign"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(groups={"bvt", "regression", "test","createdynamic","reg"})
	public void verify_Campaign_Pagination() throws InterruptedException
	{
		Launch_Dynamic_Campaign launch_camp = new Launch_Dynamic_Campaign();
		launch_camp.launch_Dynamic_Campaign();
	}
	

}
