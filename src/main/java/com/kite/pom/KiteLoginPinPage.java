package com.kite.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLoginPinPage {
	
	@FindBy(xpath="//input[@type='password']") private WebElement pin;
	
	@FindBy(xpath="//button[@type='submit']") private WebElement contButton;
	
	@FindBy(xpath="//a[contains(text(),'Forgot')]") private WebElement forgotToFA;
	
	public KiteLoginPinPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void setPin(String pinno)
	{
		pin.sendKeys(pinno);
	}
	
	public void clickCountinueButton()
	{
		contButton.click();
	}
	
	public void clickOnforgotToFA()
	{
		forgotToFA.click();
	}
}
