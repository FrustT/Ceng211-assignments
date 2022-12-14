package furniturefactory.dataclasses;

/**
 * Holds data about FurnitureID's
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinc 290201099
 */
public enum FurnitureID {

	TB1401("Obsidian"), TB1402("Pearl"), TB1501("Elegant"), TB1502("Walnut"), TB1503("Garden"), WD2201("Lavinia"),
	WD2202("Loki"), WD2203("Atlas"), SH5001("Corner"), SH5002("Harmony"), SH5003("Luna"), SH5101("Hittite");

	private final String name;

	public String getName() {
		return this.name;
	}

	FurnitureID(String name) {
		this.name = name;
	}

}
