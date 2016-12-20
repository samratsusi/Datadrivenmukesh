package demo;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Screenshot {
	WebDriver driver;
	@BeforeTest 
	public void open(){
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://facebook.com"); 
	}
	
	@Test
	public void main() throws IOException{
		try{
		driver.findElement(By.id("email")).sendKeys("samrat.susi@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("samrat");
		driver.findElement(By.xpath("//input[@type='subbmit']")).click();
		}
		catch(Exception e) {
			System.out.println("error" + e.getMessage());
			getscreenshot();
		}
	}
	
	public void getscreenshot() throws IOException{
		File xyz = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(xyz, new File("T:\\SeleniumWorkspace\\newpicture.jpg"));
		
	}

}
