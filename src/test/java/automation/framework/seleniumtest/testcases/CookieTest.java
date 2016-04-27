package automation.framework.seleniumtest.testcases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * 
 * 
 * @author Jose Blesa
 *
 */

public class CookieTest {

	private String baseUrl = "http://mango.es";
	private WebDriver driver;

	/**
	 * El método anotado con el tag @Before se ejecuta ANTES de cualquier
	 * ejecución de los métodos @Test
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * El método anotado con el tag @After se ejecuta DESPUÉS de cualquier
	 * ejecución de los métodos @Test
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		// driver.quit();
	}

	/**
	 * El método anotado con el tag @Test representa un test case
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void logInAsPepeTest() {

		driver.get(baseUrl);
		
		driver.findElement(By.linkText("CASTELLANO")).click();
		driver.findElement(By.id("userMenuTrigger")).click();
		driver.findElement(By.id("SVLoginCheck:FRegLogChk:userMail")).sendKeys("pepe@pepe.com");
		driver.findElement(By.id("SVLoginCheck:FRegLogChk:chkPwd")).sendKeys("123456a");
		driver.findElement(By.id("SVLoginCheck:FRegLogChk:j_id_bf")).click();
		
		File file = new File("Cookies.data");
		try {
			// Delete old file if exists
			file.delete();
			file.createNewFile();
			FileWriter fileWrite = new FileWriter(file);
			BufferedWriter Bwrite = new BufferedWriter(fileWrite);
			// loop for getting the cookie information
			for (Cookie ck : driver.manage().getCookies()) {
				Bwrite.write((ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";"
						+ ck.getExpiry() + ";" + ck.isSecure()));
				Bwrite.newLine();
			}
			Bwrite.flush();
			Bwrite.close();
			fileWrite.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Test
	public void logInAsPepeWithCookiesTest() {

		try {

			File file = new File("Cookies.data");
			FileReader fileReader = new FileReader(file);
			BufferedReader Buffreader = new BufferedReader(fileReader);
			String strline;
			while ((strline = Buffreader.readLine()) != null) {
			
				StringTokenizer token = new StringTokenizer(strline, ";");
				while (token.hasMoreTokens()) {
					String name = token.nextToken();
					String value = token.nextToken();
					String domain = token.nextToken();
					String path = token.nextToken();
					Date expiry = null;

					String val;
					if (!(val = token.nextToken()).equals("null")) {
						expiry = new Date(val);
					}
					Boolean isSecure = new Boolean(token.nextToken()).booleanValue();
					Cookie ck = new Cookie(name, value, domain, path, expiry, isSecure);
					driver.manage().addCookie(ck); // This will add the stored
													// cookie to your current
													// session
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		driver.navigate().to(baseUrl);
	}

}
