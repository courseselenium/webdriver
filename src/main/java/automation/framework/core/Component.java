package automation.framework.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Component {

	protected WebDriver driver;
	
	protected void initElements(){
		PageFactory.initElements(driver, this);
	}
	
	protected void waitForVisibility(WebElement element, int timeInSeconds) throws Error{
        new WebDriverWait(driver, timeInSeconds)
             .until(ExpectedConditions.visibilityOf(element));
	}
	
}