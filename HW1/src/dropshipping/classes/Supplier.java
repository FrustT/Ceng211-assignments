package dropshipping.classes;

import dropshipping.interfaces.SupplierInterface;

public class Supplier implements SupplierInterface {

    private Product[] products;
    private int numberOfItems ;

    public Supplier(Product[] array){
        this.products = array;
        this.numberOfItems = array.length;

    }

    public Product[] toArray() {
    	Product[] result = new Product[numberOfItems];
    	for(int i =0;i<numberOfItems;i++) {
    		result[i] =new Product(this.products[i]);
    	}
        return result;

    }

}