package ProductHelper;

import Products.OtherProduct;

public class OtherProductHelper extends ProductHelper {
	 public OtherProduct createProduct(String name, double price, boolean imported, int quantity) {
             return new OtherProduct(name, price, imported, quantity);
     }

}
