package marketshipment.interfaces;

import java.util.List;

public interface Holder<T extends Serial> {//TODO what about Container for naming ?
	
	
	public void add(T _element);
	
	public List<T> getContents();

	public int getIndexOf(T _element);
	
	public int getIndexOfWithSerial(String s);
}
