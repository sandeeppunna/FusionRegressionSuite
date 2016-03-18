package Campaigns;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Base.Page;
import Utilities.Counter_Excel;
import Utilities.MHFeed_Read_CSV;
import Utilities.ReadCSV;

public class Preview extends Page
{
	public void total_Segment_count(String campaignName) throws IOException, InterruptedException
	{
		driver.findElement(By.xpath(OR.getProperty("cannedbannerfeed"))).click();
		Thread.sleep(5000);

		String total_records = driver.findElement(By.xpath(OR.getProperty("totalsegmentcount"))).getText().split(" - ")[1];
		
		
		int cb_Rows = ReadCSV.getrows("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv");
		
		Assert.assertEquals(cb_Rows, Integer.parseInt(total_records));
		System.out.println("Total segment count displaying in cannedbanner feed");
		log.debug("Preview page Segment Count matched with cannedbanner feed segment count");
		
		driver.findElement(By.xpath(".//*[@id='previewButtons']/div/button[4]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='previewButtons']/div/button[1]")).click();
		Thread.sleep(2000);
	}
	
	public void verify_TextLines_With_CBFeed(String campaignName) throws InterruptedException, IOException
	{
		/*String sheet_colums[]={"text_1","text_2","text_3","text_4","textcolor_1","textcolor_2","textcolor_3","textcolor_4",
				"buttontext","buttontextcolor"};*/
		int cb_Rows = ReadCSV.getrows("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv");
		for (Integer i=1;i<=cb_Rows;i++)// rows
		{
			for (Integer j=1;j<10;j++){
				String frompage=driver.findElement(By.id(OR.getProperty("textline0"+j.toString()))).getAttribute("value");
				String fromsheet=ReadCSV.getcellvalue("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv", i ,j+7 );
				if(frompage.contains("#")){
					frompage=frompage.split("#")[1];
				}
				Assert.assertEquals(frompage, fromsheet);
				System.out.println(frompage + " matched with Cannedbannerfeed");
				log.debug(frompage + " matched with Cannedbannerfeed");
			}
			driver.findElement(By.xpath(OR.getProperty("paginationnext"))).click();
			Thread.sleep(2000);
			
			System.out.println("Text Lines and text colors are matched with canned banner feed");
			log.debug("Text Lines and text colors are matched with canned banner feed");
			
		}
		driver.findElement(By.xpath(OR.getProperty("paginationfirst"))).click();
			
	}
	
	public void verify_CBFeed(String campaignName) throws IOException, InterruptedException
	{
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());

		int cb_Rows = ReadCSV.getrows("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv");
		String wh = driver.getWindowHandle();
		
