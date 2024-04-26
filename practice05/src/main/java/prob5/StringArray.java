package prob5;

public class StringArray {
	String item;
	StringArray pre;
	
	public StringArray(String item, StringArray pre) {
		this.item = item;
		this.pre = pre;
	}
	
	public StringArray getPre() {
		return pre;
	}
	
	public String getItem() {
		return item;
	}
}
