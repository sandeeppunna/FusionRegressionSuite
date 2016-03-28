package Copy_Campaign;

import org.openqa.selenium.By;

import Base.Page;

public class Copy_Dynamic_Campaign extends Page
{
	public void copy_campaign(String campaignname) throws InterruptedException
	{
		driver.findElement(By.xpath(".//*[@id='campaignList']/div[2]/ul/li[2]/a/tab-heading")).click();
		
		driver.findElement(By.xpath(".//*[@id='content-main']/div/div[1]/div[1]/form/div/input")).sendKeys(campaignname);
		driver.findElement(By.xpath(".//*[@id='content-main']/div/div[1]/div[1]/form/div/span/button")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='campaignList']/div[2]/div/div[2]/table/tbody/tr[1]/td[6]/button[2]")).click();
		
		if(driver.findElement(By.xpath(".//*[starts-with(@id, 'alertContainer')]/li")).isDisplayed())
		{
			System.out.println("validation is working for copy campaign");
			log.debug("validation is working for copy campaign");
			
		}
		else
		{
			System.out.println("validation is not working for copy campaign");
			log.debug("validation is not working for copy campaign");
		}
	}
	
}
