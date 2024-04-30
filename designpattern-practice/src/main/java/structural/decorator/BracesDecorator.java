package structural.decorator;

public class BracesDecorator extends Decorator {
	
	public BracesDecorator(Component component) {
		super(component);
	}

	@Override
	public String operation() {
		return "(" + component.operation()+")";
	}

}
