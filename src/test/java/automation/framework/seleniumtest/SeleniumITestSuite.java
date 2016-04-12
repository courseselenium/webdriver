package automation.framework.seleniumtest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({IntegrationIT.class })
public class SeleniumITestSuite {}