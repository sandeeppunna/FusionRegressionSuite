package Campaigns;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Utilities.Counter_Excel;
import Utilities.DbManager;
import Base.Page;

public class Manage_Segments extends Page 
{
	public void select_Segment_For_Matching(String segmentname) throws InterruptedException
	{
//		topNav.nexter();
//		String manage_Segment_Alert = driver.findElement(By.xpath("managesegmentalert")).getText();
//		System.out.println(manage_Segment_Alert+ " validation displayed");
//		log.debug(manage_Segment_Alert+ " validation displayed");
//		if(driver.findElement(By.xpath("managesegmentalert")).isDisplayed())
//		{
//			log.debug("Validation is working correctly for Manage segment page if click on next without selecting a segment");
//			System.out.println("Validation is working correctly for Manage segment page if click on next without selecting a segment");
//			log.debug("Validation is working correctly for Manage segment page if click on next without selecting a segment");
			Select select_Segment = new Select(driver.findElement(By.xpath(OR.getProperty("selectsegment"))));
			select_Segment.selectByVisibleText(segmentname);
			System.out.println("Selected segment");
			log.debug("Selected segment");
			Thread.sleep(5000);
			topNav.nexter();
		//}
	}
	
	public void matched_Multiple_Missed_Segments(String file1, String file2) throws IOException
	{
//		Counter_Excel cExcel = new Counter_Excel();
		Counter_Excel.Manage_Segments(file1, file2);
	}
	public void matched_Segments_Count() throws SQLException, InterruptedException
	{
		List<String> match = DbManager.getQuery("select m.Messagekey1,m.Messagekey2,m.Messagekey3 from members m,segmenttemplates s where m.importlistid='7a07908b-5bde-45c0-bb39-848556eeb066' and s.segmentID='F563E5E0-B2CA-458F-95E6-4E131A3AC31A' and m.Messagekey1=s.yr and m.messagekey2=s.make and m.messagekey3=s.model group by m.Messagekey1,m.Messagekey2,m.Messagekey3 intersect select yr,make,model from segmenttemplates s where s.segmentid='F563E5E0-B2CA-458F-95E6-4E131A3AC31A' group by s.yr,s.make,s.model having count(*) =1");
		int matchedcount = match.size();
		
		String matched_Count = driver.findElement(By.xpath(OR.getProperty("matchedsegmentcount"))).getText();
		Assert.assertEquals(matchedcount, Integer.parseInt(matched_Count));
		
		System.out.println(matched_Count + " displaying for matched segments");
	}
	
	public void mutliple_Segments_Count() throws SQLException
	{
		List<String> multiple   = 	DbManager.getQuery("select m.Messagekey1,m.Messagekey2,m.Messagekey3 from members m,segmenttemplates s where m.importlistid='7a07908b-5bde-45c0-bb39-848556eeb066' and s.segmentID='F563E5E0-B2CA-458F-95E6-4E131A3AC31A' and m.Messagekey1=s.yr and m.messagekey2=s.make and m.messagekey3=s.model group by m.Messagekey1,m.Messagekey2,m.Messagekey3 intersect select yr,make,model from segmenttemplates s where s.segmentid='F563E5E0-B2CA-458F-95E6-4E131A3AC31A' group by s.yr,s.make,s.model having count(*) >1");
		int multiplecount = multiple.size();
		
		String multiple_Count = driver.findElement(By.xpath(OR.getProperty("mutliplesegmentcount"))).getText();
		
		Assert.assertEquals(multiplecount, Integer.parseInt(multiple_Count));
		System.out.println(multiple_Count + " displaying for mutliple segments");
	}
	
	public void missed_Segments_Count() throws SQLException
	{
		List<String>	missed =	 DbManager.getQuery("select m.Messagekey1,m.Messagekey2,m.Messagekey3 from members m,segmenttemplates s where m.importlistid='7a07908b-5bde-45c0-bb39-848556eeb066' and s.segmentID='F563E5E0-B2CA-458F-95E6-4E131A3AC31A' and (m.Messagekey1!=s.yr or m.messagekey2!=s.make or m.messagekey3!=s.model) group by m.Messagekey1,m.Messagekey2,m.Messagekey3 except select yr,make,model from segmenttemplates s where s.segmentid='F563E5E0-B2CA-458F-95E6-4E131A3AC31A' group by s.yr,s.make,s.model ");
		int missedcount = missed.size();
		
		String missed_Count = driver.findElement(By.xpath(OR.getProperty("missedsegmentcount"))).getText();
		
		Assert.assertEquals(missedcount, Integer.parseInt(missed_Count));
		
		System.out.println(missed_Count + " displaying for missed segments");
		
		topNav.nexter();
		
	}
	public void total_Matched() throws SQLException
	{
		List<String> multiple   = 	DbManager.getQuery("select m.Messagekey1,m.Messagekey2,m.Messagekey3 from members m,segmenttemplates s"+
								"where m.importlistid='7a07908b-5bde-45c0-bb39-848556eeb066' and s.segmentID='F563E5E0-B2CA-458F-95E6-4E131A3AC31A'"+
								"and m.Messagekey1=s.yr and m.messagekey2=s.make and m.messagekey3=s.model"+ 
								"group by m.Messagekey1,m.Messagekey2,m.Messagekey3"+ 
								"intersect select yr,make,model from members m"+
								"where s.segmentid='F563E5E0-B2CA-458F-95E6-4E131A3AC31A'"+
								"group by s.yr,s.make,s.model");
		int mutiplecount = multiple.size();
		
		System.out.println(mutiplecount +" displaying for total match");
		
	}
}
	

