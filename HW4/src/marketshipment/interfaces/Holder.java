package marketshipment.interfaces;

import java.util.List;

public interface Holder<T extends Serial> {
	
	
	public void add(T _element) throws Exception;
	
	public List<T> getContents();

	public int getIndexOf(T _element);
	
	public int getIndexOfWithSerial(String s);
	
	public int getPriceOfItems();
	
}
