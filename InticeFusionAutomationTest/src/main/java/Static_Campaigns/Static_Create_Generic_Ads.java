package Static_Campaigns;

import org.openqa.selenium.By;

import Base.Page;

public class Static_Create_Generic_Ads extends Page 
{
	public void create_Generic_Ad(String background160600, String background72890, String background300250, String background32050 ) throws InterruptedException
	{
		Thread.sleep(3000);
		
		boolean save_Button = driver.findElement(By.xpath(OR.getProperty("savebutton"))).isEnabled();
		System.out.println("Save button is enabled "+save_Button);
		log.debug("Save button is enabled "+save_Button);
		if(!driver.findElement(By.xpath(OR.getProperty("savebutton"))).isEnabled())
		{
			System.out.println("Save button disabled without selecting background images for all banners");
			log.debug("Save button disabled without selecting background images for all banners");
						
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
			
			//save_Button = driver.findElement(By.xpath(OR.getProperty("savebutton"))).isEnabled();
			
			if(driver.findElement(By.xpath(OR.getProperty("savebutton"))).isEnabled())
			{
				System.out.println("validation is working for save button when all banners backgrounds are selected");
				log.debug("validation is working for save button when all banners backgrounds are selected");
				
				driver.findElement(By.xpath(OR.getProperty("savebutton"))).click();
				Thread.sleep(8000);
				String generic_Ad_Success = driver.findElement(By.xpath(OR.getProperty("genericadsuccessalert"))).getText();
				System.out.println("Success message display as "+generic_Ad_Success);
				log.debug("Success message display as "+generic_Ad_Success);
				
				boolean save_Button1 = driver.findElement(By.xpath(OR.getProperty("savebutton"))).isEnabled();
				System.out.println("after creating the generic Ad save button should be "+ save_Button1);
				log.debug("after creating the generic Ad save button should be "+ save_Button1);
				
				topNav.nexter();
				System.out.println("Navigate to Preview Page");
				log.debug("Navigate to Preview Page");
			}
			else
			{
				System.out.println("validation is not working for save button when all banners backgrounds are selected");
				log.debug("validation is not working for save button when all banners backgrounds are selected");
			}
		}
		else
		{
			System.out.println("Save button enabled without selecting background images for all banners");
			log.debug("Save button enabled without selecting background images for all banners");
		}
	}
	
	public void with_Out_Creating_Gereric_ClickON_Next()
	{
		topNav.nexter();
		System.out.println("Navigate to Preview Page");
		log.debug("Navigate to Preview Page");
	}
}
