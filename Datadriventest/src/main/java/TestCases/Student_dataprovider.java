package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Student_dataprovider {
	
	@Test(dataProvider = "fetchdata")
	public void registerform(String fn,String ln,String email,String mob,String addr) throws InterruptedException {
		// TODO Auto-generated method stub
			System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://demoqa.com/automation-practice-form");
			
			driver.findElement(By.id("firstName")).sendKeys(fn);
			driver.findElement(By.id("lastName")).sendKeys(ln);
			driver.findElement(By.id("userEmail")).sendKeys(email);
			driver.findElement(By.id("gender-radio-1")).click();
			driver.findElement(By.id("userNumber")).sendKeys(mob);
			driver.findElement(By.id("currentAddress")).sendKeys(addr);
			JavascriptExecutor js=(JavascriptExecutor) driver;
			//js.executeScript("arguments[0].click();", gendermale);
			
			//scroll bottom of the page
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			
			driver.findElement(By.id("submit")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("closeLargeModal")).click();
			
	}
	
	
	@DataProvider(name="fetchdata")
	public Object[][] getdata()
	{
		return new Object[][]
		{
			{"Raju","G","sdf@gmail.com","9843534534","address1"}, {"Arun","T","rtyf@gmail.com","7893534534","address41"}, 
		};
			
		}
	}

