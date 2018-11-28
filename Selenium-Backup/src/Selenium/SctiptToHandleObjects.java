package Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SctiptToHandleObjects {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\selinumLibs-2\\browserdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("http://toolsqa.com/automation-practice-form/");
		
		WebElement firstnamefield = driver.findElement(By.name("firstname"));
		firstnamefield.sendKeys("selenium");
		firstnamefield.clear();
		firstnamefield.sendKeys("test");
		
		driver.findElement(By.name("lastname")).sendKeys("script");
		Thread.sleep(2000);
		driver.findElement(By.id("sex-0")).click();
		
		WebElement checkbox = driver.findElement(By.id("profession-0"));
		if(!checkbox.isSelected()) {
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
		
		
		driver.close();

	}

}
