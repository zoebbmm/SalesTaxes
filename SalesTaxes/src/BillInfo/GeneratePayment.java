/**
 * Perform billing of product items in the shopping cart and generate the receipt.
 * 
 * @author WeiZhou
 * 
 */

package BillInfo;
import java.util.ArrayList;

import shoppingInfo.*;
import TaxCalculation.*;
import Products.*;

public class GeneratePayment{
	private Bill bill;
	private Receipt receipt;
	private ArrayList<Product> productList;
	private String region;

	public GeneratePayment(String region) {
		this.region = region;
	}

	/**
	 * Generate the bill for all the product items in the shopping cart.
	 */
	public void generateBill(ShoppingCart cart) {
		//retrieve product list from the shoppingcart
		productList = cart.getItemsFromCart();

		for(Product p : productList) {
			bill = getBiller(region);

			//calculate the total tax of product including a regional tax rate and imported duty
			double productTax = bill.calculateTax(p.getPrice(), p.getTaxValue(region), p.isImported());

			//calculate the final price of the product with the total tax cost
			double taxedCost = bill.calculateTotalTaxedCost(p.getPrice(), productTax);
			p.setTaxedCost(taxedCost);
		}
	}


	/**
	 * Gets the biller object to perform billing operations.
	 *
	 * @param strategy - the regional strategy for tax calculations
	 * @return Biller
	 */
	public Bill getBiller(String region) {
		TaxCalculatorHelper helper = new TaxCalculatorHelper();
		TaxCalculator taxCal = helper.getTaxCalculator(region);
		return new Bill(taxCal);
	}

	/**
	 * Generates a new receipt for the products purchased with their taxes and net payable amount.
	 * 
	 * @return Receipt
	 */
	public Receipt getReceipt() {
		double totalTax = bill.calcTotalTax(productList);
		double totalAmount = bill.calcTotalAmount(productList);
		receipt = bill.createNewReceipt(productList, totalTax, totalAmount);
		return receipt;
	}

	/**
	 * Prints out the receipt
	 * 
	 * @param - the receipt to be printed
	 */
	public void printReceipt(Receipt receipt) {
		bill.generateReceipt(receipt);
	}
}