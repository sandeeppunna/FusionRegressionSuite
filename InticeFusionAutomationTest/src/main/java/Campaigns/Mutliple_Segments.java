package Campaigns;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;



import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.DbManager;
import Utilities.MonitoringMail;
import Utilities.TestUtil;
import Base.Page;

public class Mutliple_Segments extends Page 
{
	public void multiple_To_Matched_Segments() throws IOException 
	{
		driver.findElement(By.xpath(OR.getProperty("multiplesegments"))).click();
		driver.findElement(By.xpath(OR.getProperty("clickonfirstrow"))).click();
		driver.findElement(By.xpath(OR.getProperty("selectsegmenttemplate"))).click();
		TestUtil.CaptureScreenshot();
		driver.findElement(By.xpath(OR.getProperty("refreshbutton"))).click();
	}
	
	public void multiple_Segment_Count_After_MovedTo_Matched() throws SQLException
	{
		List<String> multiple   = 	DbManager.getQuery("select m.Messagekey1,m.Messagekey2,m.Messagekey3 from members m,segmenttemplates s where m.importlistid='7a07908b-5bde-45c0-bb39-848556eeb066' and s.segmentID='F563E5E0-B2CA-458F-95E6-4E131A3AC31A' and m.Messagekey1=s.yr and m.messagekey2=s.make and m.messagekey3=s.model group by m.Messagekey1,m.Messagekey2,m.Messagekey3 intersect select yr,make,model from segmenttemplates s where s.segmentid='F563E5E0-B2CA-458F-95E6-4E131A3AC31A' group by s.yr,s.make,s.model having count(*) >1");
		int multiplecount = multiple.size();
		
		String multiple_Segment_Count = driver.findElement(By.xpath(OR.getProperty("mutliplesegmentcount"))).getText();
		
		Assert.assertEquals(multiplecount, Integer.parseInt(multiple_Segment_Count));
		
		System.out.println("Multiple segment count after moved to matched " + multiple_Segment_Count);
	}	
	
	public void matched_Segment_Count_After_MovedTo_Mathced() throws SQLException
	{
		List<String> match = DbManager.getQuery("select m.Messagekey1,m.Messagekey2,m.Messagekey3 from members m,segmenttemplates s where m.importlistid='7a07908b-5bde-45c0-bb39-848556eeb066' and s.segmentID='F563E5E0-B2CA-458F-95E6-4E131A3AC31A' and m.Messagekey1=s.yr and m.messagekey2=s.make and m.messagekey3=s.model group by m.Messagekey1,m.Messagekey2,m.Messagekey3 intersect select yr,make,model from segmenttemplates s where s.segmentid='F563E5E0-B2CA-458F-95E6-4E131A3AC31A' group by s.yr,s.make,s.model having count(*) =1");
		int matchedcount = match.size();
		
		String matched_Segment_Count = driver.findElement(By.xpath(OR.getProperty("matchedsegmentcount"))).getText();
		
		Assert.assertEquals(matchedcount, Integer.parseInt(matched_Segment_Count));
		
		System.out.println("Matched Segment count after segment moved to matched "+ matched_Segment_Count);
	}
	
	public void auto_Email(String mailServer, String from, String[] to, String subject, String messageBody, String attachmentPath, String attachmentName) throws AddressException, MessagingException
	{
		mail=new MonitoringMail();
		mail.sendMail(mailServer, from, to, subject, messageBody, attachmentPath, attachmentName);
	}
	public void multiple_Segments_Pagination()
	{
		
	}
	
	public void multiple_Segments_View()
	{
		
	}
	
}
