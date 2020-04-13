package com.Udemy.webDriverMaven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
	public WebDriver driver;

	@BeforeSuite
	public void setUp() {
		//System.setProperty("webdriver.chrome.driver", "F:\\\\software\\\\jar_files\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
	}
	
	@Test
	public void search() {
		//driver.get("http://google.com/");
		driver.findElement(By.name("q")).sendKeys("Testing");
		driver.findElement(By.className("gNO89b")).click();
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}
