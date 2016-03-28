package Segments;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import Utilities.TestUtil;

public class Verify_Create_Segment extends Page 
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Create_Segment"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"regression","segments","reg"})
	public void verify_Create_Segment(String segmentName) throws InterruptedException
	{
		Create_Segment create_Segm = new Create_Segment();
		create_Segm.new_Segment(segmentName);
	}
	
	@DataProvider
	public static Object[][] getData(){
		
		
		return TestUtil.getData("Verify_Create_Segment");
		
		
	}
}
