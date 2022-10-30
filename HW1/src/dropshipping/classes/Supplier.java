package dropshipping.classes;

import dropshipping.interfaces.SupplierInterface;

public class Supplier implements SupplierInterface {

    private Product[] products;
    private int numberOfItems ;

    public Supplier(Product[] _array){
        this.numberOfItems = _array.length;
        this.products = _array;      
    }

    public Product[] toArray() {
    	Product[] result = new Product[numberOfItems];
    	for(int i =0;i<numberOfItems;i++) {
    		result[i] =new Product(this.products[i]);
    	}
        return result;

    }

}