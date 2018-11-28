package Selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StartBrowser {
	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\selinumLibs-2\\browserdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.seleniumhq.org/");
		
		driver.close();

	}

}
