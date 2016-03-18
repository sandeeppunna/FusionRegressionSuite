package Manage_Segment;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.TestUtil;
import Base.Page;
import Campaigns.Manage_Segments;

public class Select_Segment_For_Matching extends Page
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Select_Segment_For_Matching"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"bvt","regression","test"})
	public void select_Segment(String segmentname) throws IOException, InterruptedException
	{
		Manage_Segments manage_Seg = new Manage_Segments();
		
		manage_Seg.select_Segment_For_Matching(segmentname);
		TestUtil.CaptureScreenshot();
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Select_Segment_For_Matching");
		
		
	}
}
