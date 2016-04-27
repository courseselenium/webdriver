package automation.framework.avactis.pages.productlist;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ComputersPage extends ProductListPage {
	
	@FindBy(how=How.CLASS_NAME , using=".category_products")
	private WebElement categories;
	
	public ComputersPage(WebDriver driver, String titleKey) {
		this.driver = driver;
		this.titleKey = titleKey;
		initElements();
	}

	@Override
	protected void load() {
		driver.get("http://demo.avactis.com/4.7.9/product-list.php?Computers-pg1-cid8.html");
	}
}