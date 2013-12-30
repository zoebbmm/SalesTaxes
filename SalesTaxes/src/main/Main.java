/**
 * Main method to drive the whole program.
 * 
 * @author WeiZhou
 */
package main;

import shoppingInfo.*;

public class Main{
	public static void main(String[] args){
		ShoppingStore store = new ShoppingStore();
		store.getSalesOrder();
		store.checkOut();
	}
}
