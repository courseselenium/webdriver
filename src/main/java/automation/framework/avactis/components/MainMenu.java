package automation.framework.avactis.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import automation.framework.avactis.pages.productlist.ComputersPage;
import automation.framework.avactis.pages.productlist.ProductListPage;
import automation.framework.core.Component;

public class MainMenu extends Component {

	@FindBy(how = How.CSS, using = "css=div.header-navigation > ul > li > a")
	private WebElement apparel;

	@FindBy(how = How.XPATH, using = "//a[@href='http://demo.avactis.com/4.7.9/product-list.php?Computers-pg1-cid8.html']")
	private WebElement computers;

	@FindBy(how = How.XPATH, using = "//a[@href='http://demo.avactis.com/4.7.9/product-list.php?DVD-pg1-cid24.html']")
	private WebElement dvd;

	@FindBy(how = How.XPATH, using = "//a[@href='http://demo.avactis.com/4.7.9/product-list.php?Furniture-pg1-cid33.html']")
	private WebElement furniture;

	@FindBy(how = How.XPATH, using = "//a[@href='http://demo.avactis.com/4.7.9/product-list.php?Sport_and_Travel-pg1-cid11.html']")
	private WebElement sport;

	@FindBy(how = How.XPATH, using = "//a[@href='http://demo.avactis.com/4.7.9/product-list.php?Digital_Distribution-pg1-cid12.html']")
	private WebElement digital;

	public MainMenu(WebDriver driver) {
		this.driver = driver;
		initElements();
	}

	// ************************************************************
	// Actions to performed in this page.
	// ************************************************************
	/**
	 * click in the option indicated in the parameter
	 * 
	 * @param option {@link MainMenuOption}
	 * @return
	 */
	public ProductListPage clickMainMenuOption(MainMenuOption option) {
		
		ProductListPage productListPage = null;

		switch (option) {
		case APPAREL:
			apparel.click();
			break;
		case COMPUTERS:
			productListPage = (ComputersPage) new ComputersPage(driver, "Computers").get();
			break;
		case DVD:
			dvd.click();
			break;
		case FURNITURE:
			furniture.click();
			break;
		case SPORT:
			sport.click();
			break;
		case DIGITAL:
			digital.click();
			break;
		}
		
		return productListPage; 
	}

	/**
	 * Options available in the main menu.
	 * 
	 * @author Jose Blesa
	 *
	 */
	public enum MainMenuOption {
		APPAREL(1), COMPUTERS(2), DVD(3), FURNITURE(4), SPORT(5), DIGITAL(6);

		private final int optionCode;

		MainMenuOption(int code) {
			this.optionCode = code;
		}

		public int getOptionCode() {
			return optionCode;
		}
	}
}