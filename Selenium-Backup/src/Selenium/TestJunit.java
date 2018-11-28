package Selenium;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestJunit {
	static WebDriver driver;

	@BeforeClass
	public static void setUP() {
		System.out.println("Befor class");
		System.setProperty("webdriver.chrome.driver", "C:\\selinumLibs-2\\browserdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void tearDown() {
		System.out.println("After class");
		driver.close();
	}
	
	@Before
	public void before() {
		System.out.println("before");
	}
	
	@After
	public void after() {
		System.out.println("After");
	}

	@Test
	public void test() {
		System.out.println("test");
		driver.get("http://toolsqa.com/handling-alerts-using-selenium-webdriver/");

		driver.findElement(By.xpath("//button[text()='Simple Alert']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.alertIsPresent());

		Alert a = driver.switchTo().alert();
		System.out.println(a.getText());
		a.accept();
	}

	@Test
	public void test1() throws InterruptedException {
		System.out.println("test1");
		driver.get("http://toolsqa.com/automation-practice-form/");

		WebElement firstnamefield = driver.findElement(By.name("firstname"));
		firstnamefield.sendKeys("selenium");
		firstnamefield.clear();
		firstnamefield.sendKeys("test");

		driver.findElement(By.name("lastname1")).sendKeys("script");
		Thread.sleep(2000);
		driver.findElement(By.id("sex-0")).click();

		WebElement checkbox = driver.findElement(By.id("profession-0"));
		if (!checkbox.isSelected()) {
			checkbox.click();
		}
		Thread.sleep(2000);
		Select ss = new Select(driver.findElement(By.id("continents")));
		ss.selectByVisibleText("Australia");
		Thread.sleep(2000);
		Select sc = new Select(driver.findElement(By.id("selenium_commands")));
		sc.selectByIndex(3);
		sc.selectByIndex(1);
		Thread.sleep(2000);
		sc.deselectAll();
		Thread.sleep(2000);

	}

}
