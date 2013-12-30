package shoppingInfo;

import Products.*;
import java.util.HashMap;

/**
 * The StoreShelf is used to store all the different product items of the shoppingstore from which a product of a specific category can be retrieved for billing.
 * 
 * @author WeiZhou
 */

public class StoreShelf {
	// The product items mapped to their respective categories 
	private HashMap<String, Product> productItems;

	public StoreShelf(){
		productItems = new HashMap<String, Product>();
		addProductsToShelf("book", new BookProduct());
		addProductsToShelf("music CD" , new OtherProduct());
		addProductsToShelf("chocolate bar", new FoodProduct());
		addProductsToShelf("box of chocolates" , new FoodProduct());
		addProductsToShelf("bottle of perfume", new OtherProduct());
		addProductsToShelf("packet of headache pills", new MedicalProduct());
	}

	/**
	 * Add the product items to store shelf in their respective categories.
	 *
	 * @param productItem - the product item
	 * @param productCategory - the product category to which a particular item belongs.
	 */
	public void addProductsToShelf(String productItem, Product productCategory){
		productItems.put(productItem, productCategory);
	}

	/**
	 * Search for the item using the string name and maps it to the product category to create a new Product object.
	 *
	 * @param name - name of the product
	 * @param price - price of product
	 * @param imported - boolean value of whether imported or not
	 * @param quantity - quantity of product
	 * @return Product
	 */
	public Product searchAndRetrieveItemFromShelf(String name, double price, boolean imported, int quantity){
		Product productItem = productItems.get(name).getHelper().createProduct(name, price, imported, quantity);
		return productItem;
	}

	/**
	 * Get the total number of items presenting in the shelf.
	 */
	public int getShelfSize() {
		return productItems.size();
	}
}
