package vehiclepricecalculator.classes;

import fileoperations.FileIO;

public class Initializer {
	
	private SalesRecord salesRecord;
	
	public Initializer() {
		this.salesRecord = new SalesRecord(FileIO.getAllSalesAsArrayList());
	}
	
	public SalesRecord getSalesRecord() {
		return salesRecord;
	}
	
}