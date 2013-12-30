package ProductHelper;
import Products.MedicalProduct;

public class MedicalProductHelper extends ProductHelper{
	public MedicalProduct createProduct(String name, double price, boolean imported, int quantity) {
		return new MedicalProduct(name, price, imported, quantity);
	}
}
