package furniturefactory.classes;

import java.util.List;

import furniturefactory.dataclasses.FurnitureID;
import furniturefactory.dataclasses.QualityRange;

import java.util.ArrayList;

/**
 * This abstract class is hold common implementations for the sub-classes and
 * leaves some of the method implementations for the sub-classes
 *
 * <ul>
 * <li><strong>id</strong> type: FurnitureID
 * <li><strong>materials</strong> type: List<Material>
 * <li><strong>quality</strong> type: int
 * <li><strong>profit</strong> type: int
 * <li><strong>profitMargin</strong> type: int
 * </ul>
 * 
 * @author Mustafa Fatih Can 280201007
 * @author Deniz Kaya 280201033
 * @author Hakan Uskan 280201076
 * @author Burak Erinc 290201099
 */

public abstract class Furniture {

	private FurnitureID id;
	private List<Material> materials;
	private int quality;
	private int profit;
	private int profitMargin;

	/**
	 * <strong>Parameterized Constructor</strong>
	 * <p>
	 * Constructs Furniture object with required data.
	 * 
	 * @param id
	 * @param materials
	 */
	protected Furniture(FurnitureID id, List<Material> materials) {
		this.setId(id);
		List<Material> temp = new ArrayList<>();
		for (Material material : materials) {
			temp.add(new Material(material));
		}
		this.materials = temp;
		this.quality = calculateQuality();
		this.profitMargin = getProfitMargin();
	}

	/**
	 * <strong>Copy Constructor</strong>
	 * <p>
	 * Constructs a new Furniture Object with another Furniture Object
	 * 
	 * @param furniture
	 */
	protected Furniture(Furniture furniture) {
		this.id = furniture.getId();
		this.quality = furniture.getQuality();
		this.profit = furniture.getProfit();
		this.profitMargin = furniture.getProfitMargin();
		this.materials = furniture.getMaterials();
	}

	/**
	 * Gets the profit margin.
	 * 
	 * @return int The profit margin of furniture.
	 */
	public abstract int getProfitMargin();

	/**
	 * Calculates and returns the cost of furniture.
	 * 
	 * @return int The cost of furniture.
	 */
	public int calculateCost() {
		int cost = 0;
		for (Material material : materials) {
			cost += material.getCost();
		}
		return cost;
	}

	/**
	 * Calculates the income from the furniture.
	 * 
	 * @return int The income from furniture.
	 */
	public int calculateIncome() {
		return (this.calculateCost() * this.profitMargin) / 100;
	}

	/**
	 * Calculates the quality of furniture with respect to it's materials.
	 * 
	 * @return int The quality of furniture.
	 */
	public int calculateQuality() {
		int totalQuality = 0;
		int totalVolume = 0;
		for (Material material : materials) {
			totalVolume += material.calculateVolume();
			totalQuality += material.getQuality() * material.calculateVolume();
		}
		if (totalVolume == 0)
			return -1;

		return totalQuality / totalVolume;
	}

	/**
	 * Gets the rate of furniture's quality rank.Returns null if it is not in range.
	 * 
	 * @return QualityRange The quality rank of furniture.
	 */
	public QualityRange getQualityRange() {
		if (this.quality < 92) {
			return QualityRange.BADQLT;
		} else if (this.quality < 94) {
			return QualityRange.NORMALQLT;
		} else if (this.quality < 96) {
			return QualityRange.GOODQLT;
		} else if (this.quality < 98) {
			return QualityRange.VERYGOODQLT;
		} else if (this.quality <= 100) {
			return QualityRange.PERFECTQLT;
		} else {
			return null;
		}
	}

	/**
	 * Gets the materials of furniture.
	 * 
	 * @return List<Material> The materials as list.
	 */
	public List<Material> getMaterials() {
		List<Material> returned = new ArrayList<>();
		for (Material material : this.materials) {
			returned.add(new Material(material));
		}

		return returned;
	}

	/**
	 * Gets the ID of furniture.
	 * 
	 * @return int The ID of furniture.
	 */
	public FurnitureID getId() {
		return id;
	}

	/**
	 * Sets the furniture's ID.
	 * 
	 * @param id The ID of furniture.
	 */
	public void setId(FurnitureID id) {
		this.id = id;
	}

	/**
	 * Gets the quality of furniture.
	 * 
	 * @return int The quality of furniture.
	 */
	public int getQuality() {
		return quality;
	}

	/**
	 * Gets the profit of furniture.
	 * 
	 * @return int The profit of furniture.
	 */
	public int getProfit() {
		return profit;
	}
}
