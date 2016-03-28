package Edit_Campaign;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Page;
import Campaigns.Edit_Campaign;
import Utilities.TestUtil;

public class Verify_Select_A_Template_InEdit extends Page
{
	@BeforeTest
	public void isSkip()
	{
		if(!TestUtil.isExecutable("Verify_Select_A_Template_InEdit"))
		{
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(groups={"regression","createdynamic"})
	public void verify_Select_A_Template_InEdit() throws InterruptedException
	{
		Edit_Campaign edit_Camp= new Edit_Campaign();
		
		edit_Camp.select_Template();
		
	}
}
