package marketshipment.interfaces;

public interface Box<T> extends Serial {
	
	public void add(T _element);
	
	public double getTotalVolume();
	
	public double getMaxVolume();
	
	public double getRevenue();
	
	public void putInContainer();
	
	public String getSerialNumber();
}
