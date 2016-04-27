package automation.framework.avactis.pages.productlist;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import automation.framework.core.Page;

public abstract class ProductListPage extends Page {
	
	@FindBy(how = How.CLASS_NAME, using = ".sale-product")
	protected WebElement saleProducts;
	
	@FindBy(how = How.CSS, using = ".sale-product .product-item")
	protected List<WebElement> bestSellerList;
	
	// Actions performed in this page
	// -------------------------------------------------
	public int getTotalBestSellerProducts() {
		return bestSellerList.size();
	}
	//--------------------------------------------------
}