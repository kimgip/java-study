package chapter03;

import mypackage.Goods2;

public class DiscountGood2 extends Goods2 {
	private float discountRate = 0.5f;
	
	public float getDiscountPrice() {
		// protected는 자식에서 접근할 수 있다.
		return discountRate * price;
	}
}
