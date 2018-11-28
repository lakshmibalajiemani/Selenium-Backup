package Selenium;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class multit {
	static WebDriver driver;

	@BeforeClass
	public void bc() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\system-45\\Desktop\\New folder\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://mail.google.com/");
	}

	@Test
	public void f() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.open()");
		jse.executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("https://mail.google.com/");
		driver.switchTo().window(tabs.get(2));
		driver.get("https://stackoverflow.com/questions/45812158/how-do-i-open-a-new-tab-in-chrome-using-the-actions-class");
		driver.switchTo().window(tabs.get(0));
		driver.get("https://www.youtube.com/watch?v=vXUQn2bDobw");

	}
}
