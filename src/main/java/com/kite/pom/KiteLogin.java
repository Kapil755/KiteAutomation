 package com.kite.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLogin {
	
	@FindBy(xpath="//input[@id='userid']") private WebElement userId;
	
	@FindBy(xpath="//input[@id='password']") private WebElement pwd;
	
	@FindBy(xpath="//button[@type='submit']") private WebElement loginButton;
	
	@FindBy(xpath="//span[contains(text(),'Password')]") private WebElement pwdErrorMsg;
	
	@FindBy(xpath="//span[contains(text(),'User ID')]") private WebElement userIdErrorMsg;
	
	
	public KiteLogin(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setKiteUserId(String Uid)
	{
		userId.sendKeys(Uid);
	}
	
	public void setKitePassword(String password)
	{
		pwd.sendKeys(password);
	}

	public void clickKiteLoginButton()
	{
		loginButton.click();
	}
	
	public String getKiteUserIdErrorMessage()
	{
		String error = userIdErrorMsg.getText();
		return error;
	}
	
	public String getKitePasswordErrorMessage()
	{
		String error = pwdErrorMsg.getText();
		return error;
	}
}
