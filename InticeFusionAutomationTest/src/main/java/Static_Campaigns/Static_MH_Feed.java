package Static_Campaigns;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import Base.Page;
import Utilities.MHFeed_Read_CSV;
import Utilities.ReadCSV;

public class Static_MH_Feed extends Page  
{	
	public void verify_MH_Feed(String campaignName, String file1) throws InterruptedException, IOException
	{
		String campaign_ID = ReadCSV.getcellvalue("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv", 1 ,2 );
		driver.findElement(By.xpath(OR.getProperty("mightyhivefeed"))).click();
		Thread.sleep(5000);
		
		File f= new File("C:\\Users\\sandeep\\Downloads\\"+campaign_ID);
		File oldName = new File("C:\\Users\\sandeep\\Downloads\\"+campaign_ID);
	    File newName = new File("C:\\Users\\sandeep\\Downloads\\"+campaign_ID+".csv");
		oldName.renameTo(newName);
		
		int mighty_Rows = ReadCSV.getrows("C:\\Users\\sandeep\\Downloads\\"+campaign_ID+".csv");
		int calcMH_Count = MHFeed_Read_CSV.getrows(file1);

		Assert.assertEquals(mighty_Rows, calcMH_Count);
		System.out.println(mighty_Rows+" Mighty Hive Feed matched with total matched segments in list");
		log.debug(mighty_Rows+" Mighty Hive Feed matched with total matched segments in list");
	}
	
	public void verify_MHFeedMessageID_With_CBFeed(String campaignName)
	{
		
		String campaign_ID = ReadCSV.getcellvalue("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv", 1 ,2 );
		String message_ID= ReadCSV.getcellvalue("C:\\Users\\sandeep\\Downloads\\"+campaignName+"_CannedBannerFeed.csv", 2 ,4 );
		System.out.println("cannde banner messageID "+message_ID);
		log.debug("cannde banner messageID "+message_ID);

		String MHMessage_ID = ReadCSV.getcellvalue("C:\\Users\\sandeep\\Downloads\\"+campaign_ID+".csv",2, 10);
		System.out.println("mightyhive feed messageID "+MHMessage_ID);
		log.debug("mightyhive feed messageID "+MHMessage_ID);
		
		Assert.assertEquals(message_ID, MHMessage_ID);
		System.out.println(message_ID+" Mighty Hive Feed messageID matched with Canned banner feed messageID");
		log.debug(message_ID+" Mighty Hive Feed messageID matched with Canned banner feed messageID");
		
	}
}
