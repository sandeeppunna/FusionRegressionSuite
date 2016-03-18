package Campaigns;

import org.openqa.selenium.By;
import org.testng.Assert;

import Base.Page;

public class Create_Generic_Ad extends Page
{
	
	public void click_On_Next_If_BackUp_Ad_Not_Created() throws InterruptedException
	{
		topNav.nexter();
		String nexter_Alert = driver.findElement(By.xpath(OR.getProperty("nexteralert"))).getText();
		System.out.println(nexter_Alert);
		log.debug(nexter_Alert);
		Thread.sleep(2000);
	}
	
	public void segment_Count(String sheetName)
	{
		try{
		int segment_Count =	excel.getRowCount(sheetName);
		System.out.println(segment_Count);
		String segmentCount = driver.findElement(By.xpath(OR.getProperty("segmentcount"))).getText().split(" - ")[1];
		System.out.println("Segment Count" + segmentCount);
		
		Assert.assertEquals(segment_Count, Integer.parseInt(segmentCount));
		System.out.println(segment_Count + " displaying as expected");
		log.debug(segment_Count + " displaying as expected");
		}
		catch(Exception e){}
		
	}
	
	public void text_Template(String textline1, String textline2, String textline3, String textline4, String textline5,
			String textline6, String textline7, String textline8, String textline9, String 	textline10)
	{
		String text_Line1 = driver.findElement(By.id(OR.getProperty("textline1"))).getAttribute("value");
		Assert.assertEquals(textline1, text_Line1);
		System.out.println(textline1 +" displaying as customized template textline1");
		
		String text_Line2 = driver.findElement(By.id(OR.getProperty("textline2"))).getAttribute("value");
		Assert.assertEquals(textline2, text_Line2);
		System.out.println(textline2 +" displaying as customized template textline2");
		
		String text_Line3 = driver.findElement(By.id(OR.getProperty("textline3"))).getAttribute("value");
		Assert.assertEquals(textline3, text_Line3);
		System.out.println(textline3 +" displaying as customized template textline3");
		
		String text_Line4 = driver.findElement(By.id(OR.getProperty("textline4"))).getAttribute("value");
		Assert.assertEquals(textline4, text_Line4);
		System.out.println(textline4 +" displaying as customized template textline4");
		
		String text_Line5 = driver.findElement(By.id(OR.getProperty("textline5"))).getAttribute("value");
		Assert.assertEquals(textline5, text_Line5);
		System.out.println(textline5 +" displaying as customized template textline5");
		
		String text_Line6 = driver.findElement(By.id(OR.getProperty("textline6"))).getAttribute("value");
		Assert.assertEquals(textline6, text_Line6);
		System.out.println(textline6 +" displaying as customized template textline6");
		
		String text_Line7 = driver.findElement(By.id(OR.getProperty("textline7"))).getAttribute("value");
		Assert.assertEquals(textline7, text_Line7);
		System.out.println(textline7 +" displaying as customized template textline7");
		
		String text_Line8 = driver.findElement(By.id(OR.getProperty("textline8"))).getAttribute("value");
		Assert.assertEquals(textline8, text_Line8);
		System.out.println(textline8 +" displaying as customized template textline8");
		
		String text_Line9 = driver.findElement(By.id(OR.getProperty("textline9"))).getAttribute("value");
		Assert.assertEquals(textline9, text_Line9);
		System.out.println(textline9 +" displaying as customized template textline9");
		
		String text_Line10 = driver.findElement(By.id(OR.getProperty("textline10"))).getAttribute("value");
		Assert.assertEquals(textline10, text_Line10);
		System.out.println(textline10 +" displaying as customized template textline10");
	}
	
	public void landing_Page_URL(String landingpageurl)
	{
		String landing_URL = driver.findElement(By.id(OR.getProperty("landingurl"))).getAttribute("value");
		
		Assert.assertEquals(landingpageurl, landing_URL);
		
		System.out.println(landing_URL + " displayed as landing page url entered in setup page");
	}
	
	public void create_generic_Ad(String textline1, String textline2, String textline3, String textline4) throws InterruptedException
	{
		if(textline1.contains("< Key")||textline2.contains("< Key")||textline3.contains("< Key")||textline4.contains("< Key"))
		{
			driver.findElement(By.xpath(OR.getProperty("savebutton"))).click();
			String generic_Ad_Alert = driver.findElement(By.xpath(OR.getProperty("genericadalert"))).getText();
			System.out.println(generic_Ad_Alert);
			log.debug(generic_Ad_Alert);
			Thread.sleep(2000);
			if(driver.findElement(By.xpath(OR.getProperty("genericadalert"))).isDisplayed())
			{
				String segment_Year = driver.findElement(By.xpath(OR.getProperty("segmentyear"))).getText();
				String segment_Make = driver.findElement(By.xpath(OR.getProperty("segmentmake"))).getText();
				String segment_Model = driver.findElement(By.xpath(OR.getProperty("segmentmodel"))).getText();
				//TestUtil.get_Segment_Details(segment_Year, segment_Make, segment_Model);

				driver.findElement(By.id(OR.getProperty("textline1"))).clear();
				driver.findElement(By.id(OR.getProperty("textline1"))).sendKeys(textline1.replace("< Key1 >",segment_Make));
				driver.findElement(By.id(OR.getProperty("textline2"))).clear();
				driver.findElement(By.id(OR.getProperty("textline2"))).sendKeys(segment_Year +" "+ segment_Model);
				Thread.sleep(1000);
				driver.findElement(By.xpath(OR.getProperty("savebutton"))).click();
				Thread.sleep(8000);
				if(driver.findElement(By.xpath(OR.getProperty("genericadsuccessmessage"))).isDisplayed())
				{
					String generic_Success_Message = driver.findElement(By.xpath(OR.getProperty("genericadsuccessmessage"))).getText();
					log.debug(generic_Success_Message+ " message displayed");
					System.out.println(generic_Success_Message + " message displayed");
					
				}
				else
				{
					System.out.println("validation is not working for generic success");
				}
			}
		}
		else
		{
			driver.findElement(By.xpath(OR.getProperty("savebutton"))).click();
			String generic_Success_Message = driver.findElement(By.xpath(OR.getProperty("genericadsuccessmessage"))).getText();
			log.debug(generic_Success_Message);
			System.out.println(generic_Success_Message);
			Thread.sleep(8000);
		}
	}
	
