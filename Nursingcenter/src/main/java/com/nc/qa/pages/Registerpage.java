package com.nc.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.nc.qa.base.TestBase;


public class Registerpage extends TestBase{

	
	/*public Registerpage() throws Exception {
		
		PageFactory.initElements(driver,Registerpage.class);
	}*/
	
	
	//pagefactory
	@FindBy(xpath="//nav[@class='navigation-menu']/following-sibling::a")
	WebElement signin;
	@FindBy(id="p_lt_zonePagePlaceholder_SmartRegistrationCtrl_txtInputEmailAddress")
	public WebElement email;
	@FindBy(id="p_lt_zonePagePlaceholder_SmartRegistrationCtrl_txtInputPassword")
	public WebElement password;
	@FindBy(id="p_lt_zonePagePlaceholder_SmartRegistrationCtrl_txtInputName")
	public WebElement fullname;
	@FindBy(xpath="//div[text()='What is your Practice Area?']")
	public WebElement practicearea;
	@FindBy(xpath="//div[text()='What is your Nurse Role?']")
	public WebElement Nursingrole;
	//@FindBy(id="chkprv")
	//WebElement termsandconditions;
	//@FindBy(xpath="//div[@class='menu transition visible']/div")
//	@FindBy(xpath="//div[@class='ui fluid dropdown nc-form__input nc-form__select nc-form__select__practice selection multiple']")
	//List<WebElement> dd_options;
	//@FindBy(xpath="//i[@class='dropdown icon'][1]")
	//WebElement dropicon;
	//@FindBy(xpath="//div[text()='Max 3 selections']")
	//String max3selections;
	@FindBy(xpath="//div[text()='What is your Nurse Role?']")
	WebElement nursingrole;
	@FindBy(id="p_lt_zonePagePlaceholder_SmartRegistrationCtrl_btnRegister")
	WebElement done;
	//@FindBy(xpath="//select[@id='p_lt_zonePagePlaceholder_SmartRegistrationCtrl_ddlNurseRole']/option")
	//WebElement nursingdd;
	//@FindBy(xpath="//div[@class='nc-form__help-register nc-form__input-status--success']/div[3]")
	//@FindBy(css="input.chkprv")
	//WebElement checkbox;
	
	
	public Registerpage() throws Exception {
		
	}
	public void clickonsign()
	{
		signin.click();
	}
	
	public void setemail()
	{
		email.clear();
		email.sendKeys("suvarna.cnsr@gmail.com");
	}
	public void setpassword()
	{
		password.sendKeys("Connect123#");
	}
	public void setfullname()
	{
		fullname.sendKeys("Suvarna redddy");
	}
	public void selectpracticearea() throws Exception
	{
		
		/*for(int i=0;i<dd_options.size();i++)
		{
			
			System.out.println(dd_options.get(i).getText());
			dropicon.click();
			System.out.println(dd_options.size());*/
		driver.findElement(By.xpath("//i[@class='dropdown icon'][1]")).click();
		Thread.sleep(5000);
		List<WebElement> getOption = driver.findElements(By.xpath("//div[@class='menu transition visible']/div"));
			for(WebElement ele : getOption)
			{
				if(ele.getText().contains("Administration"))
					ele.click();
				else if(ele.getText().contains("Ambulatory Care"))
					ele.click();
				else if(ele.getText().contains("Addiction"))
					ele.click();
				}
	}
			//public String verifyregpagetitle()
			//{
			//	return driver.getTitle();
			//}
			public void verifyPAmaxselection()
			{
				//String patext=driver.findElement(By.xpath("//div[text()='Max 3 selections']")).getText();
			Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Max 3 selections']")).getText().equals("Max 3 selections"));
			System.out.println("assert is exceuted succesfully");
			

}
public void setnursingrole() throws Exception
{
	driver.manage().window().maximize();
	/*System.out.println("hi");
	System.out.println(nursingrole.getText());
	nursingrole.click();
	//Thread.sleep(3000);
	//driver.findElement(By.xpath("//i[@class='dropdown icon'][2]")).click();
	Thread.sleep(5000);
	List<WebElement> getOptions = driver.findElements(By.xpath("//div[@class='menu transition hidden']/div"));
	for(WebElement ele : getOptions)
		{
			System.out.println(ele.getText());
			while(ele.isEnabled())
			{
				System.out.println(ele.getText());
			if(ele.getText().contains("Advanced practice-clinical nurse specialist"))
				System.out.println("hello");
				ele.click();
			//else if(ele.getText().contains("Ambulatory Care"))
				//ele.click();
			//else if(ele.getText().contains("Addiction"))
				//ele.click();*/
	nursingrole.click();
	System.out.println(nursingrole.getText());
	Thread.sleep(5000);
		/*
		 * List<WebElement>
		 e=driver.findElements(By.xpath("//div[@class='menu transition visible']/div")
		 * ); //Select s=new Select(e);
		 * //s.selectByVisibleText("Advanced practice-clinical nurse specialist");
		 * for(WebElement ele:e) { System.out.println("hi");
		 * if(ele.getText().contains("Advanced practice-clinical nurse specialist"))
		 * System.out.println("hello"); ele.click();
		 * 
		 * }
		 */
	String s = "Advanced practice-nurse anesthetist";
	driver.findElement(By.xpath("//div[@class='menu transition visible']/div[text()='"+s+"']")).click();
	}
public void checkbox() throws Exception
{
	System.out.println("hello");
Actions a =new Actions(driver);
	
	for(int i=1;i<=10;i++)
	{
		a.sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(1000);
	}
	/*if(driver.findElement(By.xpath("//*[@id=\"p_lt_zonePagePlaceholder_SmartRegistrationCtrl_chkENewsOptin\"]")).isEnabled());

	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	a.click(driver.findElement(By.xpath("//*[@id=\"p_lt_zonePagePlaceholder_SmartRegistrationCtrl_chkENewsOptin\"]")));
}*/
	
	List<WebElement> allCheckbox = driver.findElements(By.xpath("//input[@type='checkbox']"));

		//for (int i=0;i==allCheckbox.size();i++) {
			for(WebElement ele:allCheckbox) {
		    if (!ele.isSelected()) {
		        ele.click();
		        System.out.println("element is clicked");
		    
		    }
		    
		}
		
	
}	
	
	
	
	
	
	
	
	
	//List<WebElement> checkboxes=driver.findElements(By.xpath("//*[@id=\"p_lt_zonePagePlaceholder_SmartRegistrationCtrl_chkENewsOptin\"]"))
	
public void done()
{
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();",done);
	done.click();
}


}





