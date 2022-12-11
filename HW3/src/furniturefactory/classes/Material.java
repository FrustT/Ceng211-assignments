package furniturefactory.classes;

import java.util.Locale;

import furniturefactory.dataclasses.MaterialData;
import furniturefactory.dataclasses.MaterialID;

public class Material {

	private MaterialID ID;
	private int length;
	private int width;
	private int height;
	private int cost;
	private int quality;
	private boolean initialized = false;

	public Material() {
		this(null, 0, 0, 0, 0, 0);
	}

	public Material(MaterialID materialID, int length, int width, int height, int cost, int quality) {
		this.ID = materialID;
		this.length = length;
		this.width = width;
		this.height = height;
		this.cost = cost;
		this.quality = quality;
		this.initialized = true;
	}

	public Material(MaterialData data, int quality) {
		this(data.getID(), data.getLength(), data.getWidth(), data.getHeight(), data.getCost(), quality);
	}

	public Material(Material material) {
		this(material.getID(), material.getLength(), material.getWidth(), material.getHeight(), material.getCost(),
			 material.getQuality());
	}

	public int getQuality() {
		assert (initialized);
		return quality;
	}

	public void setQuality(int quality) {
		if (quality < 0)
			System.exit(0);
		this.quality = quality;
	}

	public MaterialID getID() {
		assert (initialized);
		return ID;
	}

	public void setID(String materialID) {
		this.ID = MaterialID.valueOf(materialID.toUpperCase(Locale.ROOT));
	}

	public int getLength() {
		assert (initialized);
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		assert (initialized);
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		assert (initialized);
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getCost() {
		assert (initialized);
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public int calculateVolume(){
		return length*height*width;
	}

	@Override
	public String toString() {
		return "Material ID: " + ID + " Material length: " + length + " Material width: " + width + " Material height: "
				+ height + " Material cost: " + cost + " Material quality: " + quality;
	}

}
