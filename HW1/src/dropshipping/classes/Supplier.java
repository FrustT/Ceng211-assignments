package dropshipping.classes;

import dropshipping.interfaces.SupplierInterface;

@SuppressWarnings("hiding")
public class Supplier implements SupplierInterface {

    private Product[] products;
    private int numberOfItems ;

    public Supplier(Product[] array){
        this.products = array;
        this.numberOfItems = array.length;

    }

    @SuppressWarnings("unchecked")//TBD
	public Product[] toArray() {
    	Product[] result = new Product[numberOfItems];
    	for(int i =0;i<numberOfItems;i++) {
    		result[i] =new Product(this.products[i]);
    	}
        return products;

    }

}