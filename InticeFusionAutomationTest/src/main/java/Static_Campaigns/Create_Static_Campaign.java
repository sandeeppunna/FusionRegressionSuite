package Static_Campaigns;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Base.Page;
import Utilities.ExcelReader;

public class Create_Static_Campaign extends Page
{
public static ExcelReader list = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\list1801.xlsx");
	
	public void create_Static_Campaign(String headername)
	{
		driver.findElement(By.xpath(OR.getProperty("createcampaign"))).click();
		log.debug("Clicked on Create Campaign");
		System.out.println("Clicked on Create Campaign");
		String header_Name = driver.findElement(By.xpath(OR.getProperty("header"))).getText();
		Assert.assertEquals(headername, header_Name);
		System.out.println(headername +" page dispalyed");
		log.debug(headername + "page displayed");
	}
	
	public void choose_A_type()
	{
		driver.findElement(By.xpath(OR.getProperty("staticdisplay"))).click();
		System.out.println("selected stataic campaign");
		log.debug("selected static campaign");
		System.err.println("Navigate to Select a List Page");
		log.debug("Navigate to Select a List Page");
	}
	
	public void select_A_List(String dealername) throws InterruptedException
	{
		topNav.nexter();
		String list_validation = driver.findElement(By.xpath(OR.getProperty("listalert"))).getText();
		System.out.println(list_validation + " validation displayed");
		log.debug(list_validation + " validation displayed");
		if(driver.findElement(By.xpath(OR.getProperty("listalert"))).isDisplayed())
		{
			log.debug("validation is working for select list without selecting list when click on next");
			System.out.println("validation is working for select list without selecting list when click on next");
			Select dealer_Name = new Select(driver.findElement(By.id(OR.getProperty("selectdealer"))));
			dealer_Name.selectByVisibleText(dealername);
		    Thread.sleep(1000);
			driver.findElement(By.id(OR.getProperty("selectlist"))).click();
			System.out.println("List Selected");
			log.debug("List selected");
			topNav.nexter();
			System.out.println("Navigate to Campaign Setup Page");
			log.debug("Navigate to Campaign Setup Page");
		}
		else
		{
			System.out.println("validation is not working for select a list page");
		}
	}
	
	public void campaign_Setup(String setupheader)
	{
		String setup_Header = driver.findElement(By.xpath(OR.getProperty("setupheader"))).getText();
		Assert.assertEquals(setupheader, setup_Header);
		System.out.println(setupheader + " page displayed");
	}
	
	public void campaign_General_Info(String campaignname, String campaignname1, String startdate, String startdate1,
			String enddate, String enddate1) throws InterruptedException 
	{
		topNav.nexter();
		String setup_Validation = driver.findElement(By.xpath(OR.getProperty("setupalert"))).getText();
		System.out.println(setup_Validation +" validation dispalyed");
		log.debug(setup_Validation +" validtaion displayed");
		
		if(driver.findElement(By.xpath(OR.getProperty("setupalert"))).isDisplayed())
		{
			System.out.println("Validation is working correctly for setup when click on next without entering anything");
			log.debug("Validation is working correctly for setup when click on next without entering anything");
			
			driver.findElement(By.xpath(OR.getProperty("campaignname"))).sendKeys(campaignname1);
			System.out.println("entered campaign name as "+ campaignname1);
			Thread.sleep(2000);
			if(driver.findElement(By.xpath(OR.getProperty("alreadyexists"))).isDisplayed())
			{
				driver.findElement(By.name(OR.getProperty("campaignname"))).clear();
				driver.findElement(By.name(OR.getProperty("campaignname"))).sendKeys(campaignname1);
			}
			String actual_List = driver.findElement(By.xpath(OR.getProperty("listbreadcrum"))).getText();
			String list_Name = driver.findElement(By.name(OR.getProperty("listname"))).getAttribute("value");
			Assert.assertEquals(actual_List, list_Name);
			log.debug(actual_List + "Selected List and displayed list are same");
			System.out.println(list_Name + "Selected List and displayed list are same");
			Thread.sleep(2000);		
			
			driver.findElement(By.id(OR.getProperty("startdate"))).sendKeys(startdate);
			System.out.println("entered Start Date");
			log.debug("entered Start Date");
			Thread.sleep(2000);		
			String startlessthancurrent = driver.findElement(By.xpath(OR.getProperty("startdatelessthancurrentdate"))).getText();
			System.out.println(startlessthancurrent+ " validation is displayed");
			log.debug(startlessthancurrent+ " validation is displayed");
			
			if(driver.findElement(By.xpath(OR.getProperty("startdatelessthancurrentdate"))).isDisplayed())
			{
				driver.findElement(By.id(OR.getProperty("startdate"))).clear();
				Thread.sleep(2000);
				driver.findElement(By.id(OR.getProperty("startdate"))).sendKeys(startdate1);
				System.out.println("entered valid Start Date");
				log.debug("entered valid Start Date");
			}
			
			driver.findElement(By.id(OR.getProperty("enddate"))).sendKeys(enddate);
			System.out.println("entered End Date");
			log.debug("entered End Date");
			Thread.sleep(2000);		
			String endgreaterthanstart = driver.findElement(By.xpath(OR.getProperty("enddategreaterthanstartdate"))).getText();
			System.out.println(endgreaterthanstart +" validation is displaying");
			log.debug(endgreaterthanstart + " validation is displayed");
			
			if(driver.findElement(By.xpath(OR.getProperty("enddategreaterthanstartdate"))).isDisplayed())
			{
				driver.findElement(By.id(OR.getProperty("enddate"))).clear();
				Thread.sleep(2000);
				driver.findElement(By.id(OR.getProperty("enddate"))).sendKeys(enddate1);
				System.out.println("entered valid End Date");
				log.debug("entered valid End Date");
			}
			
			String actual_Start_Date = driver.findElement(By.id(OR.getProperty("actualstartdate"))).getAttribute("value");
//			System.out.println(actual_Start_Date);
			Assert.assertEquals(actual_Start_Date, startdate1);
			System.out.println("Actual Start Date and Start Date both are same");
		
//			driver.findElement(By.name(OR.getProperty("creativeids"))).sendKeys(creativeids);
		}
		else 
		{
			System.out.println("Validation is not working for setup when click on next without entering anything");
		}
	}
	
