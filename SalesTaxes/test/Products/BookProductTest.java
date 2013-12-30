package Products;

import static org.junit.Assert.*;
import org.junit.Test;

public class BookProductTest {
	Product p;

	@Test
	public void testBookProduct() {
		p = new BookProduct();
		assertEquals("", p.getName());
		assertEquals(0.0, p.getPrice(), 0.0009);
		assertEquals(false, p.isImported());
		assertEquals(0, p.getQuantity());
		assertEquals(0.0, p.getTaxedCost(), 0.0009);
	}

	@Test
	public void testBookProductWithParameters() {
		p = new BookProduct("book", 95.00, true, 3);
		assertEquals("book", p.getName());
		assertEquals(285.0, p.getPrice(), 0.0009);
		assertEquals(true, p.isImported());
		assertEquals(3, p.getQuantity());
	}

	@Test
	public void testGetTaxValue() {
		p = new BookProduct("book", 95.00, true, 3);
		assertEquals(0.0, p.getTaxValue("Local"), 0.0009);
	}
}
