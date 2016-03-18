package Dealers;

import junit.framework.Assert;

import org.openqa.selenium.By;

import Base.Page;

public class Search_Dealer extends Page
{
	public void search_Dealer(String dealername)
	{
		driver.findElement(By.xpath(OR.getProperty("dealersearch"))).sendKeys(dealername);
		driver.findElement(By.xpath(OR.getProperty("searchicon"))).click();
		
		String searched_Dealer = driver.findElement(By.xpath(OR.getProperty("searcheddealer"))).getText();
		Assert.assertEquals(dealername, searched_Dealer);
		
		log.debug("search is working fine");
		
	}
	
}
