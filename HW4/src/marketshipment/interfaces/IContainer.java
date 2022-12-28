package marketshipment.interfaces;

import marketshipment.classes.ContainerCode;

public interface IContainer<T extends Serial> extends Serial, Holder<T> {
	
	public ContainerCode getContainerCode();
	
	public void ship();
	
	public double getTotalRevenue();
	
	public boolean isShipped();
}
