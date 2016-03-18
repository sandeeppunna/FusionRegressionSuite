package Multiple_Segments;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.TestUtil;
import Base.Page;
import Campaigns.Manage_Segments;

public class Verify_Multiple_Segments extends Page
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Multiple_Segments"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(groups={"bvt","regression"})
	public void verify_Mulitple_Segment() throws IOException, SQLException
	{
		Manage_Segments manage = new Manage_Segments();
		
		manage.mutliple_Segments_Count();
		
		TestUtil.CaptureScreenshot();
	}
	
	
}
