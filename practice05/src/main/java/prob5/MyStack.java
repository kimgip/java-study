package prob5;

public class MyStack  {
	private int index;
	private StringArray currentItem;

	public MyStack(int i) {
		index = 0;
		currentItem = null;
	}
	
	public String push(String item) {
		currentItem = new StringArray(item, currentItem);
        index++;
        return item;
    }
	
	public String pop() throws MyStackException {
        if (!isEmpty()) 
        	throw new MyStackException();
        String obj;
        obj = currentItem.getItem();
        currentItem = currentItem.getPre();
        index--;
        return obj;
    }
	
	public boolean isEmpty() {
		return index == 0;
	}
}
