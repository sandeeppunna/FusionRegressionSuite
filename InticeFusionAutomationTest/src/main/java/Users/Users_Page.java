package Users;

import org.openqa.selenium.By;
import org.testng.Assert;

import Base.Page;

public class Users_Page extends Page
{
	public void user_Table(String header)
	{
		driver.findElement(By.xpath(OR.getProperty("user"))).click();
		String user_Header = driver.findElement(By.xpath(OR.getProperty("userheader"))).getText();
		Assert.assertEquals(header, user_Header);
		
		log.debug("navigated to Users");
		
	}
	
	public void search_User()
	{
		
	}
	
	public void user_Pagination()
	{
		
	}
	
	public void user_View()
	{
		
	}

}
