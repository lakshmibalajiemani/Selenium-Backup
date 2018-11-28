package Selenium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IRCTC {

	static WebDriver driver;

	@BeforeClass

	public static void setUpBeforeClass() throws Exception {
		System.out.println("***************************");
		System.out.println("***************************");
		System.out.println("Befor class");

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\system-45\\Desktop\\New folder\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.irctc.co.in/nget/train-search");// main(tab0)
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}

	@AfterClass
	public static void ac() throws InterruptedException {
		System.out.println("***************************");
		System.out.println("***************************");
		System.out.println("after class");
		Thread.sleep(5000);
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {

		String homepageTitle = "IRCTC Next Generation eTicketing System";
		System.out.println(driver.getTitle());
		System.out.println("***************************");
		System.out.println("***************************");
		
		
		driver.findElement(By.xpath("//span[@class='allcircle circleight']")).click();// charter
																						// train(tab1)
		driver.findElement(By.xpath("//*[@class='allcircle circleone']")).click();// flights(tab2)
		driver.findElement(By.xpath("//*[@class='allcircle circletwo']")).click();// stay(tab3)
		driver.findElement(By.xpath("//span[@class='allcircle circlefive']")).click();// holiday
																						// packages(tab6)
		driver.findElement(By.xpath("//*[@class='allcircle circlethree']")).click();// cab(tab4)
		driver.findElement(By.xpath("//*[@class='allcircle circlefour']")).click();// e-catering(tab5)

		driver.findElement(By.xpath("//*[@class='allcircle circlesix']")).click();// hill
																					// railways(tab7)
		System.out.println("***************************");
		System.out.println("***************************");
		/// window handling initialization
		Set<String> allWindow = driver.getWindowHandles();
		System.out.println(allWindow);
		ArrayList<String> tabs = new ArrayList<>(allWindow);
		driver.switchTo().window(tabs.get(7));
		System.out.println("***************************");
		System.out.println("***************************");
		System.out.println(driver.getTitle());
		System.out.println(driver.getWindowHandle());
		driver.findElement(By.xpath("//*[text()='Payment Tariff']")).click();
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(tabs.get(1));
		System.out.println("***************************");
		System.out.println("***************************");
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("/html/body/app-root/homefooter/footer/div[2]/div[1]/ul/li[1]/a/i")).click();
		System.out.println("***************************");
		System.out.println(driver.getWindowHandle());
		driver.close();
		driver.switchTo().window(tabs.get(3));
		System.out.println("***************************");
		System.out.println("***************************");
		System.out.println(driver.getTitle());
		System.out.println("***************************");
		System.out.println(driver.getWindowHandle());
		driver.close();
		driver.switchTo().window(tabs.get(2));
		System.out.println("***************************");
		System.out.println("***************************");
		System.out.println(driver.getTitle());

		driver.findElement(By.xpath("//*[@id=\"app\"]/div/section[2]/div[2]/input")).sendKeys("12654422335");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/section[2]/div[2]/button")).click();
		System.out.println("***************************");
		System.out.println(driver.getWindowHandle());
		driver.close();
		driver.switchTo().window(tabs.get(4));
		System.out.println("***************************");
		System.out.println("***************************");
		System.out.println(driver.getTitle());
		System.out.println("***************************");
		System.out.println(driver.getWindowHandle());
		driver.close();

		driver.switchTo().window(tabs.get(5));
		System.out.println("***************************");
		System.out.println("***************************");
		System.out.println(driver.getTitle());
		System.out.println("***************************");
		System.out.println(driver.getWindowHandle());
		driver.close();

		driver.switchTo().window(tabs.get(6));
		System.out.println("***************************");
		System.out.println("***************************");
		System.out.println(driver.getTitle());
		System.out.println("***************************");
		System.out.println(driver.getWindowHandle());
		driver.close();
		driver.switchTo().window(tabs.get(0));
		System.out.println("***************************");
		System.out.println("***************************");
		System.out.println(driver.getTitle());
		System.out.println("***************************");
		System.out.println(driver.getWindowHandle());
		
	}
	
/*@Test
public void test1() throws InterruptedException{
	
	driver.findElement(By.xpath("//span[@class='allcircle circleight']")).click();
	Thread.sleep(3000);
    Set<String>allwindows= driver.getWindowHandles();
	ArrayList<String> tabs = new ArrayList<>(allwindows);
	driver.switchTo().window(tabs.get(1));
	driver.findElement(By.xpath("//*[text()='Payment Tariff']")).click();
	Thread.sleep(3000);
	
	Set<String>allwindows1= driver.getWindowHandles();
	for(String st:allwindows1){
	driver.switchTo().window(st);
	System.out.println(st);
	System.out.println(driver.getTitle());
	
	driver.close();
	}*/
}




