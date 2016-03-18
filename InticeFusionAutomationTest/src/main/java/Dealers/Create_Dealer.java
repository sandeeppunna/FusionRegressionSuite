package Dealers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Base.Page;

public class Create_Dealer extends Page
{
	public void create_Dealer(String firstname, String lastname, String contactnumber, String contactemail,
			String dgroup, String dealername, String dealername1)
	{
		try
		{
			driver.findElement(By.linkText(OR.getProperty("create"))).click();
			WebElement save=driver.findElement(By.xpath(OR.getProperty("dealersave")));
		
			if (save.isEnabled()==false) 
			{
				log.debug("validation is working for save");
				log.info("Validations are working in Create Dealer \n");
				driver.findElement(By.name(OR.getProperty("firsName"))).sendKeys(firstname);
				driver.findElement(By.name(OR.getProperty("lastName"))).sendKeys(lastname);
				driver.findElement(By.name(OR.getProperty("ContactPhoneNo"))).sendKeys(contactnumber);
				driver.findElement(By.name(OR.getProperty("email"))).sendKeys(contactemail);
			
				Select DG=new Select(driver.findElement(By.xpath(OR.getProperty("dgdropdown"))));
				DG.selectByVisibleText(dgroup); //select Dealer group from DG dropdown
			
				WebElement dname = driver.findElement(By.xpath(OR.getProperty("dealername")));
				dname.sendKeys(dealername);
				//driver.findElement(By.linkText("Cancel")).click(); //click on cancel
				driver.findElement(By.name(OR.getProperty("yes"))).click();//click on Active radio button
			
				if(driver.findElement(By.xpath(OR.getProperty("dealersave"))).isEnabled())
				{
					log.info("Validations are working for Save button ");
					driver.findElement(By.xpath(OR.getProperty("dealersave"))).click();
				
					if(driver.findElement(By.xpath(OR.getProperty("dealerheader"))).isDisplayed())
					{
						log.debug("Validation is woking for duplicate dealer");
						dname.clear();
						dname.sendKeys(dealername1);
						driver.findElement(By.xpath(OR.getProperty("dealersave"))).click();
						log.debug(dealername1 + "created successfully");
						log.info("Dealer created successfully !!");
					}
					else
					{
						log.debug(dealername + "created successfully"); 
						log.info("Validation is not working for duplicate Dealer");
					}
				}
				else
				{
					log.info("Validations are not working for Save button");
				}
			}
			else
			{
				log.info("Validations are not working in Create Dealer");  
			}
		
			String dealerid = driver.findElement(By.xpath(".//*[@id='dealerList']/table/tbody/tr[2]/td[1]/small")).getText();
			log.debug(dealerid);
			log.info(dealerid);
		}
		catch (Exception CreateDealer) 
		{
		
		} 
	}
}
