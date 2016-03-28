package Segments;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import Utilities.TestUtil;

public class Verify_Segment_Page extends Page
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Segment_Page"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"regression", "segments","reg"})
	public void verify_Segment_Table(String segmentHeader) throws InterruptedException
	{
		Segment_Table seg_Table = new Segment_Table();
		
		seg_Table.segment_Table(segmentHeader);
	}
	
	@DataProvider
	public static Object[][] getData(){
		
		
		return TestUtil.getData("Verify_Segment_Page");
		
		
	}
}
