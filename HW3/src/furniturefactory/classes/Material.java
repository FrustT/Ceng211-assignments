package furniturefactory.classes;

import java.util.Locale;

public class Material {

	private MaterialID ID;
	private int quality;
	private int length;
	private int width;
	private int height;
	private int cost;

	public Material() {
		//TODO
	}

	public Material(MaterialID _materialID, int _length, int _width, int _height, int _cost , int _quality) {
		this.ID = _materialID;
		this.length = _length;
		this.width = _width;
		this.height = _height;
		this.cost = _cost;
		this.quality = _quality;
	}
	
	public Material(MaterialData data,int _quality){
		this(data.getID(), data.getLength(), data.getWidth(), data.getHeight(), data.getCost(), _quality);
	}
	
	public Material(Material _material) {
		this(_material.getID(), _material.getLength(), _material.getWidth(),
			 _material.getHeight(), _material.getCost(),_material.getQuality());
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int _quality) {
		if (quality < 0)
			System.exit(0);
		this.quality = _quality;
	}

	public MaterialID getID() {
		return ID;
	}

	public void setID(String materialID) {
		this.ID = MaterialID.valueOf(materialID.toUpperCase(Locale.ROOT));
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return "Material ID: " + ID + " Material length: " + length + " Material width: " + width +
			  " Material height: " + height + " Material cost: " + cost + " Material quality: " + quality;
	}

}
