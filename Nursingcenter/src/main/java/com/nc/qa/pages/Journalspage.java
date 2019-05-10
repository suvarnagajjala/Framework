package com.nc.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.nc.qa.base.TestBase;

public class Journalspage extends TestBase {

   @FindBy(xpath="//a[text()='Journals & Articles']")
	WebElement journalsAndArticles;
//	@FindBy(id="p_lt_zonePageLeftPlaceholder_SmartLoginCtrl_txtInputPassword")
//	WebElement password;
   @FindBy(xpath="//a[text()='Journals']")
   WebElement journals;
   //@FindBy(xpath="//img[@alt='Nursing-(13).png'][@src='/getattachment/Journals-Articles/Journals/Nursing-(13).png.aspx']")
   @FindBy(xpath="//a[text()='Nursing2019'][1]")
   WebElement clickonBook;
   @FindBy(xpath="//a[text()='Got it!']")
   WebElement cookies;
   @FindBy(xpath="//a[@id='p_lt_zonePagePlaceholder_ArticleAndEbookControl_ctl00_ArticleMenu_lnkFileDrawer']")
   WebElement addbookmark;
   @FindBy(xpath="//a[@id='p_lt_zonePagePlaceholder_ArticleAndEbookControl_ctl00_ArticleMenu_lnkFileDrawer']")
   WebElement viewbookmark;
 Actions a=new Actions(driver);

public Journalspage() throws Exception {
		
	}
public void journals() throws InterruptedException
{
	cookies.click();
	driver.manage().window().maximize();
	a.moveToElement(journalsAndArticles).build().perform();
	journals.click();
	Thread.sleep(4000);
	clickonBook.click();
	Thread.sleep(5000);
//List<WebElement> alllist=driver.findElements(By.xpath("//div[@class='col-md-1 col-sm-12 col-xs-12']/span"));

	List<WebElement> alllist=driver.findElements(By.xpath("//div[@class='row articleItem']"));
	//List<WebElement> alllist=driver.findElements(By.xpath("//span[contains(@class,'badge     badge-free')]/following::a"));
	//List<WebElement> alllist=driver.findElements(By.xpath("//div[@class='col-md-1 col-sm-12 col-xs-12']/span/preceding::a"));
	String Url=driver.getCurrentUrl();
	System.out.println(Url);
	/*for(WebElement element:alllist)
	{
		System.out.println(alllist.size());
		
		System.out.println(element.getText());
		Thread.sleep(5000);
		List<WebElement> free=driver.findElements(By.xpath("//div[@class='col-md-1 col-sm-12 col-xs-12']/span"));
		//Thread.sleep(5000);
		for(WebElement ele:free) 
		{
			Thread.sleep(5000);
	if(ele.getText().contains("Free"))
		{
		System.out.println(ele.getText());
			//List<WebElement> free=driver.findElements(By.xpath("//span[contains(@class,'badge     badge-free')]/following::a"));
			
			//for(WebElement ele:free)
			//{
		System.out.println(free.size());
			a.click(element).build().perform();
			Thread.sleep(3000);
			if(addbookmark.isDisplayed())
			{
			addbookmark.click();
			driver.get(Url);
			}
			else {
			Thread.sleep(3000);
			viewbookmark.click();
			
			}
			//Thread.sleep(5000);
			
			
			
		}*/
	
	
		
for(WebElement element:alllist)
{
	System.out.println(alllist.size());
	
	System.out.println(element.getText());
			if(element.getText().contains("Free"))
			{
				System.out.println("hi");
		element.click();
		driver.get(Url);
		System.out.println("hello");
		
				//boolean free=alllist.get(1).getText().contains("Free");
				//String all=alllist.get(i).getTagName().equalsIgnoreCase("Free")
			}
		}
	

}
	//driver.get(Url);

}
