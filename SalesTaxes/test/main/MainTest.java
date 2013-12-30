package main;

import static org.junit.Assert.*;

import org.junit.Test;
import shoppingInfo.*;

public class MainTest {
	ShoppingStore store = new ShoppingStore();

	/** Test case for non imported products */
	@Test
	public void testNonImportedProducts() {
		store.getOrderAndPlaceInCart("book", 12.49, false, 1);
		store.getOrderAndPlaceInCart("music CD", 14.99, false, 1);
		store.getOrderAndPlaceInCart("chocolate bar", 0.85, false, 1);
		assertNotNull("Shopping cart cannot be null as there are products in it", store.getCart());
		assertEquals("number of products in shopping cart", 3, store.getCart().getCartSize());
		store.getPayment().generateBill(store.getCart());
		assertEquals("Total sales tax for all products.  Products are all not imported ", 1.50, store.getPayment().getReceipt().getTotalSalesTax() , 0);
		assertEquals("Total amount payment for all products", 29.83, store.getPayment().getReceipt().getTotalAmount(), 0);
	}

	/** Test case only for imported products */
	@Test
	public void testImportedProducts() {
		store.getOrderAndPlaceInCart("box of chocolates", 10, true, 1);
		store.getOrderAndPlaceInCart("bottle of perfume", 47.50, true, 1);
		assertNotNull("Shopping cart cannot be null as there are products in it", store.getCart());
		assertEquals("number of products in shopping cart", 2, store.getCart().getCartSize());
		store.getPayment().generateBill(store.getCart());
		assertEquals("Total tax for all products(i.e) sales tax and imported duty", 7.65, store.getPayment().getReceipt().getTotalSalesTax() , 0);
		assertEquals("Total amount payable for all products", 65.15, store.getPayment().getReceipt().getTotalAmount(), 0);
	}

	/** Test case for both imported and non imported products */
	@Test
	public void testGeneralCase() {
		store.getOrderAndPlaceInCart("bottle of perfume", 27.99, true, 1);
		store.getOrderAndPlaceInCart("bottle of perfume", 18.99, false, 1);
		store.getOrderAndPlaceInCart("packet of headache pills", 9.75, false, 1);
		store.getOrderAndPlaceInCart("box of chocolates", 11.25, true, 1);
		assertNotNull("Shopping cart cannot be null as there are products in it", store.getCart());
		assertEquals("number of products in shopping cart", 4, store.getCart().getCartSize());
		store.getPayment().generateBill(store.getCart());
		assertEquals("Total tax for all products(i.e) sales tax and imported duty", 6.65, store.getPayment().getReceipt().getTotalSalesTax() , 0);
		assertEquals("Total amount payable for all products", 74.63, store.getPayment().getReceipt().getTotalAmount(), 0);
	}

	/** Test case for tax exempt items which are non-imported */
	@Test
	public void testTaxExemptNonImportedProducts() {
		store.getOrderAndPlaceInCart("book", 12.49, false, 1);
		store.getOrderAndPlaceInCart("chocolate bar", 10, false, 1);
		store.getOrderAndPlaceInCart("packet of headache pills", 5.45, false, 1);
		assertNotNull("Shopping cart cannot be null as there are products in it", store.getCart());
		assertEquals("number of products in shopping cart", 3, store.getCart().getCartSize());
		store.getPayment().generateBill(store.getCart());
		assertEquals("books, chocolates and pills belong to books, food and medical category respectively. So sales tax is exempted. As all products are not imported.", 0, store.getPayment().getReceipt().getTotalSalesTax() , 0);
		assertEquals("Total amount payable for all products", 27.94, store.getPayment().getReceipt().getTotalAmount(), 0);
	}

	/** Test case for tax exempt items which are imported */
	@Test
	public void testTaxExemptImportedProducts() {
		store.getOrderAndPlaceInCart("book", 12.49, true, 1);
		store.getOrderAndPlaceInCart("chocolate bar", 10, true, 1);
		store.getOrderAndPlaceInCart("packet of headache pills", 9.75, true, 1);
		assertNotNull("Shopping cart cannot be null as there are products in it", store.getCart());
		assertEquals("number of products in shopping cart", 3, store.getCart().getCartSize());
		store.getPayment().generateBill(store.getCart());
		assertEquals("books, chocolates and pills belong to books, food and medical category respectively. So sales tax is exempted. As all products are imported, so import duty must be added for all ", 1.60, store.getPayment().getReceipt().getTotalSalesTax() , 0);
		assertEquals("Total amount payable for all products", 33.84, store.getPayment().getReceipt().getTotalAmount(), 0);
	}

	/** Test case for taxable products which are not imported */
	@Test
	public void testTaxableNonImportedProducts() {
		store.getOrderAndPlaceInCart("music CD", 14.99, false, 1);
		store.getOrderAndPlaceInCart("bottle of perfume", 47.50, false, 1);
		assertNotNull("Shopping cart cannot be null as there are products in it", store.getCart());
		assertEquals("number of products in shopping cart", 2, store.getCart().getCartSize());
		store.getPayment().generateBill(store.getCart());
		assertEquals("products don't belong to food,books and medical category respectively, so sales tax must be added. As all products are not imported,  so no import duty is added", 6.25, store.getPayment().getReceipt().getTotalSalesTax() , 0);
		assertEquals("Total amount payable for all products", 68.74, store.getPayment().getReceipt().getTotalAmount(), 0);
	}

	/** Test case for taxable items which are imported */
	@Test
	public void testTaxableImportedProducts() {
		store.getOrderAndPlaceInCart("music CD", 14.99, true, 1);
		store.getOrderAndPlaceInCart("bottle of perfume", 47.50, true, 1);
		assertNotNull("Shopping cart cannot be null as there are products in it", store.getCart());
		assertEquals("number of products in shopping cart", 2, store.getCart().getCartSize());
		store.getPayment().generateBill(store.getCart());
		assertEquals("products don't belong to food,books and medical category respectively, so sales tax must be added. As all products are imported, so import duty is added", 9.40, store.getPayment().getReceipt().getTotalSalesTax() , 0);
		assertEquals("Total amount payable for all products", 71.89, store.getPayment().getReceipt().getTotalAmount(), 0);
	}
}
