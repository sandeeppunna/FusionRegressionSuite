package Dealers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.Page;

public class Edit_Dealer extends Page
{
	public void edit_Dealer(String dealername, String firstname, String lastname, String contactemail)
	{
		driver.findElement(By.xpath(OR.getProperty("dealersearch"))).sendKeys(dealername);
		driver.findElement(By.xpath(OR.getProperty("searchicon"))).click();
		
		driver.findElement(By.linkText(OR.getProperty("edit"))).click();
		try 
		{
			WebElement first_name=driver.findElement(By.name(OR.getProperty("firsname")));
			WebElement last_name=driver.findElement(By.name(OR.getProperty("lastname")));
			WebElement email=driver.findElement(By.name(OR.getProperty("email")));
			//WebElement phone=driver.findElement(By.name(OR.getProperty("Contactnumber")));
			first_name.clear();
			last_name.clear();
			email.clear();
			//phone.clear();
			
			if ((driver.findElement(By.xpath(OR.getProperty("firstnamerequired"))).isDisplayed())
					&& (driver.findElement(By.xpath(OR.getProperty("lastnamerequired"))).isDisplayed()) 
					&& (driver.findElement(By.xpath(OR.getProperty("emailrequired"))).isDisplayed()))
			{
				WebElement update=driver.findElement(By.xpath(OR.getProperty("update")));
				if(update.isEnabled()==false)
				{
					log.debug("Validation for first name, last name and email working in Edit Dealer");
					log.info("Validation for first name, last name and email working in Edit Dealer");
					first_name.sendKeys(firstname);
					last_name.sendKeys(lastname);
					//phone.sendKeys(contactnumber);
					email.sendKeys(contactemail);
					
//					Select DG=new Select(driver.findElement(By.name("dealerstate")));
//					DG.selectByVisibleText("Audi"); //select Dealer group from DG dropdown
					
					if(driver.findElement(By.xpath(OR.getProperty("update"))).isEnabled())
					{
						log.info("Validation is working for update button");
						driver.findElement(By.xpath(OR.getProperty("update"))).click();

						log.info("Dealer updated successfully !!");
						
					}
					else
					{
						log.info("Validation is not working for update button");
					}
				}
				else
				{
					log.info("Validations in Edit Dealer is not working"); 
				}
			}
			else
			{
				log.debug("Validations are not working for firstname, last name, email" );
			}
		}
		catch(Exception e)
		{
			
		}
	}
}