	public void create_Back_Up(String textline1, String textline2, String textline3, String textline4) throws InterruptedException
	{
		
		
		topNav.nexter();
		String nexter_Alert = driver.findElement(By.xpath(OR.getProperty("nexteralert"))).getText();
		System.out.println(nexter_Alert);
		log.debug(nexter_Alert);
		Thread.sleep(2000);
		if(driver.findElement(By.xpath(OR.getProperty("nexteralert"))).isDisplayed())
		{
			System.out.println("Validation is working when click on next button if no backupad created");
			log.debug("Validation is working when click on next button if no backupad created");
			Thread.sleep(2000);
			driver.findElement(By.xpath(OR.getProperty("backupcheckbox"))).click();
			
			if(textline1.contains("< Key")||textline2.contains("< Key")||textline3.contains("< Key")||textline4.contains("< Key"))
			{
				driver.findElement(By.xpath(OR.getProperty("savebutton"))).click();
				String backup_Ad_Alert = driver.findElement(By.xpath(OR.getProperty("backupadalert"))).getText();
				System.out.println(backup_Ad_Alert);
				log.debug(backup_Ad_Alert);
				Thread.sleep(2000);
				if(driver.findElement(By.xpath(OR.getProperty("backupadalert"))).isDisplayed())
				{
					driver.findElement(By.xpath(OR.getProperty("nextbutton"))).click();
					//TestUtil.get_Segment_Details(segment_Year, segment_Make, segment_Model);
					String segment_Year = driver.findElement(By.xpath(OR.getProperty("segmentyear"))).getText();
					String segment_Make = driver.findElement(By.xpath(OR.getProperty("segmentmake"))).getText();
					String segment_Model = driver.findElement(By.xpath(OR.getProperty("segmentmodel"))).getText();
					driver.findElement(By.id(OR.getProperty("textline1"))).clear();
					driver.findElement(By.id(OR.getProperty("textline1"))).sendKeys(textline1.replace("< Key1 >",segment_Make));
					driver.findElement(By.id(OR.getProperty("textline2"))).clear();
					driver.findElement(By.id(OR.getProperty("textline2"))).sendKeys(segment_Year + segment_Model);
					
					driver.findElement(By.xpath(OR.getProperty("savebutton"))).click();
					Thread.sleep(12000);
					if(driver.findElement(By.xpath(OR.getProperty("backupadsuccessmessage"))).isDisplayed())
					{
						String backup_Success_Message = driver.findElement(By.xpath(OR.getProperty("backupadsuccessmessage"))).getText();
						log.debug(backup_Success_Message);
						System.out.println(backup_Success_Message);
						Thread.sleep(8000);
						
					}	
					else
					{
						System.out.println("Validation is not working for backup message");
					}
				}
				else
				{
					driver.findElement(By.xpath(OR.getProperty("savebutton"))).click();
					String backup_Success_Message = driver.findElement(By.xpath(OR.getProperty("backupadsuccessmessage"))).getText();
					log.debug(backup_Success_Message);
					System.out.println(backup_Success_Message);
					Thread.sleep(2000);
				}
			}
			else
			{
				driver.findElement(By.xpath(OR.getProperty("savebutton"))).click();			
				if(driver.findElement(By.xpath(OR.getProperty("backupadsuccessmessage"))).isDisplayed())
				{
					String backup_Success_Message = driver.findElement(By.xpath(OR.getProperty("backupadsuccessmessage"))).getText();
					log.debug(backup_Success_Message);
					System.out.println(backup_Success_Message);
					Thread.sleep(8000);
					
				}
				else
				{
					System.out.println("Validation is not working for backup success");
				}
			}
		}
		else
		{
			System.out.println("Navigated to Preview page");
		}
	}
	
	public void backup_Checkbox() throws InterruptedException
	{
		if(!driver.findElement(By.xpath(OR.getProperty("backupcheckbox"))).isEnabled())
		{
			log.debug("Validation is working and Backup Check box is disabled after created backup ad");
			System.out.println("Validation is working and Backup Check box is disabled after created backup ad");
			topNav.nexter();
			Thread.sleep(2000);
		}
		else
		{
			log.debug("Validation is not working and Backup Check box is enabled after created backup ad");
			System.out.println("Validation is not working and Backup Check box is enabled after created backup ad");
			topNav.nexter();
			Thread.sleep(2000);
		}
	}
}