package prob5;

public class MyStack  {
	private int len;
	private StringArray currentItem;

	public MyStack(int i) {
		len = 0;
		currentItem = null;
	}
	
	public String push(String item) {
		currentItem = new StringArray(item, currentItem);
        len++;
        return item;
    }
	
	public String pop() throws MyStackException {
        if (len == 0) 
        	callException();
        String obj;
        obj = currentItem.getItem();
        currentItem = currentItem.getPre();
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
