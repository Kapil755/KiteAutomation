package testClasses;


import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kite.pom.KiteHomePage;
import com.kite.pom.KiteLogin;
import com.kite.pom.KiteLoginPinPage;


import config.URLConfig;
import utility.BaseClass;

public class LoginTestCases2 {
	
	WebDriver driver;
	KiteLogin login1;
	KiteLoginPinPage login2;
	KiteHomePage home;
	
	@BeforeClass
	public void openBrowser()
	{
		driver = BaseClass.initBrowser();
		driver.get(URLConfig.loginpageUPL);
		
		login1 = new KiteLogin(driver);
		login2 = new KiteLoginPinPage(driver);
		home = new KiteHomePage(driver);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void loginToBrowser() throws IOException, InterruptedException
	{
		login1.setKiteUserId(BaseClass.readPropertyFileData("KiteLoginId"));
		login1.setKitePassword(BaseClass.readPropertyFileData("KitePassword"));
		login1.clickKiteLoginButton();
	}
	
	@Test
	public void verifyUser() throws IOException, InterruptedException
	{
		Thread.sleep(2000);
		login2.setPin(BaseClass.readPropertyFileData("KitePin"));
		
		login2.clickCountinueButton();
		
		Thread.sleep(2000);
		
		String user = home.getHomeUser();
		
		String actUser = BaseClass.readPropertyFileData("KiteLoginId");
		
		Assert.assertEquals(user, actUser);
	}
	
	@AfterMethod
	public void logoutApplication()
	{
		home.clickHomeUser();
		home.clickLogout();
	}
	
	@AfterClass
	public void TC01() throws IOException
	{
		driver.close();
	}
	
	
}
