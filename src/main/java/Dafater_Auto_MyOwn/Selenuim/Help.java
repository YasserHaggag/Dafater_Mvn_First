package Dafater_Auto_MyOwn.Selenuim;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Hello world!
 *
 */
public class Help
{
	public static WebDriver Driver;
    public static void ChromeDriver()
    {
    	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe" );
        Driver=new ChromeDriver();
    }
    public static void FireFoxDriver()
    {
    	System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe" );
        Driver=new FirefoxDriver();
    }
    public static void InternetExplorer()
    {
    	System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\Drivers\\IEDriverServer.exe" );
        Driver=new InternetExplorerDriver();
    }
    public static void HeadlessChrome() 
    {
    	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe" );
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--headless");
    	options.addArguments("--window-size=1920,1080");
    	Driver= new ChromeDriver(options);
    }
    public static void CaptureScreenShot(String ScreenshotName) 
    {
    	
    	Path dest= Paths.get("./ScreenShot",ScreenshotName+".PNG");
    	try {
			Files.createDirectories(dest.getParent());
			FileOutputStream out= new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot)Driver).getScreenshotAs(OutputType.BYTES));
			out.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to get ScreenShot" + e.getMessage());
		}
    	
    }
}
