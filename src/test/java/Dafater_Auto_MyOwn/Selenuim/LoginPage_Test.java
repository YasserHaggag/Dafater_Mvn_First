package Dafater_Auto_MyOwn.Selenuim;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginPage_Test extends BaseTest{
	@DataProvider(name="TestData")
	public static Object [][] Login_Data()
			{
			return new Object[][] 
					{
				{"administrator","admin"},
				{"yasser.haggag@businessclouds.biz","Admin@123"}
				};
		
			}
	
	@Test
	public void Login_With_Valid_Data() 
	{
		
		LoginPage.Login("administrator", "admin");
		//Help.CaptureScreenShot("Login_With_Valid_Data");
		Assert.assertEquals(Mainpage.Dashboard_Tab.getText(), "Dasboard");
		//Assert.assertEquals(Mainpage.Dashboard_Tab.isDisplayed());
	}

}
