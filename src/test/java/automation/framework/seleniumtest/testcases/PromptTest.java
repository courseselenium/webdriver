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

public class PromptTest {
	
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
	public void promptTest() {
		
		String var = "selenium";
		
		driver.get(baseUrl);
		
		WebElement simpleButton = driver.findElement(By.id("prompt"));
		simpleButton.click();
		
		//We point the driver to the Alert box 
		Alert prompt = driver.switchTo().alert();
		
		prompt.sendKeys(var);
		prompt.accept();
		
		assertTrue(driver.findElement(By.id("prompt_demo")).getText().contains(var));
	
	}

	
}
