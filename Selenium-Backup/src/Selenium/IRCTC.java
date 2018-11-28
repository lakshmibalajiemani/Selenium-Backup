package Selenium;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IRCTC {
	static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Befor class");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Balaji\\Desktop\\Selenium drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Thread.sleep(1500);
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
	
		String homepageTitle = "IRCTC Next Generation eTicketing System";
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.findElement(By.xpath("//span[@class='allcircle circleight']")).click();//charter train
		driver.findElement(By.xpath("//*[@class='allcircle circleone']")).click();//flights
		driver.findElement(By.xpath("//*[@class='allcircle circletwo']")).click();//stay
		driver.findElement(By.xpath("//*[@class='allcircle circlethree']")).click();//cab
		driver.findElement(By.xpath("//*[@class='allcircle circlefour']")).click();//e-catering
		driver.findElement(By.xpath("//span[@class='allcircle circlefive']")).click();//holiday packages
		driver.findElement(By.xpath("//*[@class='allcircle circlesix']")).click();//hill railways
		
	
			Set<String> ns=driver.getWindowHandles();
			for(String handle: ns) {
			driver.switchTo().window(handle);
			if(driver.getTitle().equals("IRCTC FTR SERVICE")){
				System.out.println(driver.getTitle());
				driver.findElement(By.xpath("//*[text()='Payment Tariff']")).click(); Thread.sleep(1500);
				break;
				}
		
			
			
			
			for(String handle1: ns) 
			{
				driver.switchTo().window(handle1);
				if(driver.getTitle().equals("Railways Tourism, Retiring Rooms, Holidays Customized Tours, LTC Tours, Maharajas, Mahaparinirvan")){
				System.out.println(driver.getTitle());
				driver.findElement(By.xpath("//*[@class='fa fa-facebook']")).click(); Thread.sleep(1500);
				
				break;
				}
				
				
				for(String handle2: ns)
				{
					driver.switchTo().window(handle2);
					if(driver.getTitle().equals("Book Cabs Nearby at Best Price | Hire Taxi Nearby Online at Olacabs.com")){
					System.out.println(driver.getTitle());
					System.out.println(driver.getTitle());
					Thread.sleep(1500);
					driver.close();
					break;
					}
				for(String handle3: ns) {
					driver.switchTo().window(handle3);
					if(driver.getTitle().equals("Payment Tariff")){
					System.out.println("this is payment Tariff page");
					System.out.println(driver.getTitle());
					Thread.sleep(1500);
					driver.close();
					break;
					}
				
					for(String handle4: ns) {
						driver.switchTo().window(handle4);
						if(driver.getTitle().equals("eCatering IRCTC: Order Food on Train Online, Food and Meal on Train, Tasty Food for Train Journey")){
						System.out.println("ecatering");
						driver.findElement(By.xpath("//*[@id=\"app\"]/div/section[2]/div[2]/input")).sendKeys("11556644879");
						Thread.sleep(2000);
						driver.close();
						break;
						}
						for(String handle5: ns) {
							driver.switchTo().window(handle5);
							if(driver.getTitle().equals("IRCTC Hotels")){
							System.out.println("IRCTC Hotels Page");
							System.out.println(driver.getTitle());
							Thread.sleep(2000);
							driver.close();
							break;
							}
					
				
				
				
				
				
				
				System.out.println(driver.manage().window().getSize());
				
				
				
				
				
				
				
				}
			
		
			}}}}}}}