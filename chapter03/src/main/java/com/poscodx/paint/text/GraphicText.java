package com.poscodx.paint.text;

import com.poscodx.paint.i.Drawable;

public class GraphicText implements Drawable {
	private String text;
	
	public GraphicText(String text) {
		this.text = text;
	}
	
	@Override
	public void draw() {
		System.out.printf("텍스트 '%s'를 그렸습니다.\n", text);

	}

}
