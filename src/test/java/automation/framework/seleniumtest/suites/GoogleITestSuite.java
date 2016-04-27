package automation.framework.seleniumtest.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import automation.framework.seleniumtest.testcases.GoogleSearchTest;

@RunWith(Suite.class)
@SuiteClasses({ GoogleSearchTest.class })
public class GoogleITestSuite {

}
