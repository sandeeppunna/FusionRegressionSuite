package FusionLogin;

import org.openqa.selenium.By;

import Base.Page;

public class TroubleLoggingIn extends Page
{
	public void trouble_Logging_In(String email)
	{
		driver.findElement(By.linkText(OR.getProperty("trouble"))).click();
		driver.findElement(By.id(OR.getProperty("email"))).sendKeys(email);
		driver.findElement(By.xpath(OR.getProperty("emaillink"))).click();
		String text = driver.findElement(By.xpath(OR.getProperty("checkemail"))).getText();
		log.debug(text + "should be display");
		
		driver.findElement(By.linkText(OR.getProperty("retruntologin"))).click();
		
		
	}
	
}
