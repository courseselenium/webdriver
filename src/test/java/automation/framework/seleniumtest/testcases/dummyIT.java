package automation.framework.seleniumtest.testcases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class dummyIT {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		System.out.println("Ejecutando el test de integracion");
		assertTrue(true);
	}

}