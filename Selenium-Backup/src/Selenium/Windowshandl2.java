package Selenium;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windowshandl2 {
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
		driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-main-page/div[10]/div/ul/li[1]/a/span")).click();
		driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-main-page/div[10]/div/ul/li[2]/a/span")).click();
		driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-main-page/div[10]/div/ul/li[3]/a/span")).click();
		
		for (String handle : driver.getWindowHandles()) {
		 driver.switchTo().window(handle);}
		
		if(driver.getTitle().equals("IRCTC Hotels"));{
			System.out.println("page is in hotels page");
			driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[3]/div/div/div[1]/div/div[1]/input")).sendKeys("hyderabad");
			driver.findElement(By.xpath("//*[@class='u-ripple']")).click();}
			
			
			if(driver.getTitle().equals("Book Cabs Nearby at Best Price | Hire Taxi Nearby Online at Olacabs.com"));{
				System.out.println("page is in cabs page");
				driver.findElement(By.xpath("/html/body/ola-app//iron-pages/ola-home//ola-loc-permission//div/div/div[2]/button")).click();
			}
			if(driver.getCurrentUrl().equals("https://www.air.irctc.co.in/"));{
				System.out.println(driver.getTitle());
			}
		}
		
		

}