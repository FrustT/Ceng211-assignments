package furniturefactory.dataclasses;

/**
 * Holds data about the materialIDs'
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinc 290201099
 */
public enum MaterialID {
	PL011("Plank011"), PL012("Plank012"), PL013("Plank013"), WB121("WoodenBoard121"), WB122("WoodenBoard122"),
	WB123("WoodenBoard123"), WB131("WoodenBoard131"), WB132("WoodenBoard132"), WP401("WoodenPlank401"),
	WP402("WoodenPlank402"), WP403("WoodenPlank403"), WP404("WoodenPlank404"), HD501("Handle501"), HD502("Handle502");

	private String name;

	public String getName() {
		return this.name;
	}

	MaterialID(String name) {
		this.name = name;
	}
}
