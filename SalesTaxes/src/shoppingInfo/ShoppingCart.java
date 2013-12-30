/**
 * The ShoppingCart holds the products purchased and from it the products are retrieved for billing.
 * 
 * @author WeiZhou
 * 
 */
package shoppingInfo;

import Products.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart{
	private ArrayList<Product> productList;

	public ShoppingCart(){
		productList = new ArrayList<Product>();
	}

	/**
	 * Add the prodcut item to the shopping cart.
	 */
	public void addItemToCart(Product product){
		productList.add(product);
	}

	/**
	 * Get the product list from the shopping cart.
	 */
	public ArrayList<Product> getItemsFromCart() {
		return productList;
	}

	/**
	 * Get the number of products in the shopping cart.
	 */
	public int getCartSize() {
		return productList.size();
	}
}
