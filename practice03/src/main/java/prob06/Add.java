package prob06;

public class Add extends Calc{
	public Add(int a, int b) {
		super(a, b);
	}
	
	public int calculate() {
		return super.getA() + super.getB();
	}
}
