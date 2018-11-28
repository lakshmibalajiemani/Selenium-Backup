package Selenium;

import java.util.ArrayList;
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
	public static void bc() throws InterruptedException 
	{
		System.out.println("Befor class");

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\system-45\\Desktop\\New folder\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.irctc.co.in/nget/train-search");// main(tab0)
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	
@AfterClass
public static void ac()
{
	System.out.println("after class");
	driver.quit();
}
@Test
public void test()
{
	System.out.println("Test");
	driver.findElement(By.xpath("//span[@class='allcircle circleight']")).click();
	
	driver.findElement(By.xpath("//*[@class='allcircle circleone']")).click();
	driver.findElement(By.xpath("//*[@class='allcircle circletwo']")).click();
	driver.findElement(By.xpath("//span[@class='allcircle circlefive']")).click();

	driver.findElement(By.xpath("//*[@class='allcircle circlethree']")).click();
	driver.findElement(By.xpath("//*[@class='allcircle circlefour']")).click();

	driver.findElement(By.xpath("//*[@class='allcircle circlesix']")).click();//1
	Set<String>allwindows=driver.getWindowHandles();
	ArrayList<String> tabs= new ArrayList<>(allwindows);
	driver.switchTo().window(tabs.get(1));
	System.out.println(driver.getTitle());
	driver.switchTo().window(tabs.get(2));
	System.out.println(driver.getTitle());
	driver.switchTo().window(tabs.get(3));
	System.out.println(driver.getTitle());
	driver.switchTo().window(tabs.get(4));
	System.out.println(driver.getTitle());
	driver.switchTo().window(tabs.get(5));
	System.out.println(driver.getTitle());
	driver.switchTo().window(tabs.get(6));
	System.out.println(driver.getTitle());
	driver.switchTo().window(tabs.get(7));
	System.out.println(driver.getTitle());
	
	
}
}
