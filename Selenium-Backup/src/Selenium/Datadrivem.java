package Selenium;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Datadrivem {
static WebDriver driver;

	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\system-45\\Desktop\\New folder\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	
	
	

		
	driver.findElement(By.xpath("//*[@id='email']")).sendKeys("8886789404");
	driver.findElement(By.xpath("//*[@name='pass']")).sendKeys("balaji@123");
	driver.findElement(By.xpath("royal_login_button")).click();
	}

}
