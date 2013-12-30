package shoppingInfo;

import static org.junit.Assert.*;
import org.junit.Test;

public class ShoppingStoreTest {
	ShoppingStore store = new ShoppingStore();

	@Test
	public void testGetProductName() {
		assertEquals("book",store.getProductName());
	}

	@Test
	public void testGetProductPrice() {
		assertEquals(40.00, store.getProductPrice(), 0.0009);
	}

	@Test
	public void testIsProductImported() {
		assertEquals(true, store.isProductImported());
	}

	@Test
	public void testGetQuantity() {
		assertEquals(4, store.getQuantity());
	}
	
	@Test
	public void testParseAnswer() {
		assertEquals(true, store.parseAnswer('Y'));
	}

	@Test
	public void testIsAddAnotherProduct() {
		assertEquals(false, store.isAddAnotherProduct());
	}
	
	@Test
	public void testGetOrderAndPlaceInCart() {
		String name = "box of chocolates";
		double price = 45.00;
		boolean imported = true;
		int quantity = 2;
		store.getOrderAndPlaceInCart(name, price, imported, quantity);
		assertEquals(1, store.getCart().getCartSize());
	}	
}
