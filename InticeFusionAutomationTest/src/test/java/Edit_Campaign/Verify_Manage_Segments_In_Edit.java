package Edit_Campaign;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Page;
import Campaigns.Edit_Campaign;
import Utilities.TestUtil;

public class Verify_Manage_Segments_In_Edit extends Page 
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Manage_Segments_In_Edit"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(groups={"regression","createdynamic"})
	public void verify_Manage_Segments_In_Edit() throws InterruptedException
	{
		Edit_Campaign edit_Camp= new Edit_Campaign();
		
		edit_Camp.manage_Segment();
		
	}
}
