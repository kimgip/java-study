package prob06;

public class Div extends Calc {
	public Div(int a, int b) {
		super(a, b);
	}
	
	public int calculate() {
		return super.getA() / super.getB();
	}
}
