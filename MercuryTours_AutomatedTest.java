package qualityStreamTutorial;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryTours_AutomatedTest {

	private WebDriver driver;
	By registerLinkLocator = By.linkText("REGISTER");
	By registerPageLocator = By.xpath("//img[@src='/images/masts/mast_register.gif']");
	By registerBtnLocator = By.name("register");
	
	By user = By.id("email");
	By password = By.name("password");
	By confirm = By.name("confirmPassword");
	
	By signInUserLocator = By.name("userName");
	By signInPasswordLocator = By.name("password");
	By signInBtnLocator = By.name("login");
	By signInPageLocator = By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']");
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void registerUser() throws InterruptedException {
		driver.findElement(registerLinkLocator).click();
		Thread.sleep(2000);
		if(driver.findElement(registerPageLocator).isDisplayed()){
			driver.findElement(user).sendKeys("danielgpinon@outlook.com");
			driver.findElement(password).sendKeys("1234");
			driver.findElement(confirm).sendKeys("1234");
			driver.findElement(registerBtnLocator).click();
			
		}
		else {
			System.out.println("Register page was not found");
		}
		List<WebElement> fonts=driver.findElements(By.tagName("font"));
		assertEquals("Note: Your user name is danielgpinon@outlook.com.", fonts.get(5).getText());
		
	}
	@Test
	public void signIn() throws InterruptedException {
		if(driver.findElement(signInUserLocator).isDisplayed()) {
			driver.findElement(signInUserLocator).sendKeys("danielgpinon@outlook.com");
			driver.findElement(signInPasswordLocator).sendKeys("1234");
			driver.findElement(signInBtnLocator).click();
			Thread.sleep(2000);
			assertTrue(driver.findElement(signInPageLocator).isDisplayed());
		}
	}

}
