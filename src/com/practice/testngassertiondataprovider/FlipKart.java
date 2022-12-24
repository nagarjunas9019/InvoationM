package com.practice.testngassertiondataprovider;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FlipKart {

	private static WebDriver driver;
	private String baseUrl;
	private WebElement element;

	@BeforeMethod
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Najarjuna\\Desktop\\Rahul-shetty\\Basava\\TestNG-Automation\\TestNG-Automation\\Library\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		baseUrl = "https://www.flipkart.com/";

	}

	@Test
	public void testUntitled() throws Exception {
		driver.get(baseUrl);
		
        //close the login pop-up
		driver.findElement(By.xpath("//button[@class=\"_2KpZ6l _2doB4z\"]")).click();
		
		//listing all banners and click
		List<WebElement> mobiles = driver.findElements(By.xpath("//div[@class=\"_3eARKq\"]//following-sibling::div"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1200));
		Thread.sleep(1200);
		mobiles.get(3).click();

		//performing mouse over on electronic element
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(700));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=\"Electronics\"]")));
		WebElement electronics = driver.findElement(By.xpath("//span[text()=\"Electronics\"]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(electronics).perform();
		Thread.sleep(100);

		//Storing all mobiles into list
		List<WebElement> mobiles1 = driver.findElements(By.xpath("//a[@class=\"_3QN6WI\"]"));
		Thread.sleep(100);
		System.out.println("Total Mobiles Count :  " + mobiles1.size());

		for (WebElement mobile : mobiles1) {
			System.out.println(mobile.getText());
		}

	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

}
