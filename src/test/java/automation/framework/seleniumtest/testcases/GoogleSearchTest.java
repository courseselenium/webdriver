package automation.framework.seleniumtest.testcases;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * 
 * @author Jose Blesa
 *
 */

public class GoogleSearchTest {
	
	private String baseUrl = "http://www.google.com";
	private WebDriver driver;

	/**
	 * El m�todo anotado con el tag @Before se ejecuta
	 * ANTES de cualquier ejecuci�n de los m�todos @Test
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	/**
	 * El m�todo anotado con el tag @After se ejecuta
	 * DESPU�S de cualquier ejecuci�n de los m�todos @Test
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	/**
	 * El m�todo anotado con el tag @Test representa
	 * un test case
	 * 
	 * @throws Exception
	 */
	@Test
	public void searchTest() {
		
		//WebDriverWait wait = new WebDriverWait(driver, 5);
		
		//Abrimos el navegador por la URL indicada.
		driver.get(baseUrl);
		
		//findElement nos buscar� un elemento seg�n el objeto By que le
		//pasemos.
		WebElement searchInputText = driver.findElement(By.id("lst-ib"));
		
		//enviamos una cadena de car�cteres al elemento, en este caso un input de tipo text.
		searchInputText.sendKeys("webdriver");
		//El objeto Keys nos permite simular pulsaciones de teclas tal y como lo har�a un usuario.
		searchInputText.sendKeys(Keys.ENTER);
		
		//El metodo findElements devuelve una lista de elementos que cumplen con 
		//el localizador pasado como par�metro.
		List<WebElement> entries = driver.findElements(By.className("g"));
		//List<WebElement> entries = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("g")));
		
		assertEquals(10, entries.size());
		
		//Obtenemos el primer elemento de la lista retornada.
		WebElement firstEntry = entries.get(0);
		
		//Estamos buscando dentro del elemento obtenido. Y NO en la p�gina completa.
		String text = firstEntry.findElement(By.className("r")).getText();
		assertTrue(text.contains("WebDriver"));
		
	}

}
