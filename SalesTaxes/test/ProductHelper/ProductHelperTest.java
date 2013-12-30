package ProductHelper;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProductHelperTest {
	ProductHelper helper;
	String name = "productA";
	double price = 45.00;
	boolean imported = true;
	int quantity = 2;

	@Test
	public void testCreateBookProduct() {
		helper = new BookProductHelper();
		helper.createProduct(name, price, imported, quantity);
	}

	@Test
	public void testCreateFoodProduct() {
		helper = new FoodProductHelper();
		helper.createProduct(name, price, imported, quantity);
	}

	@Test
	public void testCreateMedicalProduct() {
		helper = new MedicalProductHelper();
		helper.createProduct(name, price, imported, quantity);
	}

	@Test
	public void testCreateOtherProduct() {
		helper = new OtherProductHelper();
		helper.createProduct(name, price, imported, quantity);
	}
}
