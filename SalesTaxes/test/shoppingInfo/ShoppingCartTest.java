package shoppingInfo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import Products.*;

public class ShoppingCartTest {
	ShoppingCart cart;
	Product product; 

	/**
	 * Initialization
	 */
	@Before
	public void setUp() {
		cart = new ShoppingCart();
		product = new BookProduct();
	}

	@Test
	public void testAddItemToCart() {
		cart.addItemToCart(product);
		assertEquals(1, cart.getCartSize());
	}

	@Test
	public void testGetItemsFromCart() {
		cart.addItemToCart(product);
		assertEquals(product ,cart.getItemsFromCart().get(0));
		BookProductTest test = new BookProductTest();
		test.testBookProduct();
	}
}
