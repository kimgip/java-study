package prob06;

public class Mul extends Calc {
	public Mul (int a, int b) {
		super(a, b);
	}
	
	public int calculate() {
		return super.getA() * super.getB();
	}
}
