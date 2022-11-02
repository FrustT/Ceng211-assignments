package dropshipping.classes;
	/**
	 * This Class's responsibility is printing all the Queries returned from the <b>SalesQuery</b> Class
	 * <ul>
	 * <li><b>init</b> type:Initializer
	 * </ul>
	 * @author  Mustafa Fatih Can 280201007
	 * @author  Deniz Kaya 280201033
	 * @author  Hakan Uskan 280201076
	 * @author  Burak Erinç 290201099
	 */
public  class Display {
	
	private Initializer init;
	//This constant is being used for indenting lines with same spaces to build a printing style.
	static final String LINE_INDENT = " ";
	
	/**
	 * <strong>No Argument Constructor</strong><p>
	 * Constructs Display Object and initilizes a new initializer object for holding our data.
	 */
	public Display(){
		this.init = new Initializer();
	}
	
	/**
	 * A method that calls all the methods that print required data from the desired queries at once.
	 */
	public void executeQueries(){
		executeFirstQuery();
		executeSecondQuery();
		executeThirdQuery();
		executeFourthQuery();
		executeFifthQuery();	
	}
	
	private void executeFirstQuery(){
		Sales firstQuery = new Sales(SalesQuery.getMostProfitableSale(init.getSaleManager()));
		
		System.out.println(
		"1-Most profitable product among the three suppliers:\n"+LINE_INDENT+firstQuery.getSalesProduct()
		+" with profit of "+ firstQuery.getSaleProfit()+" TL\n");
		
	}
	
	private void executeSecondQuery(){
		Sales secondQuery = new Sales(SalesQuery.getMostExpensiveSales(init.getSaleManager()));
		
		System.out.println(
		"2-The most expensive product in terms of sales price:\n"+LINE_INDENT+secondQuery.getSalesProduct()
    	+" with sales price "+ secondQuery.getSalesPrice()+" TL\n");
	}
	
	private void executeThirdQuery(){
		int[] thirdQuery = SalesQuery.getCustomerWhoPurchasedMost(init.getSaleManager(), init.getCustomerArray());
		
    	System.out.println(
		"3-The customer who purchased the most products among the suppliers:\n"+LINE_INDENT+ init.getCustomerArray()[thirdQuery[0]]
		+"-> "+ thirdQuery[1]+" purchases\n");
	}
	
	private void executeFourthQuery(){
		int fourthQuery =  (int) SalesQuery.getTotalProfit(init.getSaleManager());
		
		System.out.println("4-Total profit made from all sales:\n"+LINE_INDENT+fourthQuery+" TL profit\n");
		
	}
	
	private void executeFifthQuery(){
		Sales fifthQuery = new Sales(SalesQuery.getLeastProfitSaleOfS1(init.getSaleManager()));
		
		System.out.println("5-The least-profit product of S1:\n"+LINE_INDENT+fifthQuery.getSalesProduct()
		+"-> "+ fifthQuery.getSaleProfit()+" TL profit");
	}
}
