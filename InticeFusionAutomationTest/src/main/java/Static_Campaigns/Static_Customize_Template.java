package Static_Campaigns;

import org.openqa.selenium.By;

import Base.Page;

public class Static_Customize_Template extends Page
{
	public void verify_Next_Button(String background160600, String background72890, String background300250, String background32050) throws InterruptedException
	{
		Thread.sleep(1000);
		topNav.nexter();
		Thread.sleep(2000);
		String customize_Temp_Alert = driver.findElement(By.xpath(OR.getProperty("customizetemplatealert"))).getText();
		System.out.println("when click on next button "+customize_Temp_Alert+" message displayed");
		log.debug("when click on next button "+customize_Temp_Alert+" message displayed");
		
		if(driver.findElement(By.xpath(OR.getProperty("customizetemplatealert"))).isDisplayed())
		{
			System.out.println("Validation is working when click on next without selecting background images for all banners");
			log.debug("Validation is working when click on next without selecting background images for all banners");
						
			driver.findElement(By.linkText(OR.getProperty("160600link"))).click();
			System.out.println("Clicked on 160 X 600 link");
			log.debug("Clicked on 160 X 600 link");
			driver.findElement(By.xpath(OR.getProperty("160600background"))).sendKeys(background160600);
			System.out.println("Selected 160x600 background"); 
			log.debug("Selected 160x600 background");
			
			driver.findElement(By.linkText(OR.getProperty("72890link"))).click();
			System.out.println("Clicked on 728x90 link");
			log.debug("Clicked on 728x90 link");
			driver.findElement(By.xpath(OR.getProperty("72890background"))).sendKeys(background72890);
			System.out.println("Selected 728x90 background");
			log.debug("Selected 728x90 background");
			
			driver.findElement(By.linkText(OR.getProperty("300250link"))).click();
			System.out.println("Clicked on 300x250 link");
			log.debug("Clicked on 300x250 link");
			driver.findElement(By.xpath(OR.getProperty("300250background"))).sendKeys(background300250);
			System.out.println("Selected 300x250 background");
			log.debug("Selected 300x250 background");
			
			driver.findElement(By.linkText(OR.getProperty("32050link"))).click();
			System.out.println("Clicked on 320x50 link");
			log.debug("Clicked on 320x50 link");
			driver.findElement(By.xpath(OR.getProperty("32050background"))).sendKeys(background32050);
			System.out.println("Selected 320x50 background");
			log.debug("Selected 320x50 background");
			
			topNav.nexter();
			Thread.sleep(5000);
		}
		else
		{
			System.out.println("Validation is not working when click on next without selecting background images for all banners");
			log.debug("Validation is not working when click on next without selecting background images for all banners");
		}
	}
}
