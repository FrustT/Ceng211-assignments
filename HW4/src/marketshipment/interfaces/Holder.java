package marketshipment.interfaces;

import java.util.List;

import marketshipment.exceptions.CannotBeAddedToHolderException;

public interface Holder<T extends Serial> extends Serial{
	
	
	public void add(T _element) throws CannotBeAddedToHolderException;
	
	public List<T> getContents();

	public int getIndexOf(T _element);
	
	public int getIndexOfWithSerial(String s);
	
	public double getTotalPrice();
	
	public double getTotalCost();
	
}
