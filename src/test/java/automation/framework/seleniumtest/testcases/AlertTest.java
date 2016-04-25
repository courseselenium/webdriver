package automation.framework.seleniumtest.testcases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * 
 * 
 * @author Jose Blesa
 *
 */

public class AlertTest {
	
	private String baseUrl = "http://cookbook.seleniumacademy.com/Alerts.html";
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void simpleAlertTest() {
		
		driver.get(baseUrl);
		
		WebElement simpleButton = driver.findElement(By.id("simple"));
		simpleButton.click();
		
		Alert alert = driver.switchTo().alert();
		
		assertEquals("Hello! I am an alert box!", alert.getText());
		alert.accept();
		
	}
	
}