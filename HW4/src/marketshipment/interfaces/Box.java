package marketshipment.interfaces;

public interface Box<T extends Serial> extends Serial, Holder<T> {
	
	public double getTotalVolume();
	
	public double getMaxVolume();
	
	public double getRevenue();
	
	public void putInContainer();
	
	public String getSerialNumber();
	
	public boolean getIsInContainer();
}
