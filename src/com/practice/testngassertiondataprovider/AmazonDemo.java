package com.practice.testngassertiondataprovider;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AmazonDemo {
	
	public static WebDriver driver;;

	@Test(priority=1)
	public static void launchBrowser()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Najarjuna\\Desktop\\Rahul-shetty\\Basava\\TestNG-Automation\\TestNG-Automation\\Library\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority=2)
	public static void navigate()
	{
		try
		{
			driver.get("https://www.flipkart.com/");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class=\"_2KpZ6l _2doB4z\"]")).click();	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority=3)
	public void operationsOnFlipkart() throws Exception
	{
		
		AmazonDemo.clickOnBanner();
		Thread.sleep(100);
		AmazonDemo.mouseOverToElectronics();
		Thread.sleep(100);
		AmazonDemo.printAllMobiles();
		AmazonDemo.tearDown(); 
	}
		
			
	public static void clickOnBanner() throws Exception
	{
		
		List<WebElement> mobiles = driver.findElements(By.xpath("//div[@class=\"_3eARKq\"]//following-sibling::div"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1200));
		Thread.sleep(1200);
		mobiles.get(3).click();
		
	}
	
	
	private static void mouseOverToElectronics() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(700));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=\"Electronics\"]")));
		WebElement electronics = driver.findElement(By.xpath("//span[text()=\"Electronics\"]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(electronics).perform();
					
	}
	private static void printAllMobiles() throws Exception {
		
		Thread.sleep(100);
		List<WebElement> mobiles = driver.findElements(By.xpath("//a[@class=\"_3QN6WI\"]"));
		Thread.sleep(100);
		System.out.println("Total Mobiles Count :  "+mobiles.size());
		
		for(WebElement mobile : mobiles )
		{
			System.out.println(mobile.getText());
		}
		
	}
	
	public static void tearDown() throws Exception {
		driver.quit();
		}
	
	
		}
