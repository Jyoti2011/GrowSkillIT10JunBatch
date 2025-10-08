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

public class HybridFrameworkDemo {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

		Login_ORHM_PageFact lin = new Login_ORHM_PageFact(driver);
		Logout_ORHM lout = new Logout_ORHM(driver);

		
		String filepath = "D:\\ExcelReadAndWrite\\TestingDataKeyword_ORHM.xlsx";
		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet dataSheet=workbook.getSheet("Data");
		XSSFSheet keySheet = workbook.getSheet("Keyword");
		int dataRows = dataSheet.getLastRowNum();
		System.out.println("Total No of Data Rows: " + dataRows);
		int keyRows = keySheet.getLastRowNum();
		System.out.println("Total No of Keyword Rows: " + keyRows);
		
		for(int dr=1;dr<=dataRows;dr++)
		{
			XSSFRow dRow=dataSheet.getRow(dr);
			XSSFCell un=dRow.getCell(0);
			XSSFCell pw=dRow.getCell(1);
			
			System.out.println("UserName ----->"+un+"     Password--->"+pw);
			try {
			for (int kr = 1; kr <= keyRows; kr++) {
				XSSFRow row = keySheet.getRow(kr);
				XSSFCell key = row.getCell(1);
				System.out.println("Keyword--->" + key);

				switch (key.toString()) {
				case "url":
					lin.url();
					System.out.println("URL Keyword is Matching");
					break;
					
				case "enterUserName":
					lin.enterUserName(un.toString());
					System.out.println("enterUserName Keyword is Matching");
					break;
					
				case "enterPassword":
					lin.enterPassword(pw.toString());
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
			System.out.println("Valid Data");
			}
			catch(Exception e)
			{
				System.out.println("Invalid Data");
			}
			}
		fis.close();
		}

	}
