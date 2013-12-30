package Products;

import static org.junit.Assert.*;
import org.junit.Test;

public class MedicalProductTest {
	Product p;

	@Test
	public void testMedicalProduct() {
		p = new MedicalProduct();
		assertEquals("", p.getName());
		assertEquals(0.0, p.getPrice(), 0.0009);
		assertEquals(false, p.isImported());
		assertEquals(0, p.getQuantity());
		assertEquals(0.0, p.getTaxedCost(), 0.0009);
	}

	@Test
	public void testMedicalProductParaConst() {
		p = new MedicalProduct("a packet of headache pills", 95.00, true, 3);
		assertEquals("a packet of headache pills", p.getName());
		assertEquals(285.0, p.getPrice(), 0.0009);
		assertEquals(true, p.isImported());
		assertEquals(3, p.getQuantity());
	}

	@Test
	public void testGetTaxValue() {
		p = new MedicalProduct("a packet of headache pills", 95.00, true, 3);
		assertEquals(0.0, p.getTaxValue("Local"), 0.0009);
	}
}
