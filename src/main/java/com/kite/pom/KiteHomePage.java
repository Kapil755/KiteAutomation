package com.kite.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteHomePage {
	
	@FindBy(xpath="//span[@class='user-id']") private WebElement homeUser;
	
	@FindBy(xpath="//span[@class='user-id']") private WebElement gethomeUser;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]") private WebElement logout;
	
	public KiteHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickHomeUser()
	{
		homeUser.click();
	}
	
	public void clickLogout()
	{
		logout.click();
	}
	
	public String getHomeUser()
	{
		return gethomeUser.getText();
	}

}
