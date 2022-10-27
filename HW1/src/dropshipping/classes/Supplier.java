package dropshipping.classes;

import dropshipping.interfaces.SupplierInterface;

@SuppressWarnings("hiding")
public class Supplier<Product> implements SupplierInterface<Product> {

    private Product[] products;
    private int numberOfItems ;

    public Supplier(Product[] array){
        this.products = array;
        this.numberOfItems = array.length;

    }

    @SuppressWarnings("unchecked")//TBD
	public Product[] toArray() {
    	Product[] result = (Product[]) new Object[numberOfItems];
    	for(int i =0;i<numberOfItems;i++) {
    		result[i] =new Product((Product) this.products[i]);
    	}
        return products;

    }

}