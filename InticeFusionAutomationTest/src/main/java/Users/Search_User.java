package Users;

import org.openqa.selenium.By;

import Base.Page;

public class Search_User extends Page
{
	public void user_Search(String userName) throws InterruptedException
	{
		driver.findElement(By.xpath(OR.getProperty("searchuser"))).sendKeys(userName);
		driver.findElement(By.xpath(OR.getProperty("usersearchbutton"))).click();
		Thread.sleep(2000);
	}
}
