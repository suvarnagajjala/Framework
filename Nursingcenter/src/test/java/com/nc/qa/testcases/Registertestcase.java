package com.nc.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nc.qa.base.TestBase;
import com.nc.qa.pages.Registerpage;

public class Registertestcase extends TestBase {

	Registerpage rp;
	
	public Registertestcase() throws Exception {
		super();
		
	}
	@BeforeMethod
public void setup()
{
	initialization("browser");
}
	@Test(priority=1)
	public void reg() throws Exception
	{
		rp=PageFactory.initElements(driver,Registerpage.class);
		rp.clickonsign();
		rp.setemail();
		rp.setpassword();
		rp.setfullname();
		rp.selectpracticearea();
		rp.verifyPAmaxselection();
		rp.setnursingrole();
rp.checkbox();
rp.done();
	}
	//@Test(priority=2)
	//public void verifypmaxtest()
	//{
		//rp.verifyPAmaxselection(Assert.assertTrue(true, "Max 3 selection"));
		//String patext=driver.findElement(By.xpath("//div[text()='Max 3 selections']")).getText();
		//System.out.println(patext);
		//Assert.assertEquals(patext, "Max 3 selection");
		
	}
	

