package automation.framework.avactis.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ItemListPage extends BasePage {

	@FindBy(how = How.CLASS_NAME, using = ".product_item")
	private List<WebElement> productList;
	
	@FindBy(how = How.CSS, using = ".sale-product .product-item")
	private List<WebElement> bestSellerList;

	public ItemListPage(WebDriver driver) {
		this.driver = driver;
		initElements();
	}
	
	// Actions performed in this page
	public int getTotalBestSellerProducts() {
		
		return bestSellerList.size();
	}
}