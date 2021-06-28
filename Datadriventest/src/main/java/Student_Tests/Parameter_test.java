//Data driven approach -- used to create data driven framework (driving the test data from excel files)

package Student_Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Uilities.Xls_Reader;

public class Parameter_test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Webdriver code
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/automation-practice-form");
		
		//Data driven approach -- used to create data driven framework
		
		//Get test data from excel sheet
		Xls_Reader reader=new Xls_Reader("D:\\Automation\\Datadriventest\\src\\main\\java\\TestData\\StudentRegistration.xlsx");  //created object from Xls_Reader.jave from utilities package
		int rowCount=reader.getRowCount("Stu-sheet1");
		
		//Parameterizarion (always for loop)
		for(int rowNum=2; rowNum<=rowCount; rowNum++)
		{
			
			System.out.println("***********");
			//This is to get the values from excel sheet, passing parameters (colname & rownum) to getCellData method
			String Firstname= reader.getCellData("Stu-sheet1","FirstName", rowNum);  //Read the data from particular cell (sheetname, colname, rownum)
			System.out.println(Firstname);
			
			String Secondname= reader.getCellData("Stu-sheet1","SecondName", rowNum);  
			System.out.println(Secondname);
			
			String email= reader.getCellData("Stu-sheet1","Email", rowNum);  
			System.out.println(email);
			
			String gender= reader.getCellData("Stu-sheet1","Gender", rowNum);  
			System.out.println(gender);
			
			String mobile= reader.getCellData("Stu-sheet1","Mobile", rowNum);  
			System.out.println(mobile);
			
			String address= reader.getCellData("Stu-sheet1","Address", rowNum);  
			System.out.println(address);
			
			
			//Enter the data
			driver.findElement(By.id("firstName")).clear();
			driver.findElement(By.id("firstName")).sendKeys(Firstname);
			
			driver.findElement(By.id("lastName")).clear();
			driver.findElement(By.id("lastName")).sendKeys(Secondname);
			
			driver.findElement(By.id("userEmail")).clear();
			driver.findElement(By.id("userEmail")).sendKeys(email);
			WebElement gen=driver.findElement(By.id("gender-radio-1"));
			
			//click on the gender radio button using javascript
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", gen);
			
			//scroll bottom of the page
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

			driver.findElement(By.id("userNumber")).clear();
			driver.findElement(By.id("userNumber")).sendKeys(mobile);
			
			driver.findElement(By.id("currentAddress")).clear();
			driver.findElement(By.id("currentAddress")).sendKeys(address);
			
			//scroll bottom of the page
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			
			driver.findElement(By.id("submit")).click();
			Thread.sleep(6000);
			driver.findElement(By.id("closeLargeModal")).click();
			Thread.sleep(3000);
			
			
		}
		
	}

}
