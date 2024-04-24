package prob02;

public class Goods {
	private String name;
	private int price;
	private int countStock;
	public int i;
	
	public Goods(String name, int price, int countStock) {
		this.name = name;
		this.price = price;
		this.countStock = countStock;
		
	}
	
	public void printInfo() {
		System.out.printf("%s(가격: %d원)이 %d개 입고 되었습니다.\n", name, price, countStock);
	}

}
