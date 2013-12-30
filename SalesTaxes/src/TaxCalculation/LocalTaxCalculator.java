/**
 * The LocalTaxCalculator calculates the total tax cost of the local products.
 * 
 * @author WeiZhou
 */

package TaxCalculation;

public class LocalTaxCalculator implements TaxCalculator {
	public double calculateTax(double price, double localTax, boolean imported) {
		double tax = price * localTax;
		
		if(imported == true){
			tax += (price * 0.05);
		}

		//round up to the nearest 0.05 
		tax = RoundTax.roundoff(tax);
		return tax;
	}
}
