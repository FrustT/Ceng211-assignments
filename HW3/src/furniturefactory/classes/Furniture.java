package furniturefactory.classes;

import java.util.List;

import furniturefactory.dataclasses.FurnitureID;

import java.util.ArrayList;

public abstract class Furniture {

	private FurnitureID id;
	private List<Material> materials;
	private int quality;
	private int profit;
	private float profitMargin;

	protected Furniture(FurnitureID id, List<Material> materials) {
		this.setId(id);
		List<Material> temp = new ArrayList<>();
		for (Material material : materials) {
			temp.add(new Material(material));
		}
		this.materials = temp;
		this.quality = calculateQuality();
	}

	protected Furniture(Furniture furniture) {
		this.id = furniture.getId();
		this.quality = furniture.getQuality();
		this.profit = furniture.getProfit();
		this.profitMargin = furniture.initializeProfitMargin();
		this.materials = furniture.getMaterials();
	}

	public abstract float initializeProfitMargin();

	public float calculateCost() {
		float cost = 0;
		for (Material material : materials) {
			cost += material.getCost();
		}
		return cost;
	}

	public float calculateIncome() {
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

	public String getQualityRange() {
		if (this.quality < 92) {
			return "Bad Qlt";
		} else if (this.quality < 94) {
			return "Normal Qlt";
		} else if (this.quality < 96) {
			return "Good Qlt";
		} else if (this.quality < 98) {
			return "Very Good Qlt";
		} else if (this.quality <= 100) {
			return "Perfect Qlt";
		} else {
			return "Quality is not in the interval";
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
