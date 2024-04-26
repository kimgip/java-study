package prob5_;

public class MyStack  {
	private int len;
	private int rsize;
	private String[] buffer;

	public MyStack(int i) {
		len = 0;
		if (i < 1) {
			rsize = 1;
		}
		rsize = i;
		buffer = new String[rsize];
	}
	
	public String push(String item) {
		if (len == rsize) {
			resize();
		}
		buffer[len] = item;
        len++;
        return item;
    }
	
	private void resize() {
		String[] temp = new String[buffer.length + rsize];
		for (int i = 0; i < buffer.length; i++) {
			temp[i] = buffer[i];
		}
		
		buffer = temp;
	}
	
	public String pop() throws MyStackException {
        if (len == 0) 
        	callException();
        String obj;
        obj = buffer[len - 1];
        buffer[len - 1] = null;
        len--;
        return obj;
    }
	
	private void callException() throws MyStackException {
		throw new MyStackException();
	}
	
	public boolean isEmpty() {
		if (len > 0) {
			return false;
		} else {
			return true;
		}
	}
}
