package prob06;

public class Sub extends Calc {
	public Sub(int a, int b) {
		super(a, b);
	}

	
	public int calculate() {
		return super.getA() - super.getB();
	}
}
