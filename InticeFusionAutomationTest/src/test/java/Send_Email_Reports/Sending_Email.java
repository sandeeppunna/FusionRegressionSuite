package Send_Email_Reports;

import java.io.IOException;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Page;
import Campaigns.Mutliple_Segments;
import Utilities.TestConfig;
import Utilities.TestUtil;

public class Sending_Email extends Page
{
		@BeforeTest
		public void isSkip()
		{
			if(!TestUtil.isExecutable("Sending_Email"))
			{
				throw new SkipException("Skipping the test as the Run mode is No");
			}
		}
		
		@Test(groups={"bvt","regression", "mail"})
		public void verify_Sending_Email() throws IOException, SQLException, AddressException, MessagingException
		{
			Mutliple_Segments multi = new Mutliple_Segments();
			
			multi.auto_Email(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody, TestConfig.attachmentPath, TestConfig.attachmentName);
			
			TestUtil.CaptureScreenshot();
		}
		
}



