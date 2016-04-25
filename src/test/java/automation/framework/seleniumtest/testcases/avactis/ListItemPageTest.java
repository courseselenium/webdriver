package automation.framework.seleniumtest.testcases.avactis;

import static org.junit.Assert.*;

import org.junit.Test;

import automation.framework.avactis.pages.ItemListPage;
import automation.framework.avactis.ui.components.MainMenu.MainMenuOption;
import automation.framework.avactis.pages.HomePage;
import automation.framework.core.BaseTest;

public class ListItemPageTest extends BaseTest {

	@Test
	public void computers_betsellers_list_is_not_empty() {

		HomePage homePage = new HomePage(driver, "http://demo.avactis.com/4.7.9/index.php");
		homePage.open();

		ItemListPage computersPage = (ItemListPage) homePage
				.clickOnMenuOption(MainMenuOption.COMPUTERS);
		
		assertTrue(computersPage.getTotalBestSellerProducts() >= 1);

	}

}
