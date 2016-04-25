package automation.framework.google.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchPage extends LoadableComponent<GoogleSearchPage> {
	
	private WebDriver driver;
	
	@FindBy(id="lst-ibz")
	private WebElement searchField;
	
	
	public GoogleSearchPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@Override
	protected void isLoaded() throws Error {
		waitForVisibility(searchField);
	}
	
	@Override
	protected void load() {
		driver.get("https://www.google.com/");
	}
	
	
	public void search(String text){
		searchField.sendKeys(text);
		searchField.sendKeys(Keys.ENTER);
	}
	
	private void waitForVisibility(WebElement element) throws Error{
        new WebDriverWait(driver, 20)
             .until(ExpectedConditions.visibilityOf(element));
 }
	
}