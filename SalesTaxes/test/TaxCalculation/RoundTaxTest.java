package TaxCalculation;

import static org.junit.Assert.*;
import org.junit.Test;

public class RoundTaxTest {
	@Test
	public void testRoundoff() {
		assertEquals(27.80, RoundTax.roundoff(27.82), 0.0009);
		assertEquals(27.85, RoundTax.roundoff(27.83), 0.0009);
		assertEquals(27.90, RoundTax.roundoff(27.875), 0.0009);
	}

	@Test
	public void testTruncate(){
		assertEquals(27.86, RoundTax.truncate(27.8565), 0);
		assertEquals(27.80, RoundTax.truncate(27.800006), 0);
	}
}
