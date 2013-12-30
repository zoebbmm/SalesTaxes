/**
 * The Receipt is to print the detail information about the products purchased with their taxed cost, the total tax and total amount payable.
 * 
 * @author WeiZhou
 */

package BillInfo;

import java.util.ArrayList;

import Products.Product;

public class Receipt {
	private ArrayList<Product> productList;
	private double totalSalesTax;
	private double totalAmount;

	public Receipt(ArrayList<Product> product, double tax, double amount) {
		productList = product;
		totalSalesTax = tax;
		totalAmount = amount;
	}

	public ArrayList<Product> getProductList() {
		return productList;
	}
	
	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}

	public double getTotalSalesTax() {
		return totalSalesTax;
	}

	public void setTotalSalesTax(double totalSalesTax) {
		this.totalSalesTax = totalSalesTax;
	}

	public double getTotalAmount() {        
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getTotalNumberOfItems(){
		return productList.size();
	}

	public String toString() {
		String receipt = "";

		for(Product p: productList){
			receipt += (p.toString() + "\n");
		}
		receipt += "Sales Taxes: " + totalSalesTax + "\n";
		receipt += "Total: " + totalAmount + "\n";
		return receipt;
	}
}
