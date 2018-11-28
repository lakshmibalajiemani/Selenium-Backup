package Selenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Sample {
	static WebDriver driver;
	@BeforeClass
	
		public static void setUpBeforeClass() throws Exception {
			System.out.println("Befor class");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Balaji\\Desktop\\Selenium drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@AfterClass
	public static void ac() throws InterruptedException
	{
		System.out.println("after class");
		Thread.sleep(5000);
		driver.quit();
	}
	@Test
		public  void test() throws InterruptedException {
	
		String homepageTitle = "IRCTC Next Generation eTicketing System";
		driver.get("https://www.irctc.co.in/nget/train-search");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='allcircle circleight']")).click();//charter train
		Thread.sleep(2000);
		
		
		Set<String> allWindow=driver.getWindowHandles();
		Iterator<String> itr=allWindow.iterator();
		String main=itr.next();
		String charter=itr.next();
		driver.switchTo().window(charter);
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//*[text()='Payment Tariff']")).click();
		Thread.sleep(2000);
		driver.close();
		driver.quit();
		driver.get("https://www.ftr.irctc.co.in/ftr/MiscLinksServlet?link=paymentTariff");
		System.out.println(driver.getTitle());
		
		
		
		
		
		 
	        	}
	}
	

