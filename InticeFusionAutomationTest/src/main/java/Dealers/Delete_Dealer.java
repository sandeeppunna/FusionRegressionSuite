package Dealers;

import org.openqa.selenium.By;

import Base.Page;

public class Delete_Dealer extends Page 
{
	public void delete_Dealer(String dealername)
	{
		driver.findElement(By.xpath(OR.getProperty("dealersearch"))).sendKeys(dealername);
		driver.findElement(By.xpath(OR.getProperty("searchicon"))).click();
		
		driver.findElement(By.linkText(OR.getProperty("delete"))).click();
		driver.findElement(By.xpath(OR.getProperty("yes"))).click();
		
		driver.findElement(By.xpath(OR.getProperty("dealersearch"))).sendKeys(dealername);
		driver.findElement(By.xpath(OR.getProperty("searchicon"))).click();
		
		if(driver.findElement(By.xpath(OR.getProperty("searchfordeleteddealer"))).isDisplayed())
		{
			log.debug(dealername + "Deleted successfully");
		}
	}
}
