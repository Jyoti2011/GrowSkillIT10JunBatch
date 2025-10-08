package day8_26092025;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import day6_24092025.Login_ORHM_PageFact;
import day6_24092025.Logout_ORHM;

public class KeywordDrivenFramework {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

		Login_ORHM_PageFact lin = new Login_ORHM_PageFact(driver);
		Logout_ORHM lout = new Logout_ORHM(driver);

		String filepath = "D:\\ExcelReadAndWrite\\TestingDataKeyword_ORHM.xlsx";
		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Keyword");
		int rows = sheet.getLastRowNum();
		System.out.println("Total No of Rows: " + rows);

		for (int i = 1; i <= rows; i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell key = row.getCell(1);
			System.out.println("Keyword--->" + key);

			switch (key.toString()) {
			case "url":
				lin.url();
				System.out.println("URL Keyword is Matching");
				break;
				
			case "enterUserName":
				lin.enterUserName("Admin");
				System.out.println("enterUserName Keyword is Matching");
				break;
				
			case "enterPassword":
				lin.enterPassword("admin123");
				System.out.println("enterPassword Keyword is Matching");
				break;
				
			case "clickOnLoginBTN":
				lin.clickOnLoginBTN();
				System.out.println("clickOnLoginBTN Keyword is Matching");
				break;
				
			case "clickOnProfile":
				lout.clickOnProfile();
				System.out.println("clickOnProfile Keyword is Matching");
				break;
				
			case "clickOnLogout":
				lout.clickOnLogout();
				System.out.println("clickOnLogout Keyword is Matching");
				break;
				
				default:System.out.println("Invalid Keyword");
				break;
			}

		}
		fis.close();
	}

}
