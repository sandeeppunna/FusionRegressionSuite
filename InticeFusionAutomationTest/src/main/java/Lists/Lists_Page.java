package Lists;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Base.Page;

public class Lists_Page extends Page
{
	public void list_Table(String listheader) throws InterruptedException
	{
		topNav.adminQuickLinks();
		driver.findElement(By.xpath(OR.getProperty("lists"))).click();
		String list_Header = driver.findElement(By.xpath(OR.getProperty("listheader"))).getText();
		
		Assert.assertEquals(list_Header, listheader);
		log.debug(listheader + "displayed successfully");
	}
	
	public void search_List(String listname)
	{
		driver.findElement(By.xpath(OR.getProperty("listsearch"))).sendKeys(listname);
		driver.findElement(By.xpath(OR.getProperty("searchicon"))).click();
		
		String searched_List = driver.findElement(By.xpath(OR.getProperty("searchedlist"))).getText();
		Assert.assertEquals(listname, searched_List);
		
		log.debug("search is working fine");
	}
	
	public void list_Pagination()
	{
		
	}
	
	public void list_View()
	{
		
	}
	
	public void import_Members(String path)
	{
		driver.findElement(By.linkText(OR.getProperty("importmembers"))).click();
		
		WebElement up_Load = driver.findElement(By.xpath(OR.getProperty("upload")));
		
		if(up_Load.isEnabled()==false)
		{
			log.debug("validations working for update");
			driver.findElement(By.xpath(OR.getProperty("selectfile"))).sendKeys(path);
			
			if(up_Load.isEnabled())
			{
				log.debug("Upload button enabled after select the file");
				driver.findElement(By.xpath(OR.getProperty("upload"))).click();
			}
			else
			{
				log.debug("validation is not working for upload button when enabled");
			}
		}
		else
		{
			log.info("validation is not working for upload button when disabled");
		}
	}
	
	public void list_Setup(String firstname, String lastname, String addressline1, String city, 
			String state, String zip, String messagekey1, String messagekey2, String messagekey3)
	{
		Select firstName=new Select(driver.findElement(By.xpath(OR.getProperty("listfirstname"))));
		firstName.selectByVisibleText(firstname); //select First Name from view dropdown
		log.debug("Selected first name");			
		Select lastName= new Select(driver.findElement(By.xpath(OR.getProperty("listlastname"))));
		lastName.selectByVisibleText(lastname);//select Last Name from view dropdown
		log.debug("Selected last name");
		Select addressLine1= new Select(driver.findElement(By.xpath(OR.getProperty("listaddressline1"))));
		addressLine1.selectByVisibleText(addressline1);//select Address Line 1 from view dropdown
		log.debug("Selected address line1");
		Select cityname= new Select(driver.findElement(By.xpath(OR.getProperty("listcity"))));
		cityname.selectByVisibleText(city);//select City from view dropdown
		log.debug("Selected city");
		Select statename= new Select(driver.findElement(By.xpath(OR.getProperty("liststate"))));
		statename.selectByVisibleText(state);//select State from view dropdown
		log.debug("Selected state");
		Select zipCode= new Select(driver.findElement(By.xpath(OR.getProperty("listzip"))));
		zipCode.selectByVisibleText(zip);//select Zip from view dropdown
		log.debug("Selected zip");
		Select messageKey1= new Select(driver.findElement(By.xpath(OR.getProperty("messagekey1"))));
		messageKey1.selectByVisibleText(messagekey1);//select Message Key1 from view dropdown
		log.debug("Selected Message key1");
		Select messageKey2= new Select(driver.findElement(By.xpath(OR.getProperty("messagekey2"))));
		messageKey2.selectByVisibleText(messagekey2);//select Message Key2 from view dropdown
		log.debug("Selected Message key2");
		Select messageKey3= new Select(driver.findElement(By.xpath(OR.getProperty("messagekey3"))));
		messageKey3.selectByVisibleText(messagekey3);//select Message Key3 from view dropdown
		log.debug("Selected Message key3");
		driver.findElement(By.xpath(OR.getProperty("process"))).click();
		log.debug("click on proceed button");
		
	}
}