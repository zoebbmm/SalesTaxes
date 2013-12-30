package Products;

import static org.junit.Assert.*;
import org.junit.Test;

public class OtherProductTest {
	Product p;
	
	@Test
	public void testOtherProduct() {
		p = new OtherProduct();
		assertEquals("", p.getName());
		assertEquals(0.0, p.getPrice(), 0.0009);
		assertEquals(false, p.isImported());
		assertEquals(0, p.getQuantity());
		assertEquals(0.0, p.getTaxedCost(), 0.0009);
	}

	@Test
	public void testOtherProductStringDoubleBooleanInt() {
		p = new OtherProduct("a bottle of perfume", 95.00, true, 3);
		assertEquals("a bottle of perfume", p.getName());
		assertEquals(285.0, p.getPrice(), 0.0009);
		assertEquals(true, p.isImported());
		assertEquals(3, p.getQuantity());
	}

	@Test
	public void testGetTaxValue() {
		p = new OtherProduct("a bottle of perfume", 95.00, true, 3);
		assertEquals(0.10, p.getTaxValue("Local"), 0.0009);
	}
}
