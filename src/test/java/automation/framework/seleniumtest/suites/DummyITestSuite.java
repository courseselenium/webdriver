package automation.framework.seleniumtest.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import automation.framework.seleniumtest.testcases.dummyIT;

@RunWith(Suite.class)
@SuiteClasses({dummyIT.class })
public class DummyITestSuite {}