package com.test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {
	private WebDriver driver;
	
	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://google.com");
		
	}
	
	@Test
	public void testGooglePage() {
		WebElement searchbox = driver.findElement(By.name("q"));
		
		searchbox.clear();
		
		searchbox.sendKeys("Test Simple");
		
		searchbox.submit();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		assertEquals("Test Simple - Buscar con Google", driver.getTitle());
	}
	
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
