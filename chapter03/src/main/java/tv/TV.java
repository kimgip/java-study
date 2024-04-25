package tv;

public class TV {
	private int volume;		// range 0 ~ 100 up down으로 범위 초과시 라운딩
	private int channel;	// range 1 ~ 255 up down으로 범위 초과시 라운딩
	private boolean power;
	
	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}

	public void status() {
		String powerStr;
		if (power) {
			powerStr = "on";
		} else {
			powerStr = "off";
		}
		System.out.printf("TV[power=%s, channel=%d, volume=%d]\n", powerStr, channel, volume);
		
	}

	public void power(boolean power) {
		this.power = power;
		
	}
	
	public void volume(int volume) {
		this.volume = volume;
		
		if (volume > 100) {
			this.volume = 0;
		} else if (volume < 0) {
			this.volume = 100;
		}
		
	}

	public void volume(boolean volume) {
		if (volume) {
			this.volume++;
		} else {
			this.volume--;
		}
		volume(this.volume);
		
	}
	
	public void channel(int channel) {
		this.channel = channel;
		
		if (channel > 255) {
			this.channel = 1;
		} else if (channel < 1) {
			this.channel = 255;
		}
		
	}

	public void channel(boolean channel) {
		if (channel) {
			this.channel++;
		} else {
			this.channel--;
		}
		channel(this.channel);
		
	}
	
	
}
