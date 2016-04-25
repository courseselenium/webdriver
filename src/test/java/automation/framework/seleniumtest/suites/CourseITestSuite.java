package automation.framework.seleniumtest.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import automation.framework.seleniumtest.testcases.AlertTest;
import automation.framework.seleniumtest.testcases.ConfirmationAlertTest;
import automation.framework.seleniumtest.testcases.PromptTest;

@RunWith(Suite.class)
@SuiteClasses({PromptTest.class, AlertTest.class, ConfirmationAlertTest.class})
public class CourseITestSuite {

}
