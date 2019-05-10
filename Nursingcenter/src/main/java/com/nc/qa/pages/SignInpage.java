package com.nc.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.nc.qa.base.TestBase;

public class SignInpage extends TestBase{
	@FindBy(xpath="//nav[@class='navigation-menu']/following-sibling::a")
	WebElement signin;
	@FindBy(id="p_lt_zonePageLeftPlaceholder_SmartLoginCtrl_txtInputEmailAddress")
	WebElement username;
	@FindBy(id="p_lt_zonePageLeftPlaceholder_SmartLoginCtrl_txtInputPassword")
	WebElement password;
	@FindBy(id="p_lt_zonePageLeftPlaceholder_SmartLoginCtrl_btnLogin")
	WebElement Continue;

public SignInpage() throws Exception
	{
		
	}
//Actions or methods
public void clickonsign()
{
	signin.click();
}
public void signin(String Uname, String Pwd) throws Exception{
	Thread.sleep(5000);
	username.sendKeys(Uname);
	password.sendKeys(Pwd);
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView();", Continue);
	js.executeScript("arguments[0].click();",Continue);
}
public String validateLoginPageTitle(){
	return driver.getTitle();
}
public void validatewelecometext()
{
	
}




}
