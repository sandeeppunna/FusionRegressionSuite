package Segments;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Page;
import Utilities.TestUtil;

public class Select_Message_Keys extends Page 
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Select_Message_Keys"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData", groups={"regression", "segments","reg"})
	public void verify_Message_Keys(String messagekey1, String messagekey2, String messagekey3) throws InterruptedException
	{
		Create_Segment create_Segm = new Create_Segment();
		create_Segm.select_Message_Keys(messagekey1, messagekey2, messagekey3);
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return TestUtil.getData("Select_Message_Keys");
	}
}
