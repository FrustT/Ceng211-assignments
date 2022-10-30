package dropshipping.classes;
public  class Display {
	
	private Initializer init;
	
	public Display(){
		this.init = new Initializer();
	}
	
	public  void executeQueries(){
		executeFirstQuery();
		executeSecondQuery();
		executeThirdQuery();
		executeFourthQuery();
		executeFifthQuery();	
	}
	
	private void executeFirstQuery(){
		Sales firstQuery = new Sales(SalesQuery.getMostProfitableSale(init.getSaleManager()));
		System.out.println(
		"1- Most profitable product among the three suppliers-)"+ firstQuery.toString()
		+" with profit of "+ firstQuery.getSaleProfit());
	}
	
	private void executeSecondQuery(){
		Sales secondQuery = new Sales(SalesQuery.getMostExpensiveSales(init.getSaleManager()));
		System.out.println(
		"2- The most expensive product in terms of sales price-)"+secondQuery.toString()
    	+" with sales price"+ secondQuery.getSalesPrice());
	}
	
	private void executeThirdQuery(){
		int[] thirdQuery = SalesQuery.getCustomerWhoPurchasedMost(init.getSaleManager(), init.getCustomerArray());
    	System.out.println(
		"3- The customer who purchases the most products among the suppliers-)"+ init.getCustomerArray()[thirdQuery[0]].toString()
		+"-> "+ thirdQuery[1]+" purchases");
	}
	
	private void executeFourthQuery(){
		float fourthQuery = SalesQuery.getTotalProfit(init.getSaleManager());
		System.out.println("4- Total profit made from all sales-)"+fourthQuery);
	}
	
	private void executeFifthQuery(){
		Sales fifthQuery = new Sales(SalesQuery.getMostExpensiveSales(init.getSaleManager()));
		System.out.println("5- The least-profit product of S1-)"+fifthQuery.toString()
		+"->"+ fifthQuery.getSaleProfit()+" TL profit");
	}
}
