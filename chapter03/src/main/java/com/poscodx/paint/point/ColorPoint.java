package com.poscodx.paint.point;

public class ColorPoint extends Point {
	private String color;
	
	public ColorPoint(int x, int y, String color) {
		// 부모 필드가 모두 private으로 정의되어 있기 때문에 에러 발생
//		this.x = x;
		// 해결법 1. 부모 필드를 protected로 => 방법이 너무 구리다.
		// 해결법 2. setter 사용
//		setX(x);
//		setY(y);
		// 해결법 3. super 사용
		super(x, y);
		this.color = color;
	}

	@Override
	public void show() {
		System.out.printf(
				"점(x=%d, y=%d, color=%s)을 그렸습니다.\n", getX(), getY(), color);
	}
	
	
}
