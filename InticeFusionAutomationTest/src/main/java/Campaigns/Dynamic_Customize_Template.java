package Campaigns;

import org.openqa.selenium.By;

import Base.Page;

public class Dynamic_Customize_Template extends Page 
{
	public void Banner_160600(String background, String logo, String header, String button1, String button2)
	{
		driver.findElement(By.linkText(OR.getProperty("160600link"))).click();
		System.out.println("Clicked on 160 X 600 link");
		log.debug("Clicked on 160 X 600 link");
		driver.findElement(By.id(OR.getProperty("160600background"))).sendKeys(background);
		System.out.println("Selected 160x600 background"); 
		log.debug("Selected 160x600 background");
		driver.findElement(By.id(OR.getProperty("160600logo"))).sendKeys(logo);
		System.out.println("Selected 160x600 logo");
		log.debug("Selected 160x600 logo");
		driver.findElement(By.id(OR.getProperty("160600header"))).sendKeys(header);
		System.out.println("Selected 160x600 header");
		log.debug("Selected 160x600 header");
		driver.findElement(By.id(OR.getProperty("160600button1"))).sendKeys(button1);
		System.out.println("Selected 160x600 button1");
		log.debug("Selected 160x600 button1");
		driver.findElement(By.id(OR.getProperty("160600button2"))).sendKeys(button2);
		System.out.println("Selected 160x600 button2");
		log.debug("Selected 160x600 button2");
		driver.findElement(By.linkText(OR.getProperty("160600link"))).click();
	}
	
	public void Banner_72890(String background, String logo, String header, String button1, String button2) throws InterruptedException
	{
		driver.findElement(By.linkText(OR.getProperty("72890link"))).click();
		System.out.println("Clicked on 728x90 link");
		log.debug("Clicked on 728x90 link");
		driver.findElement(By.xpath(OR.getProperty("72890background"))).sendKeys(background);
		System.out.println("Selected 728x90 background");
		log.debug("Selected 728x90 background");
		driver.findElement(By.xpath(OR.getProperty("72890logo"))).sendKeys(logo);
		System.out.println("Selected 728x90 logo");
		log.debug("Selected 728x90 logo");
		driver.findElement(By.xpath(OR.getProperty("72890header"))).sendKeys(header);
		System.out.println("Selected 728x90 header");
		log.debug("Selected 728x90 header");
		driver.findElement(By.xpath(OR.getProperty("72890button1"))).sendKeys(button1);
		System.out.println("Selected 728x90 button1");
		log.debug("Selected 728x90 button1");
		driver.findElement(By.xpath(OR.getProperty("72890button2"))).sendKeys(button2);
		System.out.println("Selected 728x90 button2");
		log.debug("Selected 728x90 button2");
		driver.findElement(By.linkText(OR.getProperty("72890link"))).click();
	}
	
	public void Banner_300250(String background, String logo, String header, String button1, String button2) throws InterruptedException
	{
		driver.findElement(By.linkText(OR.getProperty("300250link"))).click();
		System.out.println("Clicked on 300x250 link");
		log.debug("Clicked on 300x250 link");
		driver.findElement(By.xpath(OR.getProperty("300250background"))).sendKeys(background);
		System.out.println("Selected 300x250 background");
		log.debug("Selected 300x250 background");
		driver.findElement(By.xpath(OR.getProperty("300250logo"))).sendKeys(logo);
		System.out.println("Selected 300x250 logo");
		log.debug("Selected 300x250 logo");
		driver.findElement(By.xpath(OR.getProperty("300250header"))).sendKeys(header);
		System.out.println("Selected 300x250 header");
		log.debug("Selected 300x250 header");
		driver.findElement(By.xpath(OR.getProperty("300250button1"))).sendKeys(button1);
		System.out.println("Selected 300x250 button1");
		log.debug("Selected 300x250 button1");
		driver.findElement(By.xpath(OR.getProperty("300250button2"))).sendKeys(button2);
		System.out.println("Selected 300x250 button2");
		log.debug("Selected 300x250 button2");
		driver.findElement(By.linkText(OR.getProperty("300250link"))).click();
	}
	
	public void Banner_32050(String background, String logo)
	{
		driver.findElement(By.linkText(OR.getProperty("32050link"))).click();
		System.out.println("Clicked on 320x50 link");
		log.debug("Clicked on 320x50 link");
		driver.findElement(By.xpath(OR.getProperty("32050background"))).sendKeys(background);
		System.out.println("Selected 320x50 background");
		log.debug("Selected 320x50 background");
		driver.findElement(By.xpath(OR.getProperty("32050logo"))).sendKeys(logo);
		System.out.println("Selected 320x50 logo");
		log.debug("Selected 320x50 logo");
		driver.findElement(By.linkText(OR.getProperty("32050link"))).click();
	}
	
	public void text_Preview(String textline1, String textline2, String textline3, String textline4,String textline5, String textline6,
			String textline7, String textline8, String textline9, String textline10)
	{
//		WebElement text_Line_Box = driver.findElement(By.xpath(OR.getProperty("textlinesbox")));
//		List<WebElement> text_Lines = text_Line_Box.findElements(By.xpath(OR.getProperty("textlines")));
//		for(int i=0;i<text_Lines.size();i++)
//		{
//			text_Lines.get(i).clear();
//			text_Lines.get(i).sendKeys(textline[i+1]);
//		}
		driver.findElement(By.id(OR.getProperty("textline1"))).clear();
		driver.findElement(By.id(OR.getProperty("textline1"))).sendKeys(textline1);
		driver.findElement(By.id(OR.getProperty("textline2"))).clear();
		driver.findElement(By.id(OR.getProperty("textline2"))).sendKeys(textline2);
		driver.findElement(By.id(OR.getProperty("textline3"))).clear();
		driver.findElement(By.id(OR.getProperty("textline3"))).sendKeys(textline3);
		driver.findElement(By.id(OR.getProperty("textline4"))).clear();
		driver.findElement(By.id(OR.getProperty("textline4"))).sendKeys(textline4);
		driver.findElement(By.id(OR.getProperty("textline5"))).clear();
		driver.findElement(By.id(OR.getProperty("textline5"))).sendKeys(textline5);
		driver.findElement(By.id(OR.getProperty("textline6"))).clear();
		driver.findElement(By.id(OR.getProperty("textline6"))).sendKeys(textline6);
		driver.findElement(By.id(OR.getProperty("textline7"))).clear();
		driver.findElement(By.id(OR.getProperty("textline7"))).sendKeys(textline7);
		driver.findElement(By.id(OR.getProperty("textline8"))).clear();
		driver.findElement(By.id(OR.getProperty("textline8"))).sendKeys(textline8);
		driver.findElement(By.id(OR.getProperty("textline9"))).clear();
		driver.findElement(By.id(OR.getProperty("textline9"))).sendKeys(textline9);
		driver.findElement(By.id(OR.getProperty("textline10"))).clear();
		driver.findElement(By.id(OR.getProperty("textline10"))).sendKeys(textline10);
		
		
		driver.findElement(By.id(OR.getProperty("dropshadowcheckbox"))).click();
	
		topNav.nexter();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
