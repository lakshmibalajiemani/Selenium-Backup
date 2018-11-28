package Selenium;


import java.io.FileInputStream;
import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.read.biff.BiffException;

import org.testng.annotations.Test;

public class seleniumhighq {
	 static WebDriver driver;
	@BeforeClass
	public static void startDriver() throws BiffException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\system-45\\Desktop\\New folder\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.seleniumhq.org/");
		
	}
	@AfterClass
	public static void closedriver() {
		driver.close();
	}
	@Test
	public void seleniumhigh() throws InterruptedException
	{
	driver.findElement(By.xpath("//*[text()='Projects']")).click();
	driver.findElement(By.xpath("//*[@id='q']")).sendKeys("projects");
	driver.findElement(By.xpath("//*[text()='Download']")).click();
	driver.findElement(By.xpath("//*[@id='q']")).sendKeys("downloads");
	driver.navigate().back();
	Thread.sleep(2000);
	WebElement ele = driver.findElement(By.xpath("//*[@id='q']"));
	//System.out.println(ele.getText()); 
	System.out.println(ele.getAttribute("value"));
    driver.navigate().forward();
	Thread.sleep(1000);
	WebElement ele1 = driver.findElement(By.xpath("//*[@id='q']"));
	//System.out.println(ele1.getText()); 
	System.out.println(ele1.getAttribute("value"));
	
}}