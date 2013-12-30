/**
 * FoodProduct is an item belonging to the category 'Food' in the shopping store.
 *
 * @author WeiZhou
 */

package Products;

import ProductHelper.FoodProductHelper;
import TaxCalculation.*;

public class FoodProduct extends Product{
	public FoodProduct(){
		super();
	}

	/**
	 * Parameterized constructor to initialize the values of the <code>FoodProduct</code> attributes.
	 *
	 * @param name - the name of the food product
	 * @param price - the price of the food product
	 * @param imported - boolean value of whether the food product imported or not
	 * @param quantity - quantity of food product items
	 */        
	public FoodProduct(String name, double price, boolean imported, int quantity) {
		super(name, price, imported, quantity);

	}

	public FoodProductHelper getHelper() {
		return new FoodProductHelper();
	}

	public double getTaxValue(String region) {
		if(region == "Local"){
			return LocalTaxRate.FOOD_TAX.getTax();
		}else{
			return 0;
		}
	}
}
