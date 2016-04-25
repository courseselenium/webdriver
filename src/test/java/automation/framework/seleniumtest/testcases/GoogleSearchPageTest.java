package automation.framework.seleniumtest.testcases;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import automation.framework.core.OnExceptionListener;
import automation.framework.google.pages.GoogleSearchPage;

public class GoogleSearchPageTest {
	
	private EventFiringWebDriver efDriver;
	
	@Before
	public void setUp(){
		efDriver = new EventFiringWebDriver(new FirefoxDriver()) ;
		efDriver.register(new OnExceptionListener());
		
		//efDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void searchTest() {
		
		GoogleSearchPage page = new GoogleSearchPage(efDriver);
		page.get();
		page.search("webdriver");
	}
	
	@After
	public void tearDown(){
		efDriver.quit();
	}	
}