	public void campaign_Landing_Page_Details(String landingurl, String landingurl1, String campaigncontent, String campaigncontent1,
			String campaignsource, String campaignsource1, String campaignmedium, String campaignmedium1, String campaignterm, String campaignterm1,
			String campaignname, String campaignname1) throws InterruptedException
	{
		
			driver.findElement(By.name(OR.getProperty("landingpageurl"))).sendKeys(landingurl);
			System.out.println("entered Invalid Url");
			log.debug("entered Invalid Url");
			String invalidURL = driver.findElement(By.xpath(OR.getProperty("invalidlandingurl"))).getText();
			System.out.println(invalidURL +" validation is displayed");
			log.debug(invalidURL +" validation is displayed");
			Thread.sleep(1000);
			if(driver.findElement(By.xpath(OR.getProperty("invalidlandingurl"))).isDisplayed())
			{
				driver.findElement(By.name(OR.getProperty("landingpageurl"))).clear();
				driver.findElement(By.name(OR.getProperty("landingpageurl"))).sendKeys(landingurl1);
				System.out.println("entered valid Url");
				log.debug("entered valid Url");
			}
			
			boolean content = driver.findElement(By.name(OR.getProperty("campaigncontent"))).isEnabled();
			
			System.out.println("Campaign Content for Static campaign is "+ content);
			log.debug("Campaign Content for Static campaign is "+ content);
				
			driver.findElement(By.name(OR.getProperty("campaignsource"))).clear();
			System.out.println("removed text from campaign source");
			log.debug("removed text from campaign source");
			Thread.sleep(1000);
			String requiredSource = driver.findElement(By.xpath(OR.getProperty("sourcerequired"))).getText();
			System.out.println(requiredSource +" validation displayed");
			log.debug(requiredSource + "validation displayed");
			if(driver.findElement(By.xpath(OR.getProperty("sourcerequired"))).isDisplayed())
			{
				System.out.println("Validation is working fine for Campaign source mandatory field");
				log.debug("Validation is working fine for Campaign source mandatory field");
				driver.findElement(By.name(OR.getProperty("campaignsource"))).sendKeys(campaignsource);
				System.out.println("entered campaign source with spaces");
				log.debug("entered campaign source with spaces");
				String invalidSource = driver.findElement(By.xpath(OR.getProperty("invalidsource"))).getText();
				System.out.println(invalidSource + " validation displayed");
				log.debug(invalidSource +" validation displayed");
				Thread.sleep(1000);
				if(driver.findElement(By.xpath(OR.getProperty("invalidsource"))).isDisplayed())
				{
					System.out.println("Validation is working fine for Campaign source if it has spaces");
					log.debug("Validation is working fine for Campaign source if it has spaces");
					driver.findElement(By.name(OR.getProperty("campaignsource"))).clear();
					driver.findElement(By.name(OR.getProperty("campaignsource"))).sendKeys(campaignsource1);
					System.out.println("entered campaign source without spaces");
					log.debug("entered campaign source without spaces");
				}
				else
				{
					System.out.println("Validation is not working for campaign source if it has spaces");
					log.debug("Validation is not working for campaign source if it has spaces");
				}
			}
			else
			{
				System.out.println("Validation is not working for Campaign Source mandatory field");
				log.debug("Validation is not working for Campaign Source mandatory field");
			}
			
			driver.findElement(By.name(OR.getProperty("campaignmedium"))).clear();
			System.out.println("removed text from campaign medium");
			log.debug("removed text from campaign medium");
			Thread.sleep(1000);
			String requiredMedium= driver.findElement(By.xpath(OR.getProperty("mediumrequired"))).getText();
			System.out.println(requiredMedium +" validation displayed");
			log.debug(requiredMedium + "validation displayed");
			if(driver.findElement(By.xpath(OR.getProperty("mediumrequired"))).isDisplayed())
			{
				System.out.println("Validation is working fine for Campaign Medium mandatory field");
				log.debug("Validation is working fine for Campaign Medium mandatory field");
				driver.findElement(By.name(OR.getProperty("campaignmedium"))).sendKeys(campaignmedium);
				System.out.println("entered campaign medium with spaces");
				log.debug("entered campaign medium with spaces");
				String invalidMedium = driver.findElement(By.xpath(OR.getProperty("invalidmedium"))).getText();
				System.out.println(invalidMedium + " validation displayed");
				log.debug(invalidMedium +" validation displayed");
				Thread.sleep(1000);
				if(driver.findElement(By.xpath(OR.getProperty("invalidmedium"))).isDisplayed())
				{
					System.out.println("Validation is working fine for Campaign medium if it has spaces");
					log.debug("Validation is working fine for Campaign medium if it has spaces");
					driver.findElement(By.name(OR.getProperty("campaignmedium"))).clear();
					driver.findElement(By.name(OR.getProperty("campaignmedium"))).sendKeys(campaignmedium1);
					System.out.println("entered campaign medium without spaces");
					log.debug("entered campaign medium without spaces");
				}
				else
				{
					System.out.println("Validation is not working for campaign medium if it has spaces");
					log.debug("Validation is not working for campaign medium if it has spaces");
				}
			}
			else
			{
				System.out.println("Validation is not working for Campaign medium mandatory field");
				log.debug("Validation is not working for Campaign Medium mandatory field");
			}
			
			
			driver.findElement(By.name(OR.getProperty("campaignterm"))).sendKeys(campaignterm);
			System.out.println("entered campaign term with spaces");
			log.debug("entered campaign term with spaces");
			Thread.sleep(1000);
			String invalidTerm = driver.findElement(By.xpath(OR.getProperty("invalidterm"))).getText();
			System.out.println(invalidTerm + " validation displayed");
			log.debug(invalidTerm +" validation displayed");
			if(driver.findElement(By.xpath(OR.getProperty("invalidterm"))).isDisplayed())
			{
				System.out.println("Validation is working fine for Campaign Term if it has spaces");
				log.debug("Validation is working fine for Campaign Term if it has spaces");
				driver.findElement(By.name(OR.getProperty("campaignterm"))).clear();
				driver.findElement(By.name(OR.getProperty("campaignterm"))).sendKeys(campaignterm1);
				System.out.println("entered campaign term without spaces");
				log.debug("entered campaign term without spaces");
			}
			else
			{
				System.out.println("Validation is not working for campaign term if it has spaces");
				log.debug("Validation is not working for campaign term if it has spaces");
			}
			
			driver.findElement(By.xpath(OR.getProperty("landingcampaignname"))).clear();
			System.out.println("removed text from campaign name");
			log.debug("removed text from campaign name");
			Thread.sleep(1000);
			String requiredName= driver.findElement(By.xpath(OR.getProperty("namerequired"))).getText();
			System.out.println(requiredName +" validation displayed");
			log.debug(requiredName + "validation displayed");
			if(driver.findElement(By.xpath(OR.getProperty("namerequired"))).isDisplayed())
			{
				System.out.println("Validation is working fine for Campaign Name mandatory field");
				log.debug("Validation is working fine for Campaign Name mandatory field");
				driver.findElement(By.xpath(OR.getProperty("landingcampaignname"))).sendKeys(campaignname);
				System.out.println("entered campaign name with spaces");
				log.debug("entered campaign name with spaces");
				Thread.sleep(1000);
				String invalidName = driver.findElement(By.xpath(OR.getProperty("invalidname"))).getText();
				System.out.println(invalidName + " validation displayed");
				log.debug(invalidName +" validation displayed");
				if(driver.findElement(By.xpath(OR.getProperty("invalidname"))).isDisplayed())
				{
					System.out.println("Validation is working fine for Campaign Name if it has spaces");
					log.debug("Validation is working fine for Campaign Name if it has spaces");
					driver.findElement(By.xpath(OR.getProperty("landingcampaignname"))).clear();
					driver.findElement(By.xpath(OR.getProperty("landingcampaignname"))).sendKeys(campaignname1);
					System.out.println("entered campaign name without spaces");
					log.debug("entered campaign name without spaces");
				}
				else
				{
					System.out.println("Validation is not working for campaign name if it has spaces");
					log.debug("Validation is not working for campaign name if it has spaces");
				}
			}
			else
			{
				System.out.println("Validation is not working for Campaign name mandatory field");
				log.debug("Validation is not working for Campaign name mandatory field");
			
			}
			
			topNav.nexter();
	}
	
