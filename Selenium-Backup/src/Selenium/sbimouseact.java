package Selenium;


import static org.testng.Assert.assertEquals;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.testng.annotations.Test;

public class sbimouseact {
	 static WebDriver driver;
	@BeforeClass
	public static void startDriver() throws BiffException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\system-45\\Desktop\\New folder\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://retail.onlinesbi.com/retail/login.htm");
		driver.findElement(By.xpath("//*[@class='login_button']")).click();
	}
	@AfterClass
	public static void closedriver() {
		driver.close();
	}
	@Test
	public void sbi()
	{
		Actions action= new Actions(driver);
		action.contextClick(driver.findElement(By.xpath("//*[@id='username']"))).build().perform();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("balajkgkji");
		action.contextClick(driver.findElement(By.xpath("//*[@id='label2']"))).build().perform();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//*[@id='label2']")).sendKeys("balafhjkfkji");
		driver.findElement(By.xpath("//*[@id='Button2']")).click();
		System.out.println(driver.findElement(By.xpath("//*[@class='err_mssg']")).getText());
		
		assertEquals(driver.findElement(By.xpath("//*[@class='err_mssg']")).getText(), "Invalid Username or Password");
		
		
	}}