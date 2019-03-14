package Selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class NewTest {
	static WebDriver driver;
	@Test
	public void f() {
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
  public void afterMethod() throws IOException {
	  
	  File src= ((TakesScreenshot)driver). getScreenshotAs(OutputType. FILE); 
	  FileUtils. copyFile(src, new File("C:\\Users\\Balaji\\Downloads"+".png"));
	  
	  
	  }  

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Balaji\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.mizzenandmain.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void afterClass() {
	}

}
