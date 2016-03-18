package Campaigns;

import java.util.List;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Base.Page;

public class Campaigns extends Page 
{
	public void campaign_Page(String headerName)
	{
		String header_Name = driver.findElement(By.xpath(OR.getProperty("campaignheader"))).getText();
		Assert.assertEquals(headerName, header_Name);
		log.debug(headerName +"launched successfully");
		
	}
	
	public void campaign_Table(String inProgress_Tab, String live_Tab, String completed_Tab)
	{
		String inProgress = driver.findElement(By.xpath(OR.getProperty("inprogress"))).getText();
		log.debug(inProgress);
		String live = driver.findElement(By.xpath(OR.getProperty("live"))).getText();
		log.debug(live);
		String completed = driver.findElement(By.xpath(OR.getProperty("completed"))).getText();
		log.debug(completed);
	}
	
	public void campaign_Pagination()
	{
		if(driver.findElement(By.xpath(OR.getProperty("pagination"))).isDisplayed())
		{
			WebElement campaign_Table = driver.findElement(By.xpath(OR.getProperty("campaigntable")));
			List<WebElement> rows = campaign_Table.findElements(By.tagName("tr"));
			int rowsSize = rows.size(); 
			log.debug("table size " + rowsSize);
			if(rowsSize>=10)
			{
				log.debug("More than 10 campaigns, Pagination exists for Campaigns");
				WebElement Pagenos = driver.findElement(By.xpath(OR.getProperty("pagination")));
				String P=Pagenos.getText();//.replace("1- 10 of", "");
				log.info(P); // print page numbers
				WebElement Page=driver.findElement(By.xpath(OR.getProperty("next")));
				Page.click(); //click on page number
				String P1 = driver.findElement(By.xpath(OR.getProperty("pagination"))).getText();
				log.info(P1);
				
				if (P.contentEquals(P1)) 
				{
					log.info("Page 2 is not displayed ");	
				}
				else 
				{
					log.info("Campaign Pagination is working "); 
				}
			}
			else
			{
				log.info("Campaign count is below 10"); 
			}	
		}
	}
	
	public void campaign_View()
	{
		Select view=new Select(driver.findElement(By.xpath(OR.getProperty("view"))));
		List<WebElement> values = view.getOptions();
		for(int i=0;i<values.size();i++)
		{
			view.selectByIndex(i);
			WebElement campaign_Table = driver.findElement(By.xpath(OR.getProperty("campaigntable")));
			List<WebElement> rows = campaign_Table.findElements(By.tagName("tr"));
			int rowsSize = rows.size(); 
			log.debug("table size " + rowsSize);
			String selText = values.get(i).getText();
			log.debug("selected view " + selText);
			if(rowsSize==Integer.parseInt(selText))
			{
				log.debug("view " + selText + " is working fine");
			}
			else
			{
				log.debug("view " + selText + " is not working as expected");
			}
		}
	}
	
	public void search_Campaign(String campaignname)
	{
		driver.findElement(By.xpath(OR.getProperty("search"))).sendKeys(campaignname);	//search campaign
		driver.findElement(By.xpath("searchbutton")).click(); //click on search
		
		String searched_Campaign = driver.findElement(By.xpath(OR.getProperty("searchedcampaign"))).getText();
		
		Assert.assertEquals(campaignname, searched_Campaign);
		log.debug(campaignname + "should be displayed");
		
		driver.findElement(By.xpath(".//*[@id='content-main']/div/div[1]/div/form/div/input")).clear();
		
		driver.findElement(By.xpath(".//*[@id='content-main']/div/div[1]/div/form/div/input")).click(); //click on search
		log.info("search dealer is working");
	
	}
	
}
