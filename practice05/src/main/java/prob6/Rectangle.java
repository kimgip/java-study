package prob6;

public class Rectangle extends Shape implements Resizable {
	public Rectangle(double w, double h) {
		super(w, h);
	}

	@Override
	public double getArea() {
		return super.getHeight() * super.getWidth();
	}

	@Override
	public double getPerimeter() {
		return (super.getHeight() + super.getWidth()) * 2;
		
	}
	
	@Override
	public void resize(double s) {
		super.setHeight(super.getHeight() * s);
		super.setWidth(super.getWidth() * s);
	}
}
