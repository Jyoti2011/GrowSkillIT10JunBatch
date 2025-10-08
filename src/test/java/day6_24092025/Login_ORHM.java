package day6_24092025;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_ORHM {
	WebDriver driver;
	
	
	public Login_ORHM(WebDriver driver)
	{
		this.driver=driver;
	}

	//Repository
	By userNM=By.name("username");
	By pass=By.name("password");
	By login=By.xpath("//button[@type='submit']");
	
	public void url()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	public void enterUserName(String un)
	{
		driver.findElement(userNM).sendKeys(un);
	}
	
	public void enterPassword(String pw)
	{
		driver.findElement(pass).sendKeys(pw);
	}
	
	public void clickOnLoginBTN()
	{
		driver.findElement(login).click();
	}
}
