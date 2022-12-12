package furniturefactory.dataclasses;

public enum FurnitureID {
	
	TB1401("Obsidian"), TB1402("Pearl"), TB1501("Elegant"), TB1502("Walnut"), TB1503("Garden"), WD2201("Lavinia"), WD2202("Loki"), WD2203("Atlas"), SH5001("Corner"), SH5002("Harmony"), SH5003("Luna"), SH5101("Hittite");
	private final String name;
	public String getName(){return this.name;}
	FurnitureID(String name){this.name = name;}
	
}
