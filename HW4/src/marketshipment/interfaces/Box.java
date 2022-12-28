package marketshipment.interfaces;

public interface Box<T extends Serial> extends Serial, Holder<T> {
	
	
	public double getRevenue();
	
	public double getTotalVolume();

	public double getMaxVolume();

	public void putInContainer();

	public boolean isInContainer();
}
