package vehiclepricecalculator.classes;

import fileoperations.FileIO;

	/**
	 * Initializes needed sales record class and returning.
	 * <ul>
	 * <li><strong>salesRecord</strong> type: SalesRecord
	 * </ul>
	 * @author  Mustafa Fatih Can 280201007
	 * @author  Deniz Kaya 280201033
	 * @author  Hakan Uskan 280201076
	 * @author  Burak Erinç 290201099
	 */
public class Initializer {
	
	private SalesRecord salesRecord;
	
	/**
	 * <strong>No Argument Constructor</strong><p>
	 * Creates an initializer object and initializes salesRecord from the static method of FileIO.
	 */
	public Initializer() {
		this.salesRecord = new SalesRecord(FileIO.getAllSalesAsArrayList());
	}
	
	public SalesRecord getSalesRecord() {
		return salesRecord;
	}
	
}