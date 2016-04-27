package automation.framework.seleniumtest.testcases.avactis;

import static org.junit.Assert.*;

import org.junit.Test;

import automation.framework.avactis.components.MainMenu.MainMenuOption;
import automation.framework.avactis.pages.home.HomePage;
import automation.framework.avactis.pages.productlist.ComputersPage;
import automation.framework.seleniumtest.BaseTest;

public class ListItemPageTest extends BaseTest {

	@Test
	public void computers_betsellers_list_is_not_empty() {

		HomePage homePage = (HomePage) new HomePage(driver, "Avactis Demo Store").get();

		ComputersPage computersPage = 
				(ComputersPage) homePage.clickOnMenuOption(MainMenuOption.COMPUTERS);
		
		assertTrue(computersPage.getTotalBestSellerProducts() >= 1);
	}
}