package ManageOffers;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Utilities.TestUtil;
import Base.Page;
import Base.TopNavigations;

public class LandingPage extends Page 
{
	public void VerifyLandingPage(String sheetname) throws IOException
	{
		String header = driver.findElement(By.xpath(OR.getProperty("headername"))).getText();
		Assert.assertEquals(header, TestUtil.getData(sheetname));
		log.debug("Landing page opened successfully");
	}
	
	public void VerifyAllLinks()
	{
		WebElement table = driver.findElement(By.xpath(OR.getProperty("table")));
		List<WebElement> links = table.findElements(By.tagName("a"));
		
		for(int i=0;i<links.size();i++)
		{
			links.get(i).click();
			driver.navigate().back();
			table = driver.findElement(By.xpath(OR.getProperty("table")));
			links = table.findElements(By.tagName("a"));
		}
		
		
	}
	
}
