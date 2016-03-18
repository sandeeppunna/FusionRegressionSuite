package ManageOffers;

import org.openqa.selenium.By;

import Base.Page;

public class CreateOffer extends Page 
{
	public void createOffer()
	{
		driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div/div/div[1]/div[2]/a")).click();

		

//		Assert.assertEquals(add_New_Offer, "Add New Offer");
		
	}
	
}
