package Selenium;


import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Windowshandl {

	static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Befor class");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Balaji\\Desktop\\Selenium drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		String hotelspageTitle = "IRCTC Hotels";
		String homepageTitle = "IRCTC Next Generation eTicketing System";
		driver.get("https://www.irctc.co.in/nget/train-search");
		//flights task
		//System.out.println("**flights task");
		///driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-main-page/div[10]/div/ul/li[1]/a/span")).click();
		
		
		
		driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-main-page/div[10]/div/ul/li[2]/a/span")).click();
		
		for (String handle : driver.getWindowHandles()) {
			 
		    driver.switchTo().window(handle);}
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[3]/div/div/div[1]/div/div[1]/input")).sendKeys("HYDERABAD");
		//Actions a= new Actions(driver);
		//a.sendKeys(Keys.ENTER).click();
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[3]/div/div/div[4]/button/div")).click();
		//Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-main-page/div[10]/div/ul/li[3]/a/span")).click();
		System.out.println(driver.getTitle());
		
		
}
}