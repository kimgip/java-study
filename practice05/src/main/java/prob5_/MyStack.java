package prob5_;

public class MyStack  {
	private int index;
	private String[] buffer;

	public MyStack(int i) {
		index = -1;
		buffer = new String[i];
	}
	
	public String push(String item) {
		if (index == buffer.length - 1) {
			resize();
		}
		buffer[++index] = item;
        return item;
    }
	
	private void resize() {
		String[] temp = new String[buffer.length * 2];
		for (int i = 0; i < buffer.length; i++) {
			temp[i] = buffer[i];
		}
		
		buffer = temp;
	}
	
	public String pop() throws MyStackException {
        if (index == 0) 
        	throw new MyStackException();
        String obj;
        obj = buffer[index];
        buffer[index--] = null;
        return obj;
    }
	
	public boolean isEmpty() {
		return index == 0;
	}
}
