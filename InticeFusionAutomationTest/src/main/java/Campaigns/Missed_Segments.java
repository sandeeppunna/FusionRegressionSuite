package Campaigns;

import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;

import Utilities.DbManager;
import Base.Page;

public class Missed_Segments extends Page 
{
	public void missed_To_Matched_Segments(String messagekey1, String messagekey2, String messagekey3)
	{
		driver.findElement(By.xpath(OR.getProperty("missedsegments"))).click();
		driver.findElement(By.xpath(OR.getProperty("editbutton"))).click();
		driver.findElement(By.xpath(OR.getProperty("messagekey1"))).clear();
		driver.findElement(By.xpath(OR.getProperty("messagekey1"))).sendKeys(messagekey1);
		driver.findElement(By.xpath(OR.getProperty("messagekey2"))).clear();
		driver.findElement(By.xpath(OR.getProperty("messagekey2"))).sendKeys(messagekey2);
		driver.findElement(By.xpath(OR.getProperty("messagekey3"))).clear();
		driver.findElement(By.xpath(OR.getProperty("messagekey3"))).sendKeys(messagekey3);
		driver.findElement(By.xpath(OR.getProperty("updatebutton"))).click();
		driver.findElement(By.xpath(OR.getProperty("refreshbutton"))).click();
		
		topNav.nexter();
	}
	
	public void multiple_Count_After_Edit_Missed_Segment() throws SQLException
	{
		
		
		
	}

	public void missed_Segment_Pagination()
	{
		
	}
	
	public void missed_Segment_View()
	{
		
	}
	
}
