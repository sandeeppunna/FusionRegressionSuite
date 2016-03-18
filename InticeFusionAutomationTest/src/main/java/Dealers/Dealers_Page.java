package Dealers;

import java.util.List;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Base.Page;

public class Dealers_Page extends Page
{
	public void dealers_Table(String dealerheader)
	{
		topNav.adminLinks();
		driver.findElement(By.xpath(OR.getProperty("dealers"))).click();
		String dealer_Header = driver.findElement(By.xpath(OR.getProperty("dealerheader"))).getText();
		
		Assert.assertEquals(dealerheader, dealer_Header);
		
		log.debug(dealerheader + "page displayed");
		
	}
	
	public void InActive(String inactive)
	{
		Select Inactive = new Select (driver.findElement(By.xpath(OR.getProperty("dropdown"))));
		Inactive.selectByVisibleText(inactive);
		log.debug(inactive + "selected");
		
		driver.findElement(By.linkText(OR.getProperty("edit"))).click();
		List<WebElement> radiobuttons = driver.findElements(By.xpath(OR.getProperty("activedealer")));
		
		for(int i=0;i<radiobuttons.size();i++)
		{
			if(radiobuttons.get(i).isSelected())
			{
				log.debug(radiobuttons.get(i).getText() + "selected");
			}
		}
		log.debug(inactive + "wrokinig fine");
	}
	public void active(String active)
	{
		Select Active=new Select (driver.findElement(By.xpath(OR.getProperty("dropdown"))));
		Active.selectByVisibleText(active);
		log.debug(active + "selected");
		
		driver.findElement(By.linkText(OR.getProperty("edit"))).click();
		List<WebElement> radiobuttons = driver.findElements(By.xpath(OR.getProperty("activedealer")));
		
		for(int i=0;i<radiobuttons.size();i++)
		{
			if(radiobuttons.get(i).isSelected())
			{
				log.debug(radiobuttons.get(i).getText() + "selected");
			}
		}
		
		log.debug(active + "wrokinig fine");
	}
	
	public void search_Dealer(String dealername)
	{
		driver.findElement(By.xpath(OR.getProperty("dealersearch"))).sendKeys(dealername);
		driver.findElement(By.xpath(OR.getProperty("searchicon"))).click();
		
		String searched_Dealer = driver.findElement(By.xpath(OR.getProperty("searcheddealer"))).getText();
		Assert.assertEquals(dealername, searched_Dealer);
		
		log.debug("search is working fine");
	}
	
	public void dealer_Pagination()
	{
		
	}
	
	public void dealer_View()
	{
		
	}
}
