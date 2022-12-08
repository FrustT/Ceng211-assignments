package furniturefactory.classes;

import java.util.Locale;

public abstract class Material {

	private MaterialID materialID;
	private int quality;
	private int length;
	private int width;
	private int height;
	private int cost;

	public Material() {
		//TODO
	}

	public Material(String _materialID, int _quality, int _length, int _width, int _height, int _cost) {
		this.materialID = MaterialID.valueOf(_materialID.toUpperCase(Locale.ROOT));
		this.length = _length;
		this.width = _width;
		this.height = _height;
		this.cost = _cost;
		this.quality = _quality;
	}

	public Material(Material _material) {
		this(_material.getMaterialID().toString(), _material.getQuality(), _material.getLength(), _material.getWidth(),
				_material.getHeight(), _material.getCost());
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int _quality) {
		if (quality < 0)
			System.exit(0);
		this.quality = _quality;
	}

	public MaterialID getMaterialID() {
		return materialID;
	}

	public void setMaterialID(String materialID) {
		this.materialID = MaterialID.valueOf(materialID.toUpperCase(Locale.ROOT));
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

}
