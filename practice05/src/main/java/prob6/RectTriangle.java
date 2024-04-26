package prob6;

public class RectTriangle extends Shape {
	
	public RectTriangle(double w, double h) {
		super(w, h);
	}

	@Override
	public double getArea() {
		return super.getHeight() * super.getWidth() * 0.5;
		
	}

	@Override
	public double getPerimeter() {
		return super.getHeight() + super.getWidth() + Math.sqrt(Math.pow(super.getHeight(), 2) + Math.pow(super.getWidth(), 2));
		
	}
	
	
}
