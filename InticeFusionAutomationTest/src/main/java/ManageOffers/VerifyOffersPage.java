package ManageOffers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Utilities.TestUtil;
import Base.Page;

public class VerifyOffersPage extends Page 
{
	public void verfiyOffersPage(String sheetname)
	{
		String offer_Header = driver.findElement(By.xpath(OR.getProperty("offerheader"))).getText();
		Assert.assertEquals(offer_Header, TestUtil.getData(sheetname));
		log.debug("Offers page opened successfully");
		
	}
	public void offersPagination()
	{
		if(driver.findElement(By.id(OR.getProperty("show"))).isDisplayed())
		{
			WebElement offers_Table = driver.findElement(By.xpath(OR.getProperty("offersTable")));
			List<WebElement> rows = offers_Table.findElements(By.tagName("tr"));
			int rowsSize = rows.size(); 
			log.info("table size " + rowsSize);
			if(rowsSize>10)
			{
				log.info("More than 10 offers, Pagination exists for Offers");
				WebElement Pagenos=driver.findElement(By.id(OR.getProperty("offersTable")));
				String P=Pagenos.getText();//.replace("1- 10 of", "");
				log.info(P); // print page numbers
				WebElement Page=driver.findElement(By.linkText(OR.getProperty("next")));
				Page.click(); //click on page number
				String P1 = driver.findElement(By.id(OR.getProperty("offersTable"))).getText();
				log.info(P1);
				if (P.contentEquals(P1)) 
				{
					log.info("Page 2 is not displayed ");	
				}
				else 
				{
					log.info("Offer Pagination is working "); 
				}
			}
			else
			{
				log.info("Offer count is below 10"); 
			}	
		}
	}
	public void offersView()
	{
		Select view=new Select(driver.findElement(By.xpath(OR.getProperty("view"))));
		List<WebElement> values = view.getOptions();
		for(int i=0;i<values.size();i++)
		{
			view.selectByIndex(i);
			WebElement offer_Table = driver.findElement(By.xpath(OR.getProperty("offersTable")));
			List<WebElement> rows = offer_Table.findElements(By.tagName("tr"));
			int rowsSize = rows.size(); 
			log.info("table size " + rowsSize);
			String selText = values.get(i).getText();
			log.info("selected view " + selText);
			if(rowsSize==Integer.parseInt(selText))
			{
				log.info("Offer view " + selText + " is working fine");
			}
			else
			{
				log.info("Offer view " + selText + " is not working as expected");
			}
		}
	}
	public void offersSearch(String offerName)
	{
		WebElement Search=driver.findElement(By.xpath(".//*[@id='tblOffers_filter']/label/input"));
		log.info("search for valid offer");
		Search.sendKeys(offerName); //search Dealerbox
		
		String searched_Off = driver.findElement(By.xpath(".//*[@id='tblOffers']/tbody/tr/td[1]/a")).getText();
		if(offerName.equals(searched_Off))
		{
			log.info("Offer Search is working fine");
		}
		else
		{
			log.info("Offer search is not working");
		}
	}
	public void sorting()
	{
		
	}
	
}
