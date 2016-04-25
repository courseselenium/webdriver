package automation.framework.seleniumtest.testcases;


import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Ejemplo de uso de implicit y explicit waits.  
 * 
 */

public class WaitsTest {
	
	private String baseUrl = "http://tutorialzine.com/2009/09/simple-ajax-website-jquery/";
	private WebDriver driver;

	/**
	 * El método anotado con el tag @Before se ejecuta
	 * ANTES de cualquier ejecución de los métodos @Test
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
	}

	/**
	 * El método anotado con el tag @After se ejecuta
	 * DESPUÉS de cualquier ejecución de los métodos @Test
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	
	/**
	 * This test try to demonstrate that without any kind 
	 * of synchronization the test will throws NoSuchElementException.
	 * 
	 *  Remove the parameter of the Test annotation and you
	 *  will see the test failed 
	 * 
	 */
	@Test(expected= NoSuchElementException.class)
	public void failedTest() {
		
		driver.get(baseUrl);
		
		String mainWindow = driver.getWindowHandle();

		WebElement demoButton = driver.findElement(By.className("green"));
		demoButton.click();
		
		Object[] windowHandlers = driver.getWindowHandles().toArray();
		
		driver.switchTo().window((String)windowHandlers[1]);
		
		WebElement page3Link = driver.findElement(By.linkText("Page 3"));
		page3Link.click();
		
		WebElement image = driver.findElement(By.cssSelector("#pageContent > img"));
		
		assertEquals("300", image.getAttribute("height"));
	}

	@Test
	public void implicitWaitTest() {
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		driver.get(baseUrl);
		
		String mainWindow = driver.getWindowHandle();

		WebElement demoButton = driver.findElement(By.className("green"));
		demoButton.click();
		
		Object[] windowHandlers = driver.getWindowHandles().toArray();
		
		driver.switchTo().window((String)windowHandlers[1]);
		
		WebElement page3Link = driver.findElement(By.linkText("Page 3"));
		page3Link.click();
		
		WebElement image = driver.findElement(By.cssSelector("#pageContent > img"));
		
		assertEquals("300", image.getAttribute("height"));
		
	}
	
	/**
	 * With explicit wait you can configure the timeout.
	 * 
	 * An explicit wait will execute the function passed as parameter 
	 * in the until method (in this case we are using a {@link ExpectedConditions}
	 * object to create that funtion automatically), every 500 msecs.
	 * 
	 * If the element is not founded the a NoSuchElementException
	 * will be thrown.
	 * 
	 * @throws Exception
	 */
	@Ignore
	public void explicitWaitTest() {
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		driver.get(baseUrl);
		String mainWindow = driver.getWindowHandle();

		WebElement demoButton = driver.findElement(By.className("green"));
		demoButton.click();
		
		Object[] windowHandlers = driver.getWindowHandles().toArray();
		
		driver.switchTo().window((String)windowHandlers[1]);
		
		WebElement page3Link = driver.findElement(By.linkText("Page 3"));
		page3Link.click();
		
		WebElement image = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("#pageContent > img")));
		
		assertEquals("300", image.getAttribute("height"));
	}
	
	
	/**
	 * A fluent wait is the most flexible way to synchronize our script. 
	 * 
	 * A fluent wait configures the total timeout and the interval of polling
	 * a function (in this example we are using ExpectedConditions class)
	 * to 
	 * 
	 */
	@Test
	public void fluentWaitTest() {
		
		driver.get(baseUrl);
		
		String mainWindow = driver.getWindowHandle();

		WebElement demoButton = driver.findElement(By.className("green"));
		demoButton.click();
		
		Object[] windowHandlers = driver.getWindowHandles().toArray();
		
		driver.switchTo().window((String)windowHandlers[1]);
		
		WebElement page3Link = driver.findElement(By.linkText("Page 3"));
		page3Link.click();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(500, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement image = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("#pageContent > img")));
		
		assertEquals("300", image.getAttribute("height"));
		
	}
}