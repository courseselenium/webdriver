package automation.framework.seleniumtest;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import automation.framework.core.ParallelizerTest;

import static org.junit.Assert.fail;

/**
 * 
 * Base class to include all the common things for all the test cases
 *
 * @author Jose Blesa
 *
 */

@RunWith(ParallelizerTest.class)
public abstract class ParallelBaseTest {

	protected static WebDriver driver;
    protected String platform;
    protected String browserName;
    protected String browserVersion;
    
    private String username;
    private String key;
    private String URL;
    
  //Hold all Configuration values in a LinkedList
    @Parameters
    public static LinkedList<String[]> getEnvironments() throws Exception {
        LinkedList<String[]> env = new LinkedList<String[]>();
        env.add(new String[]{"Windows 7","chrome", "48.0"});
        env.add(new String[]{"Windows 7","firefox", "42.0"});
        env.add(new String[]{"Windows 8","IE","10.0"});
        return env;
    }
 
	@Before
	public void setUp() throws Exception {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		switch(browserName) {
		
		case "chrome" :
			cap = DesiredCapabilities.chrome();
			break;
				
		case "firefox" :
			cap = DesiredCapabilities.firefox();
			break;
		
		case "IE" :
			cap = DesiredCapabilities.internetExplorer();
			break;
			
		case "safari" :
			cap = DesiredCapabilities.safari();
			break;
			
		}
		
		cap.setCapability("platform", platform);
        cap.setCapability("version", browserVersion);
        cap.setCapability("build", "seleniumcourse");
        
        this.key = System.getProperty("saucelab.key");
        this.username = System.getProperty("saucelab.username");
        this.URL = "http://" + username + ":" + key +"@ondemand.saucelabs.com:80/wd/hub";
        
        driver = new RemoteWebDriver(new URL(this.URL), cap);

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