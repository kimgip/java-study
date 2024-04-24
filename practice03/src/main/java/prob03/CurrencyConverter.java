package prob03;

public class CurrencyConverter {
	private static double rate;

	public static void setRate(double r) {
		// 환율 설정(KRW/$1)
		rate = r;
	}

	public static double toDollar(double d) {
		// 한국 원화를 달러로 변환
		return d / rate;
	}

	public static double toKRW(double k) {
		// 달러를 한국 원화로 변환
		return k * rate;
	}

}
