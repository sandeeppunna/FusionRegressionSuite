package Matched_Segments;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.TestUtil;
import Base.Page;
import Campaigns.Manage_Segments;


public class Verify_Matched_Segments extends Page
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Matched_Segments"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(groups={"bvt","regression"})
	public void verify_Matched_Segment() throws IOException, SQLException, InterruptedException
	{
		Manage_Segments manage = new Manage_Segments();
		
		manage.matched_Segments_Count();
		TestUtil.CaptureScreenshot();
	}
	
	
}
