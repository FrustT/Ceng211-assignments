package dropshipping.classes;

import dropshipping.interfaces.SupplierInterface;

	/**
	 * This Class holds supplier's Product type objects
	 * <ul>
	 * <li><strong>products</strong> type : Product[]
	 * <li><strong>numberOfItems</strong> type : Integer
	 * </ul>
	 * @author  Mustafa Fatih Can 280201007
	 * @author  Deniz Kaya 280201033
	 * @author  Hakan Uskan 280201076
	 * @author  Burak Erinç 290201099
	 */
public class Supplier implements SupplierInterface {
    private Product[] products;
    private int numberOfItems ;

    /**
	 * <strong>Parameterized Constructor</strong><p>
	 * Constructs Supplier Object with Product[] array.
	 * @param Product[]
	 */
    public Supplier(Product[] _array){
        this.numberOfItems = _array.length;
        this.products = _array;      
    }
	
    public Product[] toArray() {
    	Product[] result = new Product[numberOfItems];
    	
    	for(int i = 0; i < numberOfItems; i++) {
    		result[i] =new Product(this.products[i]);
    	}
    	
        return result;
    }

}