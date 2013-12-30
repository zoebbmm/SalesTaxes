package ProductHelper;

import Products.*;


public class FoodProductHelper extends ProductHelper{
	public FoodProduct createProduct(String name, double price, boolean imported, int quantity) {
            return new FoodProduct(name, price, imported, quantity);
    }
}
