package FusionLogin;

import java.io.IOException;

import org.openqa.selenium.By;



import Base.Page;

public class FusionHomePage extends Page
{
	public void login(String username, String password) throws IOException
	{
		driver.findElement(By.id(OR.getProperty("username"))).sendKeys(username);
		driver.findElement(By.id(OR.getProperty("password"))).sendKeys(password);
		driver.findElement(By.xpath(OR.getProperty("login"))).click();
	}
	
	public void validateItems()
	{
		
		
		
	}
}
