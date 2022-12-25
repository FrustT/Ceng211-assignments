package marketshipment.interfaces;

import marketshipment.classes.ItemCode;

public interface Item extends Serial {

	public double getCost();
	
	public double getPrice();
	
	public double getRevenue();
	
	public double getVolume();
	
	public String getSerialNumber();
	
	public ItemCode getItemCode();
}
