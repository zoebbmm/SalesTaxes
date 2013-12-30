package shoppingInfo;

import static org.junit.Assert.*;
import org.junit.Test;
import Products.*;

public class StoreShelfTest {
	StoreShelf shelf = new StoreShelf();
	String name = "box of chocolates";
	double price = 45.00;
	boolean imported = true;
	int quantity = 2;

	@Test
	public void testStoreShelf() {
		assertEquals(6, shelf.getShelfSize());
	}

	@Test
	public void testAddProductsToShelf() {
		shelf.addProductsToShelf("cake", new FoodProduct());
		assertEquals(7, shelf.getShelfSize());
		FoodProductTest test = new FoodProductTest();
		test.testFoodProduct();
	}

	@Test
	public void testSearchAndRetrieveItemFromShelf() {
		Product product = shelf.searchAndRetrieveItemFromShelf(name, price, imported, quantity);
		assertEquals("box of chocolates", product.getName());
		assertEquals(90.00, product.getPrice(), 0.0009);
		assertEquals(true, product.isImported());
		assertEquals(2, product.getQuantity());
	}

}
