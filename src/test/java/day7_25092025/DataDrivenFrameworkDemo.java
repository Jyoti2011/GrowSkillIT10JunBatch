package day7_25092025;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import day6_24092025.Login_ORHM_PageFact;
import day6_24092025.Logout_ORHM;

public class DataDrivenFrameworkDemo {

	public static void main(String[] args) throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		Login_ORHM_PageFact lin=new Login_ORHM_PageFact(driver);
		Logout_ORHM lout=new Logout_ORHM(driver);
		
		lin.url();
		
		String filepath="D:\\ExcelReadAndWrite\\TestingDataKeyword_ORHM.xlsx";
		FileInputStream fis=new FileInputStream(filepath);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Data");
		int rows=sheet.getLastRowNum();
		System.out.println("Total No of Rows: "+rows);
		
		for(int i=1;i<=rows;i++)
		{
			XSSFRow row=sheet.getRow(i);
			XSSFCell un=row.getCell(0);
			XSSFCell pw=row.getCell(1);
			XSSFCell result=row.createCell(2);
			XSSFCell err=row.createCell(3);
			System.out.println("UserName ----->"+un+"     Password--->"+pw);
			try {
			lin.enterUserName(un.toString());
			lin.enterPassword(pw.toString());
			lin.clickOnLoginBTN();
			lout.clickOnProfile();
			lout.clickOnLogout();
			System.out.println("Valid Data");
			result.setCellValue("Valid data");
			err.setCellValue("NA");
			}
			catch(Exception e)
			{
				String errorMsg=driver.findElement(By.xpath("//div[@id='app']/descendant::p[1]")).getText();
				System.out.println("Invalid Data");
				result.setCellValue("Invalid data");
				err.setCellValue(errorMsg);
			}
		}
		fis.close();
		FileOutputStream fos=new FileOutputStream(filepath);
		workbook.write(fos);
	}

}
