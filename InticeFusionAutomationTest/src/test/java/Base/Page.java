package Base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Utilities.DbManager;
import Utilities.ExcelReader;
import Utilities.MonitoringMail;

public class Page
{
	public static WebDriver driver;
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\testdata.xlsx");
	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static TopNavigations topNav;
	public static MonitoringMail mail;
	public Page()  
	{
		try
		{
		if(driver==null)
		{
			//DbManager.setDbConnection();
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			OR.load(fis);
			log.debug("OR.property file loaded");
			
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
			Config.load(fis);
			log.debug("Config.property file loaded");
			
			if(Config.getProperty("browser").equals("firefox"))
			{
				ProfilesIni pr = new ProfilesIni();
				FirefoxProfile fp = pr.getProfile("Seleniumuser");
				
				driver = new FirefoxDriver(fp);
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
			topNav = new TopNavigations();
			}
		}
		catch(Exception e){}
		
	}
}
