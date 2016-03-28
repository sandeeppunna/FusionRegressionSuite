package Users;

import org.openqa.selenium.By;

import Base.Page;

public class Edit_User extends Page
{
	public void edit_Users()
	{
		driver.findElement(By.xpath(OR.getProperty("edituser"))).click();
		driver.findElement(By.xpath(OR.getProperty("enableuser"))).click();
		driver.findElement(By.xpath(OR.getProperty("editupdate"))).click();
		String update_Success = driver.findElement(By.xpath(OR.getProperty("editsuccessmessage"))).getText();
		if(driver.findElement(By.xpath(OR.getProperty("editsuccessmessage"))).isDisplayed())
		{
			System.out.println(update_Success+" message displayed");
			log.debug(update_Success+" message displayed");
		}
		else
		{
			System.out.println("success message not displayed");
			log.debug("success message not displayed");
		}
	}
}
