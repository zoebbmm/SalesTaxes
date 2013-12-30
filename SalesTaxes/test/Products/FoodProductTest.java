package Products;

import static org.junit.Assert.*;

import org.junit.Test;

public class FoodProductTest {
	Product p;

	@Test
	public void testFoodProduct() {
		p = new FoodProduct();
		assertEquals("", p.getName());
		assertEquals(0.0, p.getPrice(), 0.0009);
		assertEquals(false, p.isImported());
		assertEquals(0, p.getQuantity());
		assertEquals(0.0, p.getTaxedCost(), 0.0009);
	}

	@Test
	public void testFoodProductParaConst() {
		p = new FoodProduct("a box of chocolates", 95.00, true, 3);
		assertEquals("a box of chocolates", p.getName());
		assertEquals(285.0, p.getPrice(), 0.0009);
		assertEquals(true, p.isImported());
		assertEquals(3, p.getQuantity());
	}

	@Test
	public void testGetTaxValue() {
		p = new FoodProduct("a box of chocolates", 95.00, true, 3);
		assertEquals(0.0, p.getTaxValue("Local"), 0.0009);
	}
}
