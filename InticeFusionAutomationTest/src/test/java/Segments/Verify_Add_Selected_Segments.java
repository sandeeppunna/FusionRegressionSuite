package Segments;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import Utilities.TestUtil;

public class Verify_Add_Selected_Segments extends Page
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Add_Selected_Segments"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"regression", "segments","reg"})
	public void verify_Add_Selected(String make, String model) throws InterruptedException
	{
		Create_Segment create_Segm = new Create_Segment();
		create_Segm.add_Selected_Segments_Into_Created_Segment(make, model);
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Verify_Add_Selected_Segments");
	}
}
