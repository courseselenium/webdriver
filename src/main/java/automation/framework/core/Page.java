package automation.framework.core;


import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page extends LoadableComponent<Page>{

	protected WebDriver driver;
	protected String titleKey;
	
	protected void initElements(){
		PageFactory.initElements(driver, this);
	}
	
	@Override
	protected void isLoaded() throws Error {
		waitForTitleContains(titleKey, 5);
	}	
	
	protected void waitForVisibility(WebElement element, int timeInSeconds) throws Error{
		new WebDriverWait(driver, timeInSeconds)
             .until(ExpectedConditions.visibilityOf(element));
	}
	
	protected void waitForTitleContains(String key, int timeInSeconds) throws Error{
		try {
        new WebDriverWait(driver, timeInSeconds)
             .until(ExpectedConditions.titleContains(key));
		}catch(TimeoutException te) {
			throw new Error();
		}
	}	
	
}