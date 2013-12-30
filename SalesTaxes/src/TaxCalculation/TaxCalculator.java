/**
 * The Interface TaxCalculator computes the total tax cost of a product.
 *
 * @author WeiZhou
 */

package TaxCalculation;

public interface TaxCalculator {
	public double calculateTax(double price, double taxRate, boolean imported);
}