	public void campaign_Billing_Details(String costperrecord, String estimatematchrate, String targetcpm)
	{
		String cost_Per_Record = driver.findElement(By.name(OR.getProperty("costperrecord"))).getAttribute("value");
		Assert.assertEquals(cost_Per_Record, costperrecord);
		System.out.println("Cost per record displayed correctly");
		log.debug("Cost per record displayed correctly");
		
		String estimated_Match_Rate = driver.findElement(By.name(OR.getProperty("estimatedmatchrate"))).getAttribute("value");
		Assert.assertEquals(estimated_Match_Rate, estimatematchrate);
		System.out.println("Estimated match rate displayed correctly");
		log.debug("Estimated match rate displayed correctly");
		
		String target_CPM = driver.findElement(By.name(OR.getProperty("targetcpm"))).getAttribute("value");
		Assert.assertEquals(target_CPM, targetcpm);
		System.out.println("Target CPM displayed correctly");
		log.debug("Target CPM displayed correctly");
	}
	
	public void campaign_Budget_Details( String sheetName, String budgetcostperrecord)
	{		
		int rows = list.getRowCount(sheetName);
		String listcount = driver.findElement(By.name(OR.getProperty("numberofrecords"))).getAttribute("value");

		Assert.assertEquals(listcount, Integer.toString(rows));
		System.out.println("No of Records displayed correclty");
		log.debug("No of Records displayed correclty");
		
		String budget_Cost_Per_Record = driver.findElement(By.name(OR.getProperty("budgetcostperrecord"))).getAttribute("value");
		Assert.assertEquals(budget_Cost_Per_Record, budgetcostperrecord);
		System.out.println("Cost per record for Budget details displayed correctly");
		log.debug("Cost per record for Budget details displayed correctly");
		
		int Campaign_Cost = (rows*Integer.parseInt(budget_Cost_Per_Record)); 		
		String total_Campaign_Cost = driver.findElement(By.name(OR.getProperty("totalcampaigncost"))).getAttribute("value");
		Assert.assertEquals(total_Campaign_Cost, Integer.toString(Campaign_Cost));
		System.out.println("Total Campaign cost calculated correctly");
		log.debug("Total Campaign cost calculated correctly");
	}
	
	public void campaign_Impression_Details(String impressionperrecord, String sheetName) throws InterruptedException
	{
		int rows = list.getRowCount(sheetName);
		String impression_number_Of_Records = driver.findElement(By.name(OR.getProperty("impressionnumberofrecords"))).getAttribute("value");
		Assert.assertEquals(impression_number_Of_Records, Integer.toString(rows));
		System.out.println("NO of records for impression details are displayed correctly");
		log.debug("NO of records for impression details are displayed correctly");
		
		String imp_Per_Record = driver.findElement(By.name(OR.getProperty("impressionsperrecord"))).getAttribute("value");
		Assert.assertEquals(imp_Per_Record, impressionperrecord);
		System.out.println("Impression per record displayed correctly");
		log.debug("Impression per record displayed correctly");
		
		int impgoal = (rows*Integer.parseInt(imp_Per_Record));
		String impression_Goal = driver.findElement(By.name(OR.getProperty("impressiongoal"))).getAttribute("value");
		Assert.assertEquals(impression_Goal, Integer.toString(impgoal));
		System.out.println("Impression goal calculated correctly");
		log.debug("Impression goal calculated correctly");
		
		topNav.nexter();
		Thread.sleep(5000);
	}
}
