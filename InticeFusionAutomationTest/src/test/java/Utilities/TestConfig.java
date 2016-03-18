package Utilities;



public class TestConfig
{
	public static String server="smtp.gmail.com";
	public static String from = "sandeeppunna23@gmail.com";
	public static String password = "Sandy_punna@!";
	public static String[] to ={"surekha@inticeinc.com","sandeep.punna21@gmail.com"};
	public static String subject = "Test Report";
	
	public static String messageBody ="TestMessage";
	public static String attachmentPath="D://selenium_automation//workspace//InticeFusionAutomationTest//screenshots//2016_28_1_14_10_17.jpeg";
	public static String attachmentName="Error.jpeg";
	public static String reportPath = System.getProperty("user.dir")+"//Reports.zip";
		
	
	//SQL DATABASE DETAILS	
	public static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
	//public static String dbConnectionUrl="tcp:yplwtvuee3.database.windows.net,1433; DatabaseName=MrFusionTest"; 
	public static String dbConnectionUrl="jdbc:sqlserver://yplwtvuee3.database.windows.net:1433; DatabaseName=MrFusionTest";
	public static String dbUserName="MrFusion@yplwtvuee3"; 
	public static String dbPassword="C0nvene!)"; 
	
	
	//MYSQL DATABASE DETAILS
	public static String mysqldriver="com.mysql.jdbc.Driver";
	public static String mysqluserName = "root";
	public static String mysqlpassword = "selenium";
	public static String mysqlurl = "jdbc:mysql://localhost:3306/19thdec";

}
