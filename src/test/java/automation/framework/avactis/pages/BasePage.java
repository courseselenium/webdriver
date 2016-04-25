package automation.framework.avactis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import automation.framework.avactis.ui.components.MainMenu;

public abstract class BasePage {

	protected WebDriver driver;
	
	protected MainMenu mainMenu;
	
	protected void initElements(){
		PageFactory.initElements(driver, this);
	}
	
	
	
}
