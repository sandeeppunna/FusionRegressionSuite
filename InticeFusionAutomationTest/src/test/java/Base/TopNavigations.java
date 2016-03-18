package Base;

import org.openqa.selenium.By;


public class TopNavigations 
{
	public void doSearch()
	{
		
	}
	
	public void logOut()
	{
		Page.driver.findElement(By.xpath(".//*[@id='users-setting']/span")).click();
		Page.driver.findElement(By.linkText("Log off")).click();
	}
	
	public void gotoHome()
	{
		Page.driver.findElement(By.xpath(".//*[@id='brand']/a/img")).click();
	}
	
	public void adminLinks()
	{
		Page.driver.findElement(By.xpath(".//*[@id='wrapper']/aside/div[2]/nav/ul/li[6]/a")).click();
	}
	
	public void adminQuickLinks()
	{
		Page.driver.findElement(By.xpath(".//*[@id='admin']/li[1]/a")).click();
	}
	
	public void nexter()
	{
		Page.driver.findElement(By.xpath(".//*[@id='content']/footer/div/div[3]/a")).click();
	}
	
	public void back()
	{
		Page.driver.findElement(By.xpath(".//*[@id='content']/footer/div/div[1]/a")).click();
	}
}
