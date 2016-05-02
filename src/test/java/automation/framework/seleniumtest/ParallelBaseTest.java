package automation.framework.seleniumtest;

import java.net.URL;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import automation.framework.core.ParallelizerTest;

/**
 * 
 * Base class to include all the common things for all the test cases
 *
 * @author Jose Blesa
 *
 */

@RunWith(ParallelizerTest.class)
public abstract class ParallelBaseTest {

	protected WebDriver driver;
    protected String platform;
    protected String browserName;
    protected String browserVersion;
    
    private String URL;
    
  //Hold all Configuration values in a LinkedList
    @Parameters
    public static LinkedList<String[]> getEnvironments() throws Exception {
        LinkedList<String[]> env = new LinkedList<String[]>();
        env.add(new String[]{"Windows 7","chrome",  "48.0"});
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
        
        this.URL = "http://" + System.getProperty("saucelabs.user") + ":" + System.getProperty("saucelabs.key") +"@ondemand.saucelabs.com:80/wd/hub";
        
        driver = new RemoteWebDriver(new URL(this.URL), cap);

	}

	@After
	public void tearDown() {
		driver.quit();
	}
}