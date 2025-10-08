package day3_17092025;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	WebDriver driver;
	
	@BeforeSuite
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}
	
	
	
	
	@DataProvider(name = "dataSet", parallel = false)
	public Object[][] mobileDataSet()
	{
		Object[][] data=new Object[3][2];
		data[0][0]="iPhone";
		data[0][1]="17";
		
		data[1][0]="OnePlus";
		data[1][1]="13";
		
		data[2][0]="Oppo";
		data[2][1]="Reno 10";
		
		return data;
	}
	
	
	
	
	@Test(dataProvider = "dataSet")
	public void searchMobile(String brand, String model) throws InterruptedException
	{
		try {
		WebElement popUp=driver.findElement(By.xpath("//div[@class='JFPqaw']/child::span"));
		if(popUp.isDisplayed())
		{
			popUp.click();
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		WebElement searchBox=driver.findElement(By.name("q"));
		searchBox.sendKeys(brand+" "+model);
		searchBox.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.navigate().back();
		
	}

}
