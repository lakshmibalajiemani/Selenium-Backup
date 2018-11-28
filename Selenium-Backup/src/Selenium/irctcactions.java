package Selenium;

import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class irctcactions {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Balaji\\Desktop\\Selenium drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"origin\"]/span/input")).sendKeys("SECUNDRABAD JN");;//from station
		driver.findElement(By.xpath("//*[@id=\"destination\"]/span/input")).sendKeys("TENALI JN");//to station
		driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-main-page/div[2]/div/div[1]/div/div/div[1]/div/app-jp-input/div[3]/form/div[3]/p-calendar/span/input")).sendKeys("11-11-2018");//date
		Thread.sleep(3000);
		 Actions act = new Actions(driver);
		 act.pause(2000);
		 
		WebElement checkbox=driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-main-page/div[2]/div/div[1]/div/div/div[1]/div/app-jp-input/div[3]/form/div[6]/div/label"));
		if (!checkbox.isSelected())
		{
			checkbox.click();
		}
		driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-main-page/div[2]/div/div[1]/div/div/div[1]/div/app-jp-input/div[3]/form/div[7]/button"));//find trains button
	}

}
