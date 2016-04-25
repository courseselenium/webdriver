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

public class ConfirmationAlertTest {
	
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

	/**
	 * A confirmation alert box contains two buttons; OK and CANCEL
	 * 
	 * To simulate the click on OK button 
	 * webdriver has the accept() method of the Alert Object.
	 * 
	 * To simulate the click on the CANCEL button webdriver 
	 * has the dismiss() method of the Alert Object.
	 * 
	 * 
	 */
	@Test
	public void confirmationTest() {
		
		driver.get(baseUrl);
		
		WebElement simpleButton = driver.findElement(By.id("confirm"));
		simpleButton.click();
		
		//We point the driver to the Alert boc 
		Alert confirmation = driver.switchTo().alert();
		
		assertTrue(confirmation.getText().equalsIgnoreCase("Press a button!"));
		
		confirmation.dismiss();

		WebElement element = driver.findElement(By.id("demo"));
		
		assertTrue(element.getText().equalsIgnoreCase("You Dismissed Alert!"));
		
	}

}
