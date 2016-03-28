package Static_Campaigns;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Base.Page;
import Utilities.ReadCSV;

public class Static_Preview extends Page 
{
	public void verify_CB_Feed_Count_With_Preview(String campaignName) throws InterruptedException, IOException
	{
		driver.findElement(By.xpath(OR.getProperty("cannedbannerfeed"))).click();
		Thread.sleep(5000);
		
		String total_records = driver.findElement(By.xpath(OR.getProperty("totalsegmentcount"))).getText().split(" - ")[1];
		
		int cb_Rows = ReadCSV.getrows("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv");
		
		Assert.assertEquals(cb_Rows, Integer.parseInt(total_records));
		System.out.println("Preview page Segment Count matched with cannedbanner feed segment count");
		log.debug("Preview page Segment Count matched with cannedbanner feed segment count");
	}
	
	public void verify_CBFeed(String campaignName) throws IOException, InterruptedException
	{
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());

		int cb_Rows = ReadCSV.getrows("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv");
		String wh = driver.getWindowHandle();
		
		for (Integer i=1;i<=cb_Rows;i++)// rows
		{
			String landing_Page_URL = driver.findElement(By.id(OR.getProperty("landingpageurlp"))).getAttribute("value");
			String CB_Landing_Page_URL = ReadCSV.getcellvalue("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv", i ,36);
			Assert.assertEquals(landing_Page_URL, CB_Landing_Page_URL);
			
			System.out.println("Preview Landing page Url matched with CB Feed Landing page url");
			log.debug("Preview Landing page Url matched with CB Feed Landing page url");
			
			driver.switchTo().frame(driver.findElement(By.id("728x90")));//leaderboard replaced with iframe id
								
			String preview_72890background = driver.findElement(By.id(OR.getProperty("backgroundp"))).getAttribute("src");
			String CB_72890background=ReadCSV.getcellvalue("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv", i ,20);
			Assert.assertEquals(preview_72890background, CB_72890background);
			System.out.println("Preview 72890 background matched with Cannedbannerfeed 72890 backgrouond");
			log.debug("Preview 72890 background matched with Cannedbannerfeed 72890 backgrouond");
			
			driver.switchTo().window(wh);

			driver.switchTo().frame(driver.findElement(By.id("160x600")));//widescrapper
			
			String preview_160600background = driver.findElement(By.id(OR.getProperty("backgroundp"))).getAttribute("src");
			String CB_160600background=ReadCSV.getcellvalue("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv", i ,19);
			Assert.assertEquals(preview_160600background, CB_160600background);
			System.out.println("Preview 160600 background matched with Cannedbannerfeed 160600 backgrouond");
			log.debug("Preview 160600 background matched with Cannedbannerfeed 160600 backgrouond");
			
			driver.switchTo().window(wh);
		
			driver.switchTo().frame(driver.findElement(By.id("300x250")));//medium trainngle
			
			String preview_300250background = driver.findElement(By.id(OR.getProperty("backgroundp"))).getAttribute("src");
			String CB_300250background=ReadCSV.getcellvalue("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv", i ,18);
			Assert.assertEquals(preview_300250background, CB_300250background);
			System.out.println("Preview 300250 background matched with Cannedbannerfeed 300250 backgrouond");
			log.debug("Preview 300250 background matched with Cannedbannerfeed 300250 backgrouond");
			
			driver.switchTo().window(wh);

			driver.switchTo().frame(driver.findElement(By.id("320x50")));//banner
			
			String preview_32050background = driver.findElement(By.id(OR.getProperty("backgroundp"))).getAttribute("src");
			String CB_32050background=ReadCSV.getcellvalue("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv", i ,21);
			Assert.assertEquals(preview_32050background, CB_32050background);
			System.out.println("Preview 32050 background matched with Cannedbannerfeed 32050 backgrouond");
			log.debug("Preview 32050 background matched with Cannedbannerfeed 32050 backgrouond");
			
			driver.switchTo().window(wh);
		
			driver.findElement(By.xpath(OR.getProperty("paginationnext"))).click();
			Thread.sleep(2000);
			
			System.out.println("Preview Background images are matched with canned banner feed");
			log.debug("Preview background images are matched with canned banner feed");
		}
	}
	
}
