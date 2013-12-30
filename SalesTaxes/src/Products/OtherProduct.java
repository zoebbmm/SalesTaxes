/**
 * OtherProduct is an item belonging to the category of all other kinds of products, which don't specifically pointed out, in the shopping store.
 *
 * @author WeiZhou
 */

package Products;

import ProductHelper.OtherProductHelper;
import TaxCalculation.LocalTaxRate;


public class OtherProduct extends Product {
	public OtherProduct() {
		super();
	}

	/**
	 * Parameterized constructor to initialize the values of the <code>MiscellaneousProduct</code> attributes.
	 *
	 * @param name - the name of the miscellaneous product
	 * @param price - the price of the miscellaneous product
	 * @param imported - boolean value of whether the miscellaneous product imported or not
	 * @param quantity - quantity of miscellaneous product items
	 */        
	public OtherProduct(String name, double price, boolean imported, int quantity) {
		super(name, price, imported, quantity);            
	}

	public OtherProductHelper getHelper() {            
		return new OtherProductHelper();
	}

	public double getTaxValue(String region) {
		if(region == "Local"){
			return LocalTaxRate.OTHER_TAX.getTax();
		}else{
			return 0;
		}
	}
}
