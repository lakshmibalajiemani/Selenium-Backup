package Selenium;
import static org.junit.Assert.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windohandling {
	static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Befor class");
		System.setProperty("webdriver.chrome.driver", "C:\\selinumLibs-2\\browserdrivers\\chromedriver.exe");
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
		// System.out.println("Befor click: " + driver.getWindowHandles());
		driver.findElement(By.xpath("//*[text()='STAY']")).click();
		System.out.println(driver.getTitle());
		// System.out.println("After click: " + driver.getWindowHandles());
		System.out.println(driver.getWindowHandle());
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
			if(hotelspageTitle.equals(driver.getTitle())) {
				break;
			}
		}
		System.out.println("***************************");
		System.out.println(driver.getTitle());
		System.out.println(driver.getWindowHandle());
		Thread.sleep(2000);
	}

}
