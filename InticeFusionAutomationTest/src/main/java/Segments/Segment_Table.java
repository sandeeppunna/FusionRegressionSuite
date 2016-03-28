package Segments;

import org.openqa.selenium.By;
import org.testng.Assert;

import Base.Page;

public class Segment_Table extends Page
{
	public void segment_Table(String segmentHeader) throws InterruptedException
	{
//		driver.findElement(By.xpath(OR.getProperty("admintool"))).click();
//		Thread.sleep(500);
		driver.findElement(By.xpath(OR.getProperty("segments"))).click();
		String segment_Header = driver.findElement(By.xpath(OR.getProperty("segmentsheader"))).getText();
		
		Assert.assertEquals(segment_Header, segmentHeader);
		System.out.println("Navigated to Segment Page");
		log.debug("Navigated to Segment Page");
	}

	
}
