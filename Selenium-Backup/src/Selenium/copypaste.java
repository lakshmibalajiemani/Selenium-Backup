package Selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class copypaste {
	static WebDriver driver;
  @Test
  public void f() {
  }
  

 /* @AfterMethod
  public void afterMethod() throws IOException, InterruptedException {
	  File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File dest = new File("D:\\balaji Screenshots\\test_" + timestamp() + ".png");
		//FileUtils.copyFile(scr,dest);
		FileUtils.copyFile(scr,dest);
		Thread.sleep(3000);
  }*/

	public String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
  

  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\system-45\\Desktop\\New folder\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		
  }
  @Test
  public void copy()
  {
	  WebElement search = driver.findElement(By.xpath("//*[@id=\"lst-ib\"]"));
	  search.clear();
	  
	  search.sendKeys("how to do copy  paste in selenium web driver");
	  search.sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.chord(Keys.CONTROL,"c"));


	  JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.open()");
		
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("https://www.google.com/");
		 WebElement search1 = driver.findElement(By.xpath("//*[@id=\"lst-ib\"]"));
		 search1.clear();
		
		 Actions action1= new Actions(driver);
		 /*action1.contextClick(search1).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();*/  
		 
		 //action1.contextClick(driver.findElement(By.xpath("//*[@id=\"lst-ib\"]")));
		 search1.sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.chord(Keys.CONTROL,"v"));
		 search1.sendKeys(Keys.ENTER);
		 search1.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB);
  }
}