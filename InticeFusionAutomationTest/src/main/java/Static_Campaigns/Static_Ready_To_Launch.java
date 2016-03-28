package Static_Campaigns;

import org.openqa.selenium.By;

import Base.Page;

public class Static_Ready_To_Launch extends Page
{
	public void ready_To_Launch()
	{
		topNav.nexter();
	}
	
	public void launch_Static_Campaign()
	{
		driver.findElement(By.xpath(OR.getProperty("launchstaticcampaign"))).click();
		
		if(driver.findElement(By.xpath(OR.getProperty("successstaticlaunchalert"))).isDisplayed())
		{
			System.out.println(driver.findElement(By.xpath(OR.getProperty("successstaticlaunchalert"))).getText()+" Message displayed");
			log.debug(driver.findElement(By.xpath(OR.getProperty("successstaticlaunchalert"))).getText()+" Message displayed");
		}
		else
		{
			System.out.println("Static campaign launch success message not displayed");
			log.debug("Static campaign launch success message not displayed");
		}
	}
}
