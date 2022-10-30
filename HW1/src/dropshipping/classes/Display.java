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
		"1-Most profitable product among the three suppliers:\n     "+ firstQuery.getSalesProduct()
		+" with profit of "+ firstQuery.getSaleProfit()+" TL\n");
		
	}
	
	private void executeSecondQuery(){
		Sales secondQuery = new Sales(SalesQuery.getMostExpensiveSales(init.getSaleManager()));
		
		System.out.println(
		"2-The most expensive product in terms of sales price:\n     "+secondQuery.getSalesProduct()
    	+" with sales price "+ secondQuery.getSalesPrice()+" TL\n");
	}
	
	private void executeThirdQuery(){
		int[] thirdQuery = SalesQuery.getCustomerWhoPurchasedMost(init.getSaleManager(), init.getCustomerArray());
		
    	System.out.println(
		"3-The customer who purchased the most products among the suppliers:\n     "+ init.getCustomerArray()[thirdQuery[0]]
		+"-> "+ thirdQuery[1]+" purchases\n");
	}
	
	private void executeFourthQuery(){
		int fourthQuery =  (int) SalesQuery.getTotalProfit(init.getSaleManager());
		
		System.out.println("4-Total profit made from all sales:\n     "+fourthQuery+" TL profit\n");
		
	}
	
	private void executeFifthQuery(){
		Sales fifthQuery = new Sales(SalesQuery.getLeastProfitSaleOfS1(init.getSaleManager()));
		
		System.out.println("5-The least-profit product of S1:\n     "+fifthQuery.getSalesProduct()
		+"-> "+ fifthQuery.getSaleProfit()+" TL profit");
	}
}
