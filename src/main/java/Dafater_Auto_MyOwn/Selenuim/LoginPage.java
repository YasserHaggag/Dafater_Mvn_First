package Dafater_Auto_MyOwn.Selenuim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends Help

{
	public static String URL="https://engineering-test.dafater.biz";
	public static WebElement UserName = Help.Driver.findElement(By.id("login_id"));
	public static WebElement Password = Help.Driver.findElement(By.id("pass"));
	public static WebElement Login_Button = Help.Driver.findElement(By.id("login_btn"));
	
	public static void GoTo() 
	{
		Help.Driver.navigate().to(URL);
	}
	public static void Login(String username,String Pass) 
	{
		
		UserName.sendKeys(username);
		Password.sendKeys(Pass);
		Login_Button.click();
		
	}
	

}
