package LibraryFiles;

import java.io.File;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UtilityClass 
{
	public static String getTestData(int rowindex, int cellindex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file= new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\28JanSeleniumMavenSelf\\TestData\\abcd.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("Sheet5");
		String value = sh.getRow(rowindex).getCell(cellindex).getStringCellValue();
		return value;
	}
	public static void CaptureSS(WebDriver driver,int TCID)
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\HP\\eclipse-workspace\\28JanSeleniumMavenSelf\\FailedTCase\\TestCaseID"+TCID+".jpg");
	}
	public static String getPFdata(String key) throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\28JanSeleniumMavenSelf\\PropertyFile.properties");
		Properties p=new Properties();
		p.load(file);
		 
		String value = p.getProperty(key);
		return value;
	}
		
	}


