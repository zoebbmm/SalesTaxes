/**
 * The ShoppingStore deals with getting a sales order and placing in shopping cart and billing the items in the cart.
 * 
 * @author WeiZhou
 */

package shoppingInfo;

import java.util.Scanner;
import BillInfo.*;
import Products.Product;

public class ShoppingStore {
	/** The shooping cart holds the purchased items to be billed. */
	private ShoppingCart sc;

	/** The storeshelf contains the products of the store. */
	private StoreShelf ss;

	/** Implement tax calculation and generate receipt. */
	private GeneratePayment gp;

	/** Get user input of products. */
	private Scanner input;

	/** The regional province where sales tax and imported duty applied. */
	String region;

	public ShoppingStore() {
		region = "Local";
		sc = new ShoppingCart();
		ss = new StoreShelf();
		gp = new GeneratePayment(region);
		input = new Scanner(System.in);
	}

	/**
	 * Get the sales order list of product items from the customer.
	 *
	 * @return the sales order
	 */
	public void getSalesOrder() {
		do{
			String name = getProductName();
			double price = getProductPrice();
			boolean imported = isProductImported();
			int quantity = getQuantity();
			getOrderAndPlaceInCart(name, price, imported, quantity);
		}while(isAddAnotherProduct());
	}
	
	/**
	 * Ask the user to add another product.
	 */
	public boolean isAddAnotherProduct() {
		System.out.println("Do you want to add another Product?(Y/N)");

		while(!(input.hasNext())) {
			System.out.println("Invalid input. Enter (Y/N)");
			input.next();
		}

		char answer = input.next().charAt(0);
		boolean addAnotherProduct = parseAnswer(answer);
		input.nextLine();
		return addAnotherProduct;
	}

	/**
	 * Get the name of the product from the user.
	 */
	public String getProductName() {
		System.out.println("Please enter the product name:\n");
		return input.nextLine();
	}

	/**
	 * Gets the price of the product from the user.
	 */
	public double getProductPrice() {
		System.out.println("Enter the product price:\n");

		//validate user's input
		while(!input.hasNextDouble()) {        
			System.out.println("Invalid price. Please enter a number. ");
			input.next();
		}
		return input.nextDouble();
	}

	/**
	 * Check whether the product is imported or not.
	 */
	public boolean isProductImported() {
		System.out.println("Is this product imported or not?(Y/N)\n");

		//validate user's input
		while(!input.hasNext("Y") && !input.hasNext("y") && !input.hasNext("N") && !input.hasNext("n")) {
			System.out.println("Invalid input. Enter (Y/N)");
			input.next();
		}

		char answer = input.next().charAt(0);
		boolean imported = parseAnswer(answer);
		return imported;
	}
	
	/**
	 * Get user input and then check answer content. 
	 */
	public boolean parseAnswer(char value)
	{
		boolean flag = true;
		boolean res = false;

		while(flag){
			if(value == 'Y' || value == 'y'){
				res = true;
				flag = false;
			}else if(value == 'N' || value == 'n') {
				res = false;
				flag = false;
			}else {
				//String ans = " ";
				System.out.println("Invalid input. Please Enter (Y/N). ");
				while(!input.hasNext("Y") && !input.hasNext("y") && !input.hasNext("N") && !input.hasNext("n")) {
					System.out.println("Invalid input. Enter (Y/N)");
					input.next();
				}
				value = input.next().charAt(0);
			}
		}
		return res;
	}


	/**
	 * Get the number of product from user.
	 */
	public int getQuantity(){
		System.out.println("Please enter the quantity:\n");

		//validate user's input
		while(!(input.hasNextInt())){
			System.out.println("Invalid input. Please enter an integer. ");
			input.next();
		}
		return input.nextInt();
	}


	/**
	 * Get the order of product items and place it into the shopping cart.
	 *
	 * @param name - name of the product
	 * @param price - price of product
	 * @param imported - boolean value of whether imported or not
	 * @param quantity - quantity of product
	 */
	public void getOrderAndPlaceInCart(String name, double price, boolean imported, int quantity) {
		Product product = ss.searchAndRetrieveItemFromShelf(name, price, imported, quantity);
		sc.addItemToCart(product);
	}

	/**
	 * Performs billing operation of purchased items and generates receipt.
	 */
	public void checkOut(){
		gp.generateBill(sc);
		Receipt receipt = gp.getReceipt();
		gp.printReceipt(receipt);
	}
	
	public ShoppingCart getCart() {
		return sc;
	}

	public GeneratePayment getPayment(){
		return gp;
	}
}
