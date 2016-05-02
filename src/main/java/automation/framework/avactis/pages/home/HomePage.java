package automation.framework.avactis.pages.home;

import org.openqa.selenium.WebDriver;

import automation.framework.avactis.components.MainMenu;
import automation.framework.avactis.components.MainMenu.MainMenuOption;
import automation.framework.avactis.pages.productlist.ProductListPage;
import automation.framework.core.Page;

public class HomePage extends Page {
	
	private MainMenu mainMenu;
	
	public HomePage(WebDriver driver, String titleKey) {
		this.driver = driver;
		this.titleKey = titleKey;
		mainMenu = new MainMenu(driver);
	}
	
	public ProductListPage clickOnMenuOption(MainMenuOption option) {
		return mainMenu.clickMainMenuOption(option);
	}

	@Override
	protected void load() {
		driver.get("http://demo.avactis.com/4.7.9/index.php");
	}
	
}