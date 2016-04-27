package automation.framework.seleniumtest.testcases;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Dummy {

	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		// driver.quit();
	}

	@Test
	public void test() {

		String baseUrl = "http://demo.avactis.com/4.7.9/product-list.php?DVD-pg1-cid24.html";
		driver.get(baseUrl);

		List<WebElement> items = driver.findElements(By.cssSelector(".product-list .product-item"));
		//List<WebElement> items = bestSellers.findElements(By.className("product-item"));
		
		assertTrue(items.size()==1);

	}
}