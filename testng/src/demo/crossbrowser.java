package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class crossbrowser {
	    WebDriver driver;
	@BeforeTest
	@Parameters("browser")
	public void crossbrowser1 (String browser){
		if(browser.equals("FireFox")){
			driver = new FirefoxDriver(); 
		}
		else if(browser.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "T:\\selenium drivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browser.equals("Internet Explorer")){
			System.setProperty("webdriver.edge.driver", "T:\\selenium drivers\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://facebook.com");
		
	}

	@Test
	public void verifytitle(){
		String expectedvalue = "Facebook helps you connect and share with the people in your life.";
		String actualvalue = driver.findElement(By.xpath("html/body/div[1]/div[2]/div[1]/div/div/div/div/div[1]/div/div")).getText();
		
		Assert.assertEquals(actualvalue, expectedvalue);
	}
	
	@AfterTest
	public void close(){
		driver.quit();
	}
}
