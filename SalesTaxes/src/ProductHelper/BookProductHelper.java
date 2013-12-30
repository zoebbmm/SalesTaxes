package ProductHelper;
import Products.*;

public class BookProductHelper extends ProductHelper{
	public BookProduct createProduct(String name, double price, boolean imported, int quantity) {
                    return new BookProduct(name, price, imported, quantity);
    }
}
