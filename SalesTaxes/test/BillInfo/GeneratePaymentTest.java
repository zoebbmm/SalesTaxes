package BillInfo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import Products.*;
import shoppingInfo.*;

public class GeneratePaymentTest {
	BookProduct book;
	FoodProduct food;
	OtherProduct other;
	GeneratePayment pay;
	ShoppingCart cart;

	/** Initialization */
	@Before
	public void setUp() {
		cart = new ShoppingCart();
		book = new BookProduct("book", 40.00, true, 1);
		food = new FoodProduct("box of chocolates", 30.00, false, 1);
		other = new OtherProduct("bottle of perfume", 89.00, false, 1);
		cart.addItemToCart(book);
		cart.addItemToCart(food);
		cart.addItemToCart(other);
		pay = new GeneratePayment("Local");
	}

	@Test
	public void testGenerateBill() {
		pay.generateBill(cart);
		assertEquals(42.00, book.getTaxedCost(), 0.0009);
		assertEquals(30.00, food.getTaxedCost(), 0.0009);
		assertEquals(97.9, other.getTaxedCost(), 0.0009);
	}

	@Test
	public void testPrintReceipt() {
		pay.generateBill(cart);
		Receipt receipt = pay.getReceipt();
		pay.printReceipt(receipt);
	}
}
