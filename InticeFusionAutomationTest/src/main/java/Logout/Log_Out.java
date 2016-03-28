package Logout;

import org.openqa.selenium.By;

import Base.Page;

public class Log_Out extends Page 
{
	public void logout()
	{
		driver.findElement(By.xpath(OR.getProperty("userprofile"))).click();
		driver.findElement(By.xpath(OR.getProperty("logoff"))).click();
	}
}
