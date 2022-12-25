package marketshipment.interfaces;

import marketshipment.classes.ContainerCode;

public interface IContainer<T> extends Serial {
	
	public String getSerialNumber();
	
	public ContainerCode getContainerCode();
	
	public void ship();
	
	public void add(T _element);
	
	public double getRevenue();
}
