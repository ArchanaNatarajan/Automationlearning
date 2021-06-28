package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleSearchPage;

public class GoogleSearchTest {
	
	private static WebDriver driver=null;

	public static void main(String[] args)  {
		googleSearch();
	}
	
	public static void googleSearch() 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		GoogleSearchPage.search_textbox(driver).sendKeys("Automation step by step");
		//GoogleSearchPage.button_search(driver).click();  //Sometime its not work on click it was overlapped
		GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);
		driver.close();
		System.out.println("Test Completed Successfully");
	}

}
