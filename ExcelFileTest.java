package qualityStreamTutorial;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelFileTest {

	private WebDriver driver;
	private ReadExcelFile read;
	private WriteExcel write;
	private By searchBoxLocator = By.id("search_query_top");
	private By searchBtnLocator = By.name("submit_search");
	private By resultTextLocator = By.cssSelector("span.heading-counter");
	
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver= new ChromeDriver();
		write = new WriteExcel();
		read = new ReadExcelFile();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws IOException {
		String filepath = "D:\\Libro.xlsx";
		String searchText = read.getCellValue(filepath, "Hoja1", 0, 0);
		driver.findElement(searchBoxLocator).sendKeys(searchText);
		driver.findElement(searchBtnLocator).click();
		String resultText = driver.findElement(resultTextLocator).getText();
		System.out.println("Page result text :"+resultText);
		read.readExcel(filepath, "Hoja1");
		write.writeCellValue(filepath, "Hoja1", 0, 1, resultText);
		//read.readExcel(filepath, "Hoja1");
		
	}

}
