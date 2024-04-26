package prob5_;

public class MyStackException extends Exception {
	static final long serialVersionUID = 1L;
	
	public MyStackException() {
		super("stack is empty");
	}
	
	public MyStackException(String message) {
		super(message);
	}
}
