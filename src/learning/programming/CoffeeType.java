package learning.programming;

public enum CoffeeType {
	ESPRESSO(250,0,16,1,4),
	LATTE(350,75,20,1,7),
	CAPPUCCINO(200,100,12,1,6);

	private final int milk;
	private final int water;
	private final int beans;
	private final int cups;
	private final int price;

	CoffeeType(int water,int milk, int beans, int cups, int price) {
		this.milk = milk;
		this.water = water;
		this.beans = beans;
		this.cups = cups;
		this.price = price;
	}

	public int getMilk() {
		return milk;
	}

	public int getWater() {
		return water;
	}

	public int getBeans() {
		return beans;
	}

	public int getCups() {
		return cups;
	}

	public int getPrice() {
		return price;
	}
}
