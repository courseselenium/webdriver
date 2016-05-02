package automation.framework.seleniumtest;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.junit.Assert.fail;

/**
 * 
 * Base class to include all the common things for all the test cases
 *
 * @author Jose Blesa
 *
 */
public abstract class BaseTest {

	protected WebDriver driver;

	@Before
	public void setUp() throws Exception {

		String browser = System.getProperty("browser");

		DesiredCapabilities capabilities;

		if (browser != null) {
			switch (browser) {

			case "remote":
				capabilities = new DesiredCapabilities();
				capabilities.setBrowserName(System.getProperty("remote-browser"));
				driver = new RemoteWebDriver(new URL(System.getProperty("remote-server-url")), capabilities);
				break;

			case "phantomjs":
				/**
				 * //File phantomjs = Phanbedder.unpack(); DesiredCapabilities
				 * capabilities = new DesiredCapabilities();
				 * capabilities.setCapability(PhantomJSDriverService.
				 * PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
				 * System.getProperty("phantomjs.binary.path")); driver = new
				 * PhantomJSDriver(capabilities);
				 **/
				break;

			case "chrome":
				driver = new ChromeDriver();
				break;

			case "ie":
				capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
				capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
				capabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
				capabilities.setCapability("requireWindowFocus", true);
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
				capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
				capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
				driver = new InternetExplorerDriver(capabilities);
				break;

			default:
				driver = new FirefoxDriver();
				break;
			}
		} else {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	/**
	 * 
	 * @param by
	 * @return
	 */
	protected WebElement findElement(By by) {

		WebElement element = null;

		try {
			element = driver.findElement(by);
		} catch (Exception nsee) {
			nsee.printStackTrace();
			fail("Test failed: shoot taken!");
		}

		return element;
	}

	/**
	 * 
	 * @throws IOException
	 */
	protected void takeAScreenShoot() throws IOException {

		TakesScreenshot snapshoot = (TakesScreenshot) driver;
		File shoot = snapshoot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(shoot, new File(".\\screenshoots\\screenshoot.png"));

	}

}