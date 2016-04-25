package automation.framework.avactis.pages;

import org.openqa.selenium.WebDriver;

import automation.framework.avactis.ui.components.MainMenu;
import automation.framework.avactis.ui.components.MainMenu.MainMenuOption;

public class HomePage extends BasePage {
	
	private MainMenu mainMenu;
	private String baseUrl;
	
	public HomePage(WebDriver driver, String baseUrl) {
		this.driver = driver;
		this.baseUrl = baseUrl;
		mainMenu = new MainMenu(driver);
	}
	
	public void open() {
		driver.get(baseUrl);
	}
	
	public ItemListPage clickOnMenuOption(MainMenuOption option) {
		return mainMenu.clickMainMenuOption(option);
	}

}