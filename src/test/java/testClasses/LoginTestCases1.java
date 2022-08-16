package testClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.kite.pom.KiteLogin;

public class LoginTestCases1 {
	
	WebDriver driver;
	KiteLogin kl;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeClass
	public void openBrowser()
	{
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReport.html");
		extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
		
		System.setProperty("webdriver.edge.driver", "C:\\Users\\kapil\\Downloads\\edgedriver_win32\\msedgedriver.exe");
		
		driver = new EdgeDriver();
		
		driver.get("https://kite.zerodha.com");
		
		kl = new KiteLogin(driver);
		
	}
	
	@BeforeMethod
	public void waiting() throws InterruptedException
	{
		driver.navigate().refresh();
		test = extent.createTest("MyFirstTest", "Sample description");
	}
	
	@Test
	public void TC01()
	{
		kl.setKitePassword("123465");
		kl.clickKiteLoginButton();
		String msg = kl.getKiteUserIdErrorMessage();
		Assert.assertEquals(msg, "User ID should be minimum 6 characters.");
		test.pass("Test case passed");
	}
	
	@Test
	public void TC02()
	{
		kl.setKiteUserId("abcdrdf");
		kl.clickKiteLoginButton();
		String msg = kl.getKitePasswordErrorMessage();
		Assert.assertEquals(msg, "Password should be minimum 6 characters.");
		//test.fail("Failed test case");
	}
	
	@Test
	public void TC03()
	{
		kl.clickKiteLoginButton();
		String msg = kl.getKiteUserIdErrorMessage();
		Assert.assertEquals(msg, "User ID should be minimum 6 characters.");
		
		String msg1 = kl.getKitePasswordErrorMessage();
		Assert.assertEquals(msg1, "Password should be minimum 6 characters.");
		test.pass("Test case passed");
	}
	@AfterMethod
	public void waiting1() throws InterruptedException
	{
		driver.navigate().refresh();
		
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
		extent.flush();
	}


}
