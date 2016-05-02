package automation.framework.seleniumtest.testcases;

import org.junit.Test;

import automation.framework.google.pages.GoogleSearchPage;
import automation.framework.seleniumtest.ParallelBaseTest;

public class GoogleSearchPageTest extends ParallelBaseTest {
	
    public GoogleSearchPageTest(String platform, String browserName, String browserVersion) {
        this.platform = platform;
        this.browserName = browserName;
        this.browserVersion = browserVersion;
    }
	
	@Test
	public void searchTest() {
		
		GoogleSearchPage page = new GoogleSearchPage(this.driver).get();
		page.search("webdriver");
	}
}