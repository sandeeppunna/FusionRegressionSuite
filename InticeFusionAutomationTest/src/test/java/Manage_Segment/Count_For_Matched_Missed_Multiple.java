package Manage_Segment;

import java.io.IOException;

import org.apache.xalan.transformer.CountersTable;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Campaigns.Manage_Segments;
import Utilities.Counter_Excel;
import Utilities.TestUtil;

public class Count_For_Matched_Missed_Multiple
{

	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Count_For_Matched_Missed_Multiple"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(groups={"bvt","regression","test", "matched"})
	public void manage_segment_for_Matched_Multiple_Missed() throws IOException, InterruptedException
	{
		Counter_Excel.Manage_Segments(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\list1801.xlsx", 
				System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Segment.xlsx");
	}
	
	
}
