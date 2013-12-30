/**
 * ProductHelper is an abstract class, being used to create new specific product object.
 * 
 * @author WeiZhou
 * 
 */

package ProductHelper;

import Products.Product;

public abstract class ProductHelper{
	public abstract Product createProduct(String name, double price, boolean imported, int quantity);
}