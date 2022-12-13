package furniturefactory.classes;

import java.util.List;

import furniturefactory.dataclasses.FurnitureID;
import furniturefactory.dataclasses.QualityRange;

import java.util.ArrayList;

public abstract class Furniture {

	private FurnitureID id;
	private List<Material> materials;
	private int quality;
	private int profit;
	private int profitMargin;

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

	protected Furniture(Furniture furniture) {
		this.id = furniture.getId();
		this.quality = furniture.getQuality();
		this.profit = furniture.getProfit();
		this.profitMargin = furniture.getProfitMargin();
		this.materials = furniture.getMaterials();
	}

	public abstract int getProfitMargin();

	public int calculateCost() {
		int cost = 0;
		for (Material material : materials) {
			cost += material.getCost();
		}
		return cost;
	}

	public int calculateIncome() {
		return (this.calculateCost() * this.profitMargin) / 100;
	}

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

	public List<Material> getMaterials() {
		List<Material> returned = new ArrayList<>();
		for (Material material : this.materials) {
			returned.add(new Material(material));
		}

		return returned;
	}

	public FurnitureID getId() {
		return id;
	}

	public void setId(FurnitureID id) {
		this.id = id;
	}

	public int getQuality() {
		return quality;
	}

	public int getProfit() {
		return profit;
	}
}
