package furniturefactory.classes;

public class Data {

	private MaterialID ID;
	

	private int length;
	private int width;
	private int height;
	private int cost;
	
	public Data(MaterialID ID ,int length, int width, int height, int cost){
		this.ID = ID;
		this.length = length;
		this.width = width;
		this.height = height;
		this.cost = cost;
	}
	public MaterialID getID() {
		return ID;
	}

	public int getLength() {
		return length;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getCost() {
		return cost;
	}
}
