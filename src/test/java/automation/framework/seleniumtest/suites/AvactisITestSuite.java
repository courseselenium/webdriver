package automation.framework.seleniumtest.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import automation.framework.seleniumtest.testcases.avactis.ListItemPageTest;

@RunWith(Suite.class)
@SuiteClasses({ListItemPageTest.class })
public class AvactisITestSuite {

}
