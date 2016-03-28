package Campaigns;

import org.openqa.selenium.By;

import Base.Page;

public class Launch_Dynamic_Campaign extends Page
{
	public void ready_To_Launch() throws InterruptedException
	{
		System.out.println("Ready to launch page displayed");
		log.debug("Ready to launch page displayed");
		topNav.nexter();
		Thread.sleep(1000);
	}
	
	public void launch_Dynamic_Campaign() throws InterruptedException
	{
		driver.findElement(By.xpath(OR.getProperty("launchdynamiccampaign"))).click();
		Thread.sleep(1000);
		if(driver.findElement(By.xpath(OR.getProperty("successlaunchalert"))).isDisplayed())
		{
			System.out.println("validation is working for launched campaign");
			log.debug("validation is working for launched campaign");
		}
		else
		{
			System.out.println("validation is not working for launched campaign");
			log.debug("validation is not working for launched campaign");
		}
	}
}
