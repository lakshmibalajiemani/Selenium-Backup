package Selenium;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;

public class Pos {
static WebDriver driver;
			@Test
			public static void main(String[]args) throws InterruptedException {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\W3s\\Downloads\\chromedriver.exe");
				WebDriver driver=new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("http://192.168.1.168/pos/");
				driver.findElement(By.name("username")).sendKeys("admin");
				driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("admin@123");
				driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[3]/div[2]/input")).click();
			}}