/**
 * The Bill calculates the product's taxed cost, the total tax value, and total amount of all products.
 * 
 * @author WeiZhou
 */

package BillInfo;

import java.util.ArrayList;
import Products.Product;
import TaxCalculation.*;

public class Bill {
	TaxCalculator taxCalculator;

	/**
	 * Instantiates a new biller.
	 *
	 * @param taxCalc - the tax calculator
	 */
	public Bill(TaxCalculator taxCalc) {
		taxCalculator = taxCalc;
	}

	/**
	 * Calculate the total product tax using tax calculator.
	 */
	public double calculateTax(double price, double taxRate, boolean imported) {
		double totalProductTax = taxCalculator.calculateTax(price, taxRate, imported);
		return totalProductTax;
	}

	/**
	 * Calculate the taxed cost of the product which is the sum of the original price and tax value.
	 */
	public double calculateTotalTaxedCost(double price, double tax){
		return RoundTax.truncate(price + tax);
	}

	/**
	 * Calculate the total tax value of all products.
	 */
	public double calcTotalTax(ArrayList<Product> prodList){
		double totalTax = 0.0;

		//Calculate the tax value which is the difference between the taxed cost and original cost.
		for(Product p : prodList) {
			totalTax += (p.getTaxedCost() - p.getPrice());
		}
		return RoundTax.truncate(totalTax);
	}

	/**
	 * Computes the net amount of all the products.
	 */
	public double calcTotalAmount(ArrayList<Product> prodList) {
		double totalAmount = 0.0;

		//Get the total cost of all products.
		for(Product p : prodList) {
			totalAmount += p.getTaxedCost();
		}
		return RoundTax.truncate(totalAmount);
	}

	/**
	 * Create a new Receipt object.
	 * 
	 * @param productList - the product list being purchased
	 * @param totalTax - the tax cost
	 * @param totalAmount - the payable amount
	 * @return Receipt
	 */
	public Receipt createNewReceipt(ArrayList<Product> productList, double totalTax, double totalAmount) {
		return new Receipt(productList, totalTax, totalAmount);
	}

	/**
	 * Print out the receipt.
	 */
	public void generateReceipt(Receipt r){
		String receipt = r.toString();
		System.out.println(receipt);
	}

}
