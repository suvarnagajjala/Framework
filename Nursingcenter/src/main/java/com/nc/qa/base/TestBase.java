package com.nc.qa.base;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;



public class TestBase{
	public static Properties prop;
	public  static WebDriver driver;
	
	public TestBase() throws Exception
	{
		prop=new Properties();
		FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\nc\\qa\\config\\config.properties");
		prop.load(ip);
		
	}
	/*
	 * @Parameters("browser")
	 * 
	 * @BeforeClass
	 * 
	 * public void initialization(String browser) {
	 * 
	 * 
	 * 
	 * 
	 * if(browser.equals("chrome")) {
	 * System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
	 * driver=new ChromeDriver(); } else if(browser.equals("firefox")) {
	 * System.setProperty("webdriver.gecko.driver","E:\\geckodriver.exe");
	 * driver=new FirefoxDriver(); } String URL=prop.getProperty("url");
	 * driver.get(URL); }
	 */


	  
		 /* String browsername=prop.getProperty("browser"); 
		  if(browsername.equals("chrome")) 
		  {
	  System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
	  driver=new ChromeDriver(); 
	  } 
	else if(browsername.equals("ff")) 
	{
	  System.setProperty("webdriver.gecko.driver","E:\\geckodriver.exe");
	  driver=new FirefoxDriver(); 
	  }
	  
	  String URL=prop.getProperty("url"); driver.get(URL); 
	  }*/
	  
	//***************selenium grid***************
		public static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();
	  	 
	    @BeforeTest
	    //Parameter will get browser from testng.xml on which browser test to run
	    @Parameters("browser")
	    public void beforeclass(String browser) throws MalformedURLException{
	 
	        RemoteWebDriver driver = null;
	 
	        if(browser.equals("chrome")){
	            DesiredCapabilities capability = new DesiredCapabilities().chrome();
	            capability.setBrowserName("chrome");
	            capability.setPlatform(Platform.WINDOWS);
	            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
	        }
	        else if(browser.equals("firefox")){
	            DesiredCapabilities capability = new DesiredCapabilities().firefox();
	            capability.setBrowserName("firefox");
	            capability.setPlatform(Platform.WINDOWS);
	            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
	        }
	 
	        //setting webdriver
	        setWebDriver(driver);
	 
	        getDriver().manage().window().maximize();
	        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	    }
	 
	    public WebDriver getDriver() {
	        return dr.get();
	    }
	 
	    public void setWebDriver(RemoteWebDriver driver) {
	        dr.set(driver);
	    }
}
		
		
		
		
		
		
		
		
		
		  


	