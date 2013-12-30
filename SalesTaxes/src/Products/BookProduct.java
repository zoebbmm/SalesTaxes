/**
 * BookProduct is an item belonging to the category 'Book' in the shopping store.
 *
 * @author WeiZhou
 * 
 */

package Products;
import ProductHelper.*;
import TaxCalculation.*;

public class BookProduct extends Product{
	public BookProduct(){
		super();
	}

	/**
	 * Parameterized constructor to initialize the values of the <code>BookProduct</code> attributes.
	 *
	 * @param name - the name of the book product
	 * @param price - the price of the book product
	 * @param imported - represent whether the book product is imported or not
	 * @param quantity - the number of book product items
	 */        
	public BookProduct(String name, double price, boolean imported, int quantity){
		super(name, price, imported, quantity);

	}

	public BookProductHelper getHelper() {
		return new BookProductHelper();
	}
	
	public double getTaxValue(String region) {                
		if(region == "Local"){
			return LocalTaxRate.BOOK_TAX.getTax();
		}else{
			return 0;
		}
	}
}
