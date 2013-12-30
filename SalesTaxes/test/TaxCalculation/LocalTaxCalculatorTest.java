package TaxCalculation;

import static org.junit.Assert.*;
import org.junit.Test;

public class LocalTaxCalculatorTest {
	TaxCalculator taxcal = new LocalTaxCalculator();

	@Test
	public void testCalculateTax() {
		assertEquals(7.15, taxcal.calculateTax(47.50, 0.10, true), 0);
		assertEquals(0.50, taxcal.calculateTax(10.00, 0, true), 0);
		assertEquals(1.50, taxcal.calculateTax(14.99, 0.10, false),0);
	}
}
