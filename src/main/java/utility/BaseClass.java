package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;

import config.PathConfig;

public class BaseClass {
	

	public static String readExcelSheetData(int row, int col) throws EncryptedDocumentException, IOException
	{
		File f = new File(PathConfig.excelSheetPath);
		
		Sheet sheet = WorkbookFactory.create(f).getSheet("Group_07");
		
		String str = sheet.getRow(row).getCell(col).getStringCellValue();
		
		return str;
	}
	
	public static String readPropertyFileData(String key) throws IOException
	{
		Properties obj = new Properties();
		
		FileInputStream file = new FileInputStream(PathConfig.propertyFilePath);
		
		obj.load(file);
		
		return (obj.getProperty(key));
		
	}
	
	public static WebDriver initBrowser()
	{
		System.setProperty("webdriver.edge.driver", PathConfig.edgeDriverPath);
		
		WebDriver dr = new EdgeDriver();
		
		return dr;
		
	}
	
	public static void takeScreenShot(WebDriver driver) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File f = new File(PathConfig.screenShotPath+"\\_new.jpg");
		
		FileHandler.copy(source, f);
	}
	
	

}