		for (Integer i=1;i<=cb_Rows;i++)// rows
		{
			for (Integer j=1;j<10;j++)
			{
				String preview_text=driver.findElement(By.id(OR.getProperty("textline0"+j.toString()))).getAttribute("value");
				String CB_text=ReadCSV.getcellvalue("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv", i ,j+7 );
				if(preview_text.contains("#"))
				{
					preview_text=preview_text.split("#")[1];
				}
				Assert.assertEquals(preview_text, CB_text);
				System.out.println("preview textline "+j+" matched with Cannedbannerfeed textline "+j);
				log.debug("preview textline "+j+" matched with Cannedbannerfeed textline "+j);
				
			}
			
			String landing_Page_URL = driver.findElement(By.id(OR.getProperty("landingpageurlp"))).getAttribute("value");
			String CB_Landing_Page_URL = ReadCSV.getcellvalue("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv", i ,36 );
			Assert.assertEquals(landing_Page_URL, CB_Landing_Page_URL);
			
			System.out.println("Preview Landing page Url matched with CB Feed Landing page url");
			log.debug("Preview Landing page Url matched with CB Feed Landing page url");
			
			boolean preview_Dropshadow = driver.findElement(By.id(OR.getProperty("dropshadowcheckbox"))).isSelected();
			String CB_Dropshadow = ReadCSV.getcellvalue("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv", i ,7 );
			if(CB_Dropshadow.equals("1"))
			{
				boolean CB_textbox = true;
				Assert.assertEquals(preview_Dropshadow, CB_textbox);
				System.out.println(CB_Dropshadow+" Preview Dropshadow matched with CB feed dropshadow");
				log.debug(CB_Dropshadow+" Preview Dropshadow matched with CB feed dropshadow");
			}
			else
			{
				boolean CB_textbox = false;
				Assert.assertEquals(preview_Dropshadow, CB_textbox);
				System.out.println(CB_Dropshadow+" Preview Dropshadow matched with CB feed dropshadow");
				log.debug(CB_Dropshadow+" Preview Dropshadow matched with CB feed dropshadow");
			}
			
			
			
			driver.switchTo().frame(driver.findElement(By.id("728x90")));//leaderboard replaced with iframe id
								
			String preview_72890background = driver.findElement(By.id(OR.getProperty("backgroundp"))).getAttribute("src");
			String CB_72890background=ReadCSV.getcellvalue("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv", i ,20);
			Assert.assertEquals(preview_72890background, CB_72890background);
			System.out.println("Preview 72890 background matched with Cannedbannerfeed 72890 backgrouond");
			log.debug("Preview 72890 background matched with Cannedbannerfeed 72890 backgrouond");
			
			String preview_72890header = driver.findElement(By.id(OR.getProperty("headerp"))).getAttribute("src");
			String CB_72890header = ReadCSV.getcellvalue("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv", i ,24 );
			Assert.assertEquals(preview_72890header, CB_72890header);
			System.out.println("Preview 72890 header matched with Cannedbannerfeed 72890 header");
			log.debug("Preview 72890 header matched with Cannedbannerfeed 72890 header");
			
			String preview_72890logo = driver.findElement(By.id(OR.getProperty("logop"))).getAttribute("src");
			String CB_72890logo = ReadCSV.getcellvalue("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv", i ,27 );
			Assert.assertEquals(preview_72890logo, CB_72890logo);
			System.out.println("Preview 72890 logo matched with Cannedbannerfeed 72890 logo");
			log.debug("Preview 72890 logo matched with Cannedbannerfeed 72890 logo");
			
			String preview_72890button1 = driver.findElement(By.id(OR.getProperty("button1p"))).getAttribute("src");
			String CB_72890button1 = ReadCSV.getcellvalue("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv", i ,33 );
			Assert.assertEquals(preview_72890button1, CB_72890button1);
			System.out.println("Preview 72890 button1 matched with Cannedbannerfeed 72890 button1");
			log.debug("Preview 72890 button1 matched with Cannedbannerfeed 72890 button1");
			
			String preview_72890button2 = driver.findElement(By.id(OR.getProperty("button2p"))).getAttribute("src");
			String CB_72890button2 = ReadCSV.getcellvalue("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv", i ,34 );
			Assert.assertEquals(preview_72890button2, CB_72890button2);
			System.out.println("Preview 72890 button2 matched with Cannedbannerfeed 72890 button2");
			log.debug("Preview 72890 button2 matched with Cannedbannerfeed 72890 button2");

			driver.switchTo().window(wh);

			driver.switchTo().frame(driver.findElement(By.id("160x600")));//widescrapper
			
			String preview_160600background = driver.findElement(By.id(OR.getProperty("backgroundp"))).getAttribute("src");
			String CB_160600background=ReadCSV.getcellvalue("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv", i ,19);
			Assert.assertEquals(preview_160600background, CB_160600background);
			System.out.println("Preview 160600 background matched with Cannedbannerfeed 160600 backgrouond");
			log.debug("Preview 160600 background matched with Cannedbannerfeed 160600 backgrouond");
			
			String preview_160600header = driver.findElement(By.id(OR.getProperty("headerp"))).getAttribute("src");
			String CB_160600header = ReadCSV.getcellvalue("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv", i ,23 );
			Assert.assertEquals(preview_160600header, CB_160600header);
			System.out.println("Preview 160600 header matched with Cannedbannerfeed 160600 header");
			log.debug("Preview 160600 header matched with Cannedbannerfeed 160600 header");
			
			String preview_160600logo = driver.findElement(By.id(OR.getProperty("logop"))).getAttribute("src");
			String CB_160600logo = ReadCSV.getcellvalue("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv", i ,26 );
			Assert.assertEquals(preview_160600logo, CB_160600logo);
			System.out.println("Preview 160600 logo matched with Cannedbannerfeed 160600 logo");
			log.debug("Preview 160600 logo matched with Cannedbannerfeed 160600 logo");
			
			String preview_160600button1 = driver.findElement(By.id(OR.getProperty("button1p"))).getAttribute("src");
			String CB_160600button1 = ReadCSV.getcellvalue("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv", i ,31 );
			Assert.assertEquals(preview_160600button1, CB_160600button1);
			System.out.println("Preview 160600 button1 matched with Cannedbannerfeed 160600 button1");
			log.debug("Preview 160600 button1 matched with Cannedbannerfeed 160600 button1");
			
			String preview_160600button2 = driver.findElement(By.id(OR.getProperty("button2p"))).getAttribute("src");
			String CB_160600button2 = ReadCSV.getcellvalue("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv", i ,32 );
			Assert.assertEquals(preview_160600button2, CB_160600button2);
			System.out.println("Preview 160600 button2 matched with Cannedbannerfeed 160600 button2");
			log.debug("Preview 160600 button2 matched with Cannedbannerfeed 160600 button2");

			driver.switchTo().window(wh);
		
			driver.switchTo().frame(driver.findElement(By.id("300x250")));//medium trainngle
			
			String preview_300250background = driver.findElement(By.id(OR.getProperty("backgroundp"))).getAttribute("src");
			String CB_300250background=ReadCSV.getcellvalue("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv", i ,18);
			Assert.assertEquals(preview_300250background, CB_300250background);
			System.out.println("Preview 300250 background matched with Cannedbannerfeed 300250 backgrouond");
			log.debug("Preview 300250 background matched with Cannedbannerfeed 300250 backgrouond");
			
			String preview_300250header = driver.findElement(By.id(OR.getProperty("headerp"))).getAttribute("src");
			String CB_300250header = ReadCSV.getcellvalue("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv", i ,22 );
			Assert.assertEquals(preview_300250header, CB_300250header);
			System.out.println("Preview 300250 header matched with Cannedbannerfeed 300250 header");
			log.debug("Preview 300250 header matched with Cannedbannerfeed 300250 header");
			
			String preview_300250logo = driver.findElement(By.id(OR.getProperty("logop"))).getAttribute("src");
			String CB_300250logo = ReadCSV.getcellvalue("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv", i ,25 );
			Assert.assertEquals(preview_300250logo, CB_300250logo);
			System.out.println("Preview 300250 logo matched with Cannedbannerfeed 300250 logo");
			log.debug("Preview 300250 logo matched with Cannedbannerfeed 300250 logo");
			
			String preview_300250button1 = driver.findElement(By.id(OR.getProperty("button1p"))).getAttribute("src");
			String CB_300250button1 = ReadCSV.getcellvalue("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv", i ,29 );
			Assert.assertEquals(preview_300250button1, CB_300250button1);
			System.out.println("Preview 300250 button1 matched with Cannedbannerfeed 300250 button1");
			log.debug("Preview 300250 button1 matched with Cannedbannerfeed 300250 button1");
			
			String preview_300250button2 = driver.findElement(By.id(OR.getProperty("button2p"))).getAttribute("src");
			String CB_300250button2 = ReadCSV.getcellvalue("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv", i ,30 );
			Assert.assertEquals(preview_300250button2, CB_300250button2);
			System.out.println("Preview 300250 button2 matched with Cannedbannerfeed 300250 button2");
			log.debug("Preview 300250 button2 matched with Cannedbannerfeed 300250 button2");

			driver.switchTo().window(wh);

			driver.switchTo().frame(driver.findElement(By.id("320x50")));//banner
			
			String preview_32050background = driver.findElement(By.id(OR.getProperty("backgroundp"))).getAttribute("src");
			String CB_32050background=ReadCSV.getcellvalue("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv", i ,21);
			Assert.assertEquals(preview_32050background, CB_32050background);
			System.out.println("Preview 32050 background matched with Cannedbannerfeed 32050 backgrouond");
			log.debug("Preview 32050 background matched with Cannedbannerfeed 32050 backgrouond");
			
			String preview_32050logo = driver.findElement(By.id(OR.getProperty("logop"))).getAttribute("src");
			String CB_32050logo = ReadCSV.getcellvalue("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv", i ,28 );
			Assert.assertEquals(preview_32050logo, CB_32050logo);
			System.out.println("Preview 32050 logo matched with Cannedbannerfeed 32050 logo");
			log.debug("Preview 32050 logo matched with Cannedbannerfeed 32050 logo");
			
			driver.switchTo().window(wh);
		
			driver.findElement(By.xpath(OR.getProperty("paginationnext"))).click();
			Thread.sleep(2000);
			
			System.out.println("Text Lines and text colors are matched with canned banner feed");
			log.debug("Text Lines and text colors are matched with canned banner feed");
			
			
		}
	}
	public void verify_MightyHiveFeed(String campaignName, String csvfile1, String file1, String file2) throws InterruptedException, IOException
	{
		String campaign_ID = ReadCSV.getcellvalue("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv", 1 ,2 );
		driver.findElement(By.xpath(OR.getProperty("mightyhivefeed"))).click();
		Thread.sleep(5000);
		
		int mighty_Rows = ReadCSV.getrows("C:\\Users\\sandeep\\Downloads\\"+campaign_ID+" MightyHiveFeed.csv");
		int calcMH_Count = MHFeed_Read_CSV.row_Count(csvfile1, file1, file2);
		
		Assert.assertEquals(mighty_Rows, calcMH_Count);
		System.out.println(mighty_Rows+" Mighty Hive Feed matched with total matched segments in list");
		log.debug(mighty_Rows+" Mighty Hive Feed matched with total matched segments in list");
		
		topNav.nexter();
		
	}
}
