package Selenium;


import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class ItemPOS {
	public static WebDriver driver;

	@Test(dataProvider = "sample")
	public void loginwithInvalidCred(Map<String, String> data) throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(data.get("Itemname"));
		driver.findElement(By.xpath("//*[@id=\"category\"]")).sendKeys(data.get("Category"));
		driver.findElement(By.xpath("//*[@id=\"cost_price\"]")).sendKeys(data.get("CostPrice"));
		driver.findElement(By.xpath("//*[@id=\"unit_price\"]")).sendKeys(data.get("SellingPrice"));
		driver.findElement(By.xpath("//*[@id=\"submitf\"]")).click();
		Thread.sleep(2000);
		
	}


	@DataProvider(name="sample")
	public Map[] readData() throws BiffException, IOException {
		FileInputStream fs = new FileInputStream("C:\\Users\\system-45\\Desktop\\New folder\\TES DATA FOR USER12.xls");
		Workbook wb = Workbook.getWorkbook(fs);

		Sheet sh1 = wb.getSheet("SAMPLE");

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

	};

	@BeforeClass
	public static void bc1() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\system-45\\Desktop\\New folder\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://192.168.1.168/pos/");
		driver.findElement(By.xpath("//*[@id=\'username\']")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\'password\']")).sendKeys("admin@123");
		driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("html/body/div[2]/div[4]/div[4]/div/div/div/a")).click();
	}
	@BeforeMethod
	public static void bc() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"name\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"category\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"cost_price\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"unit_price\"]")).clear();
		Thread.sleep(2000);
	}
	@AfterClass
	public static void ac() {
		driver.close();
	}

}
