package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Utilities.ExcelReader;

public class TestBase 
{
	public static WebDriver driver;
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\loginTest.xlsx");
	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("divpinoyLogger");
	public void Page() throws IOException
	{
		if(driver==null)
		{
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			OR.load(fis);
			log.debug("OR.property file loaded");
			
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
			Config.load(fis);
			log.debug("Config.property file loaded");
			
			if(Config.getProperty("browser").equals("firefox"))
			{
				driver = new FirefoxDriver();
				log.debug("Firefox initialized");
			}
			else if(Config.getProperty("browser").equals("ie"))
			{
				System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			else if(Config.getProperty("browser").equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "ChromeDriver.exe");
				driver = new ChromeDriver();
			}
			
			driver.manage().window().maximize();
			driver.get(Config.getProperty("testsiteurl"));
			driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		}
	}
}
