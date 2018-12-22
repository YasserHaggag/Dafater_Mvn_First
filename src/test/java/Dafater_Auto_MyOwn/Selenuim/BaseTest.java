package Dafater_Auto_MyOwn.Selenuim;

import java.util.concurrent.TimeUnit;

import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseTest
   
{
	@BeforeSuite
	@Parameters({"browser"})
	public void Initiation(@Optional("chrome") String browserName) 
	{
		
		/*switch (browserName)
		
		{
		case "ie": 
			Help.InternetExplorer();
			break;
		case "firefox":
			Help.FireFoxDriver();
			break;
		case "Headless":
			Help.HeadlessChrome();
		default:
			Help.ChromeDriver();
			break;
		}
		*/
		if (browserName.equalsIgnoreCase("ie")) {Help.InternetExplorer();}
		else if(browserName.equalsIgnoreCase("firefox")) {Help.FireFoxDriver();}
		else if(browserName.equalsIgnoreCase("Headless")) {Help.HeadlessChrome();}
		else {Help.ChromeDriver();}
		
		Help.Driver.navigate().to("https://engineering-test.dafater.biz");
		Help.Driver.manage().window().maximize();
		Help.Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@AfterSuite
	public void TearDown() 
	{
		Help.Driver.quit();
	}
	
	@AfterMethod
	public void ScreenshotOnFailure(ITestResult result) 
	{
		if (result.getStatus() == ITestResult.FAILURE) 
		{
			Help.CaptureScreenShot(result.getName());
		}
		else {System.out.println("Passed");}
	}
	
	


}
