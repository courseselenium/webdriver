package automation.framework.seleniumtest.testcases;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionTest {

	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		// driver.quit();
	}

	@Test
	@Ignore
	public void testDragAndDrop() {

		String baseUrl = "https://jqueryui.com/droppable/";
		driver.get(baseUrl);

		WebElement demoFrame = driver.findElement(By.className("demo-frame"));

		driver.switchTo().frame(demoFrame);

		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));

		Actions builder = new Actions(driver);
		Action dragAnDrop = builder.clickAndHold(draggable).moveToElement(droppable).release().build();
		dragAnDrop.perform();

		assertTrue(droppable.getText().equals("Dropped!"));

	}

	@Test
	@Ignore
	public void testDrangAndDropBy() {

		String baseUrl = "https://jqueryui.com/slider/#rangemax";
		driver.get(baseUrl);

		WebElement demoFrame = driver.findElement(By.className("demo-frame"));

		driver.switchTo().frame(demoFrame);

		WebElement slider = driver.findElement(By.className("ui-slider-handle"));

		Actions builder = new Actions(driver);
		Action dragAnDrop = builder.dragAndDropBy(slider, 15, 0).build();
		dragAnDrop.perform();

	}

	@Test
	@Ignore
	public void testCtrlandClick() {

		String baseUrl = "https://jqueryui.com/selectable/#display-grid";
		driver.get(baseUrl);

		WebElement demoFrame = driver.findElement(By.className("demo-frame"));

		driver.switchTo().frame(demoFrame);

		WebElement selectable = driver.findElement(By.id("selectable"));
		WebElement one = selectable.findElement(By.xpath("//li[1]"));
		WebElement two = selectable.findElement(By.xpath("//li[2]"));
		WebElement five = selectable.findElement(By.xpath("//li[5]"));

		Actions builder = new Actions(driver);
		Action selection = builder.keyDown(Keys.CONTROL).click(one).click(two).click(five).keyUp(Keys.CONTROL).build();
		selection.perform();

	}

	
	@Test
	public void testMouseDrag() {

		String baseUrl = "http://html5tutoriales.com/images/Tutoriales/JQueryCanvas/HTMLs/T0404/T0404.html";
		driver.get(baseUrl);

		WebElement canvas = driver.findElement(By.id("can"));
		
			
		Actions builder = new Actions(driver);
		
		builder.clickAndHold(canvas)
				.moveByOffset(0,-100)
				.moveByOffset(100, 0)
				.moveByOffset(0, 100)
				.moveByOffset(-100, 0)
				.release()
				.build()
				.perform();
	}
}