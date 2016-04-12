package automation.framework.unittest.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import automation.framework.unittest.testcases.DummyTest;

@RunWith(Suite.class)
@SuiteClasses({ DummyTest.class })
public class DummyUTestSuite {

}
