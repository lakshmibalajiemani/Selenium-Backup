package Selenium;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.read.biff.BiffException;

import org.testng.annotations.Test;

public class Dragusingmouse {
	static WebDriver driver;

	@BeforeClass
	public static void startDriver() throws BiffException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\system-45\\Desktop\\New folder\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		

	}
	@BeforeMethod
	public static void site()
	{
		driver.get("https://jqueryui.com/");
	}
	@AfterClass
	public static void closedriver() {
		driver.close();
	}
	@AfterMethod
	public void screenShot() throws IOException, InterruptedException {
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File dest = new File("D:\\balaji Screenshots\\test_" + timestamp() + ".png");
		//FileUtils.copyFile(scr,dest);
		FileUtils.copyFile(scr,dest);
		Thread.sleep(3000);
	}

	public String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

	@Test
	public void draganddrop() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//*[text()='Droppable']")).click();
		driver.switchTo().frame(0);
		Actions actions = new Actions(driver);

		WebElement dragger = driver.findElement(By.xpath("(//*[@class='ui-widget-content ui-draggable ui-draggable-handle'])"));
		Thread.sleep(1500);
		WebElement dropper = driver.findElement(By.xpath("(//*[@class='ui-widget-header ui-droppable'])"));
		Thread.sleep(1500);
		actions.dragAndDrop(dragger, dropper).build().perform();
		Thread.sleep(1500);
		
	}

	@Test
	public static void slide() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//*[text()='Slider']")).click();
		driver.switchTo().frame(0);
		Actions actions = new Actions(driver);
		WebElement dragger = driver
				.findElement(By.xpath("//*[@class='ui-slider-handle ui-corner-all ui-state-default']"));
		actions.dragAndDropBy(dragger, 250, 0).build().perform();
		Thread.sleep(3000);
		
	}

	@Test
	public void resize() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//*[text()='Resizable']")).click();
		driver.switchTo().frame(0);
		Actions action = new Actions(driver);
		WebElement dragger = driver.findElement(
				By.xpath("//*[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));

		action.clickAndHold(dragger).moveByOffset(600, 0).pause(3000).release().build().perform();
		Thread.sleep(3000);
	}

}