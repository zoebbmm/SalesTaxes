/**
 * MedicalProduct is an item belonging to the category of 'Medical' in the shopping store.
 *
 * @author WeiZhou
 */

package Products;

import ProductHelper.MedicalProductHelper;
import TaxCalculation.LocalTaxRate;

public class MedicalProduct extends Product {
	public MedicalProduct(){
		super();
	}

	/**
	 * Parameterized constructor to initialize the values of the <code>MedicalProduct</code> attributes.
	 *
	 * @param name - the name of the medical product
	 * @param price - the price of the medical product
	 * @param imported - boolean value of whether the medical product imported or not
	 * @param quantity - quantity of medical product items
	 */        
	public MedicalProduct(String name, double price, boolean imported, int quantity) {
		super(name, price, imported, quantity);
	}

	public MedicalProductHelper getHelper(){
		return new MedicalProductHelper();
	}

	public double getTaxValue(String region) {
		if(region == "Local"){
			return LocalTaxRate.MEDICAL_TAX.getTax();
		}else{
			return 0;
		}
	}
}
