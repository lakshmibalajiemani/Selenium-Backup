package Selenium;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.testng.annotations.Test;

public class apsrtc {
	 static WebDriver driver;
	@BeforeClass
	public static void startDriver() throws BiffException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\system-45\\Desktop\\New folder\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.apsrtconline.in/oprs-web/");
	}

	/*@BeforeMethod
	public void cleardata() {
		driver.findElement(By.xpath("//*[@name='loginName']")).clear();
		driver.findElement(By.xpath("//*[@name='fullName']")).clear();
		driver.findElement(By.xpath("//*[@name='email']")).clear();
		driver.findElement(By.xpath("//*[@name='mobileNo']")).clear();
		
	}*/
	@AfterClass
	public static void closedriver() {
		driver.close();
	}
	@DataProvider
	public Map[] readData() throws BiffException, IOException {
		FileInputStream fs = new FileInputStream("C:\\Users\\system-45\\Downloads\\TES DATA FOR USER12.xls");
		Workbook wb = Workbook.getWorkbook(fs);

		Sheet sh1 = wb.getSheet("Sample");

		int rows = sh1.getRows();
		int cols = sh1.getColumns();
		Map[] data = new Map[rows - 1];
		for (int row = 1; row < rows; row++) {
			HashMap<String, String> map = new HashMap<String, String>();
			for (int col = 0; col < cols; col++) {
				String key = sh1.getCell(col, 0).getContents();
				String value = sh1.getCell(col, row).getContents();
				map.put(key, value);
			}
			data[row - 1] = map;
		}
		wb.close();
		fs.close();
		System.out.println("**********************************");
		System.out.println(data);
		System.out.println("**********************************");
		return data;
	}
	@Test(dataProvider = "readData")
	public void apsrtc1(Map<String, String> data) {
		System.out.println("trying login using data: " + data);
		driver.findElement(By.xpath("//*[text()='Wallet']")).click();
		driver.findElement(By.xpath("//*[text()='SignUp']")).click();
		String lname = data.get("LoginName");
		String fname = data.get("FullName");
		String email = data.get("e-Mail");
		String mnum = data.get("MobileNumber");
		driver.findElement(By.xpath("//*[@name='loginName']")).sendKeys(lname);
		driver.findElement(By.xpath("//*[@name='fullName']")).sendKeys(fname);
		driver.findElement(By.xpath("//*[@name='email']")).sendKeys(email);
		driver.findElement(By.xpath("//*[@name='mobileNo']")).sendKeys(mnum);
		driver.findElement(By.xpath("//*[@name='SaveBtn']")).click();
		
		
		
}
